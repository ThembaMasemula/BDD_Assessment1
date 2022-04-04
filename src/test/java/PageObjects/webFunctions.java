package PageObjects;

import WebPageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WebPageObjects.seleHotel;
import webUtilities.webActions;
import Data.*;

public class webFunctions extends webActions
{
    orderNumFile numberFile = new orderNumFile();

    public void Login(WebDriver driver, String strUsername, String strPassword){
        loginAdactin log = new loginAdactin(driver);

        try {
            enterData(log.txtUsernme, driver ,strUsername);

            enterData(log.txtPassword, driver ,strPassword);

            clickObject(log.btnLogin,driver);

            if(!driver.getCurrentUrl().contains("SearchHotel")){
                System.out.println("Invalid Login details or Your Password might have expired.");
            }
            else {
                System.out.println("Logged In Successfully.");
            }

        }catch (Exception e) {
            System.out.println("Login unsuccessful,Errors"+e.getMessage());
        }
    }

    public  void search (WebDriver driver, String strLocation,String strHotels,String strRoomType,String strNumberOfRooms,String strCheckInDate,String strCheckOutDate,String strAdultsPerRoom,String strChildrenPerRoom) {

        WebPageObjects.searchHotel search = new WebPageObjects.searchHotel(driver);

        try {

            selectObject(search.location,driver ,"selectByVisibleText", strLocation);
            selectObject(search.hotels, driver,"selectByVisibleText",strHotels);
            selectObject(search.room_type,driver, "selectByVisibleText",strRoomType);
            selectObject(search.room_no, driver,"selectByVisibleText", strNumberOfRooms);
            enterData(search.check_in_date, driver ,strCheckInDate);
            enterData(search.check_out_date, driver , strCheckOutDate);
            selectObject(search.adults, driver, "selectByVisibleText",strAdultsPerRoom);
            selectObject(search.children, driver, "selectByVisibleText",strChildrenPerRoom);
            clickObject(search.submit,driver);

            if(driver.getCurrentUrl().contains("SelectHotel"))
            {
                System.out.println("Searched Successfully.");
            }
            else {
                System.out.println("Invalid hotel search details.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public  void select_Hotel (WebDriver driver)
    {
        seleHotel selHotel = new seleHotel(driver);

        try {

            clickObject(selHotel.sel_hotel, driver);
            clickObject(selHotel.contin, driver);

            if(driver.getCurrentUrl().contains("BookHotel"))
            {
                System.out.println("Selected Successfully.");
            }
            else {
                System.out.println("Invalid hotel search details.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  void Book_hotel (WebDriver driver, String FirstName,String LastName,String BilingAddress,String CreditCardNumber,String CreditCardType,String ExpiryDateMonth,String ExpiryDateYear,String CVVNumber)
    {

        bookHotel bookHotel = new bookHotel(driver);
        numberFile.CreateFile();
        try {
            enterData(bookHotel.firstname, driver , FirstName);
            enterData(bookHotel.surname, driver , LastName);
            enterData(bookHotel.billing, driver , BilingAddress);

            enterData(bookHotel.account, driver , CreditCardNumber);
            selectObject(bookHotel.account_type, driver, "selectByVisibleText", CreditCardType);
            selectObject(bookHotel.month, driver, "selectByVisibleText", ExpiryDateMonth);
            selectObject(bookHotel.year, driver, "selectByVisibleText", ExpiryDateYear);
            enterData(bookHotel.cvv, driver , CVVNumber);

            clickObject(bookHotel.book,driver);
            WebElement ordernumber =bookHotel.orderno;
            ordernumber.getAttribute("value");

            //Writing Order Number to File
            numberFile.WriteToFile(ordernumber.getAttribute("value"));

            if(driver.getCurrentUrl().contains("BookingConfirm"))
            {
                System.out.println("Booked Successfully.");
            }
            else {
                System.out.println("Invalid hotel search details.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String OrderNum()
    {
        return numberFile.ReadFile();
    }

    public  void logout (WebDriver driver)
    {
        logout logout = new logout(driver);

        try {
            clickObject(logout.logout,driver);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void LoggedOutSuccessfully(WebDriver driver)
    {
//        if(driver.getCurrentUrl().contains("Logout"))
//        {
//            System.out.println("Logged out Successful");
//        }
    }
    public void BookedItinerary(WebDriver driver)
    {
        menuItems MenuItems = new menuItems(driver);
        MenuItems.bookedItinerary.click();
    }

    public void SearchExistingOrder(WebDriver driver, String arg0)
    {
        searchBooking sb = new searchBooking(driver);
        enterData(sb.txtsearchOrderID,driver,arg0);
        clickObject(sb.btnSearchOrder,driver);
    }

    public void ConfirmsTheBooking(WebDriver driver) {
        searchBooking sb = new searchBooking(driver);

        if(sb.txtorderid.getText().contains("1 result")){
            System.out.println("Booking Successfully found");
         }
        else{
            System.out.println("Booking does not exist");
        }
    }
    public void ClicksOnCancel(WebDriver driver)
    {
        searchBooking sb = new searchBooking(driver);
        clickObject(sb.btnRadio,driver);
        clickObject(sb.btnDelete,driver);
    }
    public void PopupMessage(WebDriver driver)
    {
        if(driver.switchTo().alert().getText().contains("Are you sure")){
            System.out.println("popup message appears");
        }
    }

    public void ClicksOnPopupOk(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }

    public void SuccessfullyCancelled(WebDriver driver, String arg1)
    {
        SearchExistingOrder(driver, arg1);
        confirmDelete cd = new confirmDelete(driver);
        if(cd.errDeleteConfirmation.isDisplayed())
        {
            System.out.println("Booking has been successfully cancelled.");
        }
    }

}
