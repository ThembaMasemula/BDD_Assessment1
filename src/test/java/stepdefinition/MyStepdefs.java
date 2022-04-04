package stepdefinition;

import PageObjects.webFunctions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webUtilities.webUtilities;
import Data.*;

import java.sql.ResultSet;

public class MyStepdefs {
    webUtilities web = new webUtilities();
    webFunctions adactin = new webFunctions();
     DatabaseConn datafile = new DatabaseConn();
    orderNumFile NumFile;

    ResultSet rs;
    @Before
    public void test()
    {
        NumFile = new orderNumFile();
        try{
           rs = datafile.ConnectAndQuerySQL("jdbc:mysql://127.0.0.1/adactinhotel", "root", "root", "select * from bookings");
        }
        catch (Exception e)
        {
           System.out.println(e.getMessage());
        }
    }

    //Background
    @Given("^a user launches \"(.*?)\" and navigates to the Adactin web page \"(.*?)\"$")
    public void a_user_launches_and_navigates_to_the_Adactin_web_page(String arg1, String arg2) {

        web.initializeWebDriver(arg1);
        web.navigate(arg2);
    }

    @When("^a user enters the \"(.*?)\" and \"(.*?)\" and clicks login$")
    public void a_user_enters_the_and_and_clicks_login(String arg1, String arg2) {
        adactin.Login(web.getWebDriver(), arg1, arg2);
    }

    //Scenario: Book Hotel
    @When("^a user populates fields in the search page and clicks continue")
    public void a_user_populates_fields_in_the_search_page_and_clicks_continue()
    {
        try {
            while(rs.next())
            {
                adactin.search(web.getWebDriver(),rs.getString("Location"),rs.getString("Hotels"),rs.getString("RoomType"),rs.getString("NumberOfRooms"),rs.getString("CheckInDate"),rs.getString("CheckOutDate"),rs.getString("AdultsPerRoom"),rs.getString("ChildrenPerRoom"));
            }
            rs.beforeFirst();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @When("^a user selects a hotel from the selection page and click continue$")
    public void a_user_selects_a_hotel_from_the_selection_page_and_click_continue() {
        adactin.select_Hotel(web.getWebDriver());
    }

    @When("^a user populates the book with valid data and clicks confirm")
    public void a_user_populates_the_book_with_valid_data_and_clicks_confirm() {
        try{

            while (rs.next())
            {
                adactin.Book_hotel(web.getWebDriver(),rs.getString("FirstName"),rs.getString("LastName"),rs.getString("BillingAddress"),rs.getString("CreditCardNumber"), rs.getString("CreditCardType"),rs.getString("ExpiryDateMonth"),rs.getString("ExpiryDateYear"),rs.getString("CVVNumber"));
            }
        }
        catch (Exception e){System.out.println(e.getMessage());}
    }

    @Then("^a order is generated and the booking is successful$")
    public void a_order_is_generated_and_the_booking_is_successful()
    {
        System.out.println(adactin.OrderNum());
    }

    //Scenario: Delete Booking
    @When("^Clicks on Booked Itinerary$")
    public void clicks_on_Booked_Itinerary()
    {
        adactin.BookedItinerary(web.getWebDriver());
    }

    @When("^enters the order number for an existing order and clicks on search$")
    public void enters_the_for_an_existing_order_and_clicks_on_search()
    {
        String TempOrderNum = NumFile.ReadFile();
        adactin.SearchExistingOrder(web.getWebDriver(),TempOrderNum);
    }

    @Then("^a user confirms the booking$")
    public void a_user_confirms_the_booking() {
        adactin.ConfirmsTheBooking(web.getWebDriver());
    }

    @When("^a user clicks on cancel$")
    public void a_user_clicks_on_cancel()
    {
        adactin.ClicksOnCancel(web.getWebDriver());
    }

    @Then("^a confirm cancel popup message appears$")
    public void a_confirm_cancel_popup_message_appears()
    {
        adactin.PopupMessage(web.getWebDriver());
    }

    @When("^a user clicks on ok$")
    public void a_user_clicks_on_ok() {
        adactin.ClicksOnPopupOk(web.getWebDriver());
    }

    @Then("^booking is successfully cancelled$")
    public void booking_is_successfully_cancelled()
    {
        String TempOrderNum = NumFile.ReadFile();
        adactin.SuccessfullyCancelled(web.getWebDriver(), TempOrderNum);
    }

    @After
    public void logOutClose() throws InterruptedException
    {
        adactin.logout(web.getWebDriver());
        adactin.LoggedOutSuccessfully(web.getWebDriver());
        Thread.sleep(3000);
        web.getWebDriver().close();
    }

}
