package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class orderNumFile
{
    //Creating a file
    public void CreateFile()
    {

        try {
            File myObj = new File("src//main//resources//OrderNumber.txt");
            myObj.createNewFile();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Writing to Created file
    public void WriteToFile(String arg1)
    {

        try {
            FileWriter myWriter = new FileWriter("src//main//resources//OrderNumber.txt");
            myWriter.write(arg1);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Read from File
    public String ReadFile()
    {
        String data = "";
        try {
            File myObj = new File("src//main//resources//OrderNumber.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}

