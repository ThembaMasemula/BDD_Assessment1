$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BookHotel.feature");
formatter.feature({
  "line": 2,
  "name": "Book hotel Feature",
  "description": "",
  "id": "book-hotel-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@BookHotel"
    }
  ]
});
formatter.before({
  "duration": 631590500,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "user logs in",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "a user launches \"chrome\" and navigates to the Adactin web page \"http://adactinhotelapp.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a user enters the \"AutoTestb\" and \"84JLRY\" and clicks login",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 17
    },
    {
      "val": "http://adactinhotelapp.com",
      "offset": 64
    }
  ],
  "location": "MyStepdefs.a_user_launches_and_navigates_to_the_Adactin_web_page(String,String)"
});
formatter.result({
  "duration": 8277618700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AutoTestb",
      "offset": 19
    },
    {
      "val": "84JLRY",
      "offset": 35
    }
  ],
  "location": "MyStepdefs.a_user_enters_the_and_and_clicks_login(String,String)"
});
formatter.result({
  "duration": 6690746700,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Successful booking of a hotel",
  "description": "",
  "id": "book-hotel-feature;successful-booking-of-a-hotel",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "a user populates fields in the search page and clicks continue",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "a user selects a hotel from the selection page and click continue",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "a user populates the book with valid data and clicks confirm",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "a order is generated and the booking is successful",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.a_user_populates_fields_in_the_search_page_and_clicks_continue()"
});
formatter.result({
  "duration": 33800325700,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_selects_a_hotel_from_the_selection_page_and_click_continue()"
});
formatter.result({
  "duration": 1399715200,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_populates_the_book_with_valid_data_and_clicks_confirm()"
});
formatter.result({
  "duration": 9073455100,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_order_is_generated_and_the_booking_is_successful()"
});
formatter.result({
  "duration": 10382900,
  "status": "passed"
});
formatter.after({
  "duration": 18000,
  "status": "passed"
});
formatter.before({
  "duration": 30762900,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "user logs in",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "a user launches \"chrome\" and navigates to the Adactin web page \"http://adactinhotelapp.com\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a user enters the \"AutoTestb\" and \"84JLRY\" and clicks login",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 17
    },
    {
      "val": "http://adactinhotelapp.com",
      "offset": 64
    }
  ],
  "location": "MyStepdefs.a_user_launches_and_navigates_to_the_Adactin_web_page(String,String)"
});
formatter.result({
  "duration": 6219417100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AutoTestb",
      "offset": 19
    },
    {
      "val": "84JLRY",
      "offset": 35
    }
  ],
  "location": "MyStepdefs.a_user_enters_the_and_and_clicks_login(String,String)"
});
formatter.result({
  "duration": 6380517100,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Delete an existing booking",
  "description": "",
  "id": "book-hotel-feature;delete-an-existing-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 17,
  "name": "Clicks on Booked Itinerary",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "enters the order number for an existing order and clicks on search",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "a user clicks on cancel",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "a confirm cancel popup message appears",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "a user clicks on ok",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "booking is successfully cancelled",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepdefs.clicks_on_Booked_Itinerary()"
});
formatter.result({
  "duration": 3207734200,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.enters_the_for_an_existing_order_and_clicks_on_search()"
});
formatter.result({
  "duration": 2450981000,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_clicks_on_cancel()"
});
formatter.result({
  "duration": 331442900,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_confirm_cancel_popup_message_appears()"
});
formatter.result({
  "duration": 9519900,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.a_user_clicks_on_ok()"
});
formatter.result({
  "duration": 9985700,
  "status": "passed"
});
formatter.match({
  "location": "MyStepdefs.booking_is_successfully_cancelled()"
});
formatter.result({
  "duration": 5963458500,
  "status": "passed"
});
formatter.after({
  "duration": 43600,
  "status": "passed"
});
});