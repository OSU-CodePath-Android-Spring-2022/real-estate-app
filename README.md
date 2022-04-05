Original App Design Project - README Template
===

# Real Estate App (temp title)

## Table of Contents
1. [Overview](#Overview)
2. [Product Spec](#Product-Spec)
3. [Wireframes](#Wireframes)
4. [Schema](#Schema)

## Overview
### Description
Android mobile application that will allow users to sign in to an account and then using a desired location parameter will be able to view and gain information regarding real estate properties that fit their desired parameter. User will also be able to view additional screens to include property descriptions and details provided from the listing agent's brokerage.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** House & Homes 
- **Mobile:** This app would be developed for mobile but the functionality would also be possible on a computer, such as Zillow, Realtor.com, or other similar apps. The mobile app is appealing for when the user is out looking at different properties and need to look at addresses or is interested in comparing property details on the spot. 
- **Story:** Lets users find listings of properties in their desired area, view the listing details, and save the properties to their wishlist.
- **Market:** Anyone looking to find a property to buy could find this app useful. Anyone interested in knowing house prices around them could find this app useful.
- **Habit:** The user would be compelled to use this app on a regular basis, especially if they are actively looking to buy.
- **Scope:** We would be able to complete this app in one month. We would start with the basic funtionality of the app first and then move in to the optional stories if we have time.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Users can enter an address they are curious about and the app will show them related listings within that town and/or other parameter.
* User can save and create lists of the properties they have viewed and add to their “wish list"
* User is able to click on a listing and it will bring them to a new screen that contains the specific details about that property.

**Optional Nice-to-have Stories**

* Users are able to add comments about a listing in a comment box.
* When viewing the details for a listing, user is able to be redirected to the listing agents website so that they may contact them about listing.

### 2. Screen Archetypes

* Login Screen - main screen if user is not logged in
   * Upon opening the app for the first time or after logging out, the user is taken to the login screen.
   * Login allows user to access data associated with their account (such as their wishlist).
   * If they do not have an account, user should be prompted to navigate to the register screen.
* Register Screen - can be accessed via a link or button at the bottom of the login screen
   * Similar to the login screen, but allows users to sign up for an account using their name, email, and password.
* Search Screen - main screen upon login
   * Upon entering an address, user will be navigated to a results screen.
* Results Screen - can be accessed by making a search or previous results can be seen by tapping the results tab
   * Allows user to view the results of their search (if any are found).
   * A listing includes data such as price, bedrooms, sq. footage, and photos.
   * Allows users to add a listing to their wishlist.
   * Allows user to see more details about a listing by tapping it.
* Detail Screen - can be accessed by tapping a listing in the results screen
   * Displays an expanded view of details about a property.
* Wishlist Screen - can be accessed by tapping the tab
   * Displays listings that were saved by the user.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Search
* Wishlist
* Results
* Signout

**Flow Navigation** (Screen to Screen)

* Login Page
   * Log In -> Sign up if not login is known
   * Log In -> Search
  
* Search
   * search homes (after inputting address) -> Results
   
* Results
  * heart -> adds to Wishlist
  * tap home picture -> goes to Details screen which contains more pictures, price, and additional info

* Wishlist
  * Contains all homes that were put on the wishlist by the user

* Sign Out
  * Sign Out -> Login Page

## Wireframes
<img src="assets/handsketched-wireframes.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]

### Existing API Endpoints
US Real Estate API
- Base URL - [https://rapidapi.com/datascraper/api/us-real-estate/](https://rapidapi.com/datascraper/api/us-real-estate/)

| HTTP Verb | Endpoint | Description |
| --------- | -------- | ----------- |
| GET | /v2/for-sale/?city=city&state_code=state_code&limit=limit&offset=offset | Get homes for sale given a city, state, limit on results returned, and results offset
