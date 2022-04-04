@BookHotel
Feature: Book hotel Feature

  Background: user logs in
    Given a user launches "chrome" and navigates to the Adactin web page "http://adactinhotelapp.com"
    When a user enters the "Thembamasemula" and "G9X3UI" and clicks login


  Scenario: Successful booking of a hotel
    And a user populates fields in the search page and clicks continue
    And a user selects a hotel from the selection page and click continue
    And a user populates the book with valid data and clicks confirm
    Then a order is generated and the booking is successful


  Scenario: Delete an existing booking
    And Clicks on Booked Itinerary
    And enters the order number for an existing order and clicks on search
    And a user clicks on cancel
    Then a confirm cancel popup message appears
    When a user clicks on ok
    Then booking is successfully cancelled
