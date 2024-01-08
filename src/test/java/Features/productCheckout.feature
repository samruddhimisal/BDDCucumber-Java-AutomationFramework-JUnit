Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Add the product to cart and checkout
Given User is on GreenCart Home page
When User searches with product shortname <VegetableName> to display product card
And Adds <ItemCount> items of selected product to cart
Then User proceeds to checkout and validates the <VegetableName> items count is <ItemCount> in checkout page
And User has the ability to enter promo code and place the order

Examples:
|	VegetableName	|	ItemCount	|
|	Tom	|	3	|
