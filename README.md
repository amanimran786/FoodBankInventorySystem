Food Bank Inventory System - Full SQL Project
=============================================

Project Overview:
-----------------
This project builds a relational database system for managing multiple food banks, their inventories, donors, recipients, and food distributions. 
It enables efficient tracking of food donations, stock levels, expirations, and movements of inventory between different food banks.

Database Design Summary:
-------------------------
The database consists of the following tables:

- Food_Bank: Stores information about each food bank.
- Donor: Stores donor (individual or organization) information.
- Food_Item: Stores types of food items available.
- Inventory_Entry: Tracks current stock at each food bank.
- Recipient: Stores recipients who receive food aid.
- Distribution: Records food distributions from banks to recipients.
- Distributed_Item: Tracks specific food items distributed in each distribution.
- Inventory_Transfer: Records inventory transfers between food banks.

Core Features:
--------------
- Track and manage multiple food banks
- Record and view food donors and food items
- Track inventory stock per food bank
- Log inventory transfers between food banks
- Alert for low-stock food items
- Generate reports like total inventory per bank and most transferred food items
- Real sample data for demonstration
- Mathematical notation representation for relational operations (projection, selection, join)

Files Included:
---------------

**SQL Commands for Presentation (15 Total):**

BasicQ1FoodbankByName.sql
    - List names and address of all food banks, sorted alphabetically by foodbank name

BasicQ2InventoryEntry.sql
    - Count number of inventory entries for each item

BasicQ3NameWithS.sql
    - Show recipients whose name starts with “S”

BasicQ4StaffNameAndPlace.sql
    -List names of staff and the food bank they work at
 
BasicQ5InventoryIDandName.sql
    -Inventory ID and Item names of food whose quantity is less than 100

IntermediateQ1Donations.sql
    -List all food items and who donated them as well as quantity donated

IntermediateQ2RecipientsAndLocation.sql
    -Show recipients and the food bank that distributed to them

IntermediateQ3ShelfLife.sql
    -Desc: Show food items and their shelf life that are expiring within 6 months

IntermediateQ4Staff&Roles.sql
    -List all staff as well as which food bank they work at and their role

IntermediateQ5LastDist.sql
    -List the most recent distribution date for each recipient 

AdvancedQ1Top3Donors.sql
    - Top 3 donors based on the quantity of distributed food

AdvancedQ2HighestCanned.sql
    - Food bank that has distributed the highest amt of Canned Goods and how many they have distributed

AdvancedQ3HigherThanAvg.sql
    - Food banks that have distributed more food than the avg amount of items distributed by all food banks

AdvancedQ4Top5Highest.sql
    - Top 5 food banks with the highest total number of distributed items 

AdvancedQ5MoreThanAvgRecieved.sql
    - Show recipients who received more items than the avg recipient and the amount they have received 

**Mathematical Notation Queries (8 Total):**

BasicMathematical1.sql
    - Display information of Donors who are an organization

BasicMathematical2.sql
    - Name and Email of managers

BasicMathematical3.sql
    - List the names of Foodbank volunteers

BasicMathematical4.sql
    - List all the Food item names 

BasicMathematical5.sql
    - List foodbank ids that have inventory

IntermediateMathematical1.sql 
    - List the item ID and how many of that item were distributed
    
IntermediateMathematical2.sql
    - List item id, how many were donated, and the distribution date of items from 5/01 to 5/05


AdvancedMathematical.sql
    - Show food banks and their maximum distributed quantity for any item


Execution Instructions:
------------------------
1. Open MySQL Workbench.
2. Connect to your database server.
3. Run the `CREATE DATABASE` script to create the database (provided separately if needed).
4. Run the insert scripts to fill tables
5. Execute queries 

Presentation Flow Suggestion:
------------------------------
- Preload tables with file names with Insert
- Demonstrate 5 BASIC queries first
- Move to 5 INTERMEDIATE queries 
- Finish with 5 ADVANCED queries 
- After demonstration, present Mathematical Notation queries separately 
- Optionally discuss how the system can be expanded (e.g., adding automatic expiration alerts, automation).

Contact:
--------
Author: Aman Imran  
Email: abdullahimran234@gmail.com  
Date: 05/05/2025

Author: Albert Van
email: albertvan755891@gmail.com
=============================================

Thank you!
