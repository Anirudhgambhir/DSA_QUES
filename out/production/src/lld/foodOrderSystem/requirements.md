## Problem: Online Food Ordering System

A food delivery app needs a menu and ordering system with these requirements:

1. The app supports multiple restaurants. Each restaurant can prepare food differently, but every order goes through the same flow: accept order → prepare
   food → notify customer.

2. When an order's status changes (Placed, Preparing, Out for Delivery, Delivered), multiple parties need to be updated: the Customer, the Restaurant
   Dashboard, and the Delivery Driver app.

3. A meal can be customized with optional add-ons that stack:
    - Extra cheese (+₹30)
    - Extra sauce (+₹15)
    - Gift wrapping (+₹50)
    - Priority preparation (+₹100)

Each add-on modifies the price and the description of the meal. Add-ons can be combined in any order.

4. The payment method is selected at checkout based on what the user has configured:
    - Has UPI linked → UPI
    - Has wallet balance > order amount → Wallet
    - Default → Cash on Delivery