Feature: Search and Place the order for Products

@OffersPage
Scenario Outline: Search product in both Home and Offers page
Given User is on GreenCart Home page
When User searches with product shortname <VegetableName> to display product card
Then User searches with same shortname <VegetableName> in Offers page 
And Validate that the product name in Offers page matches with Home page

Examples:
|	VegetableName	|
|	Tom	|
|	Beet	|
