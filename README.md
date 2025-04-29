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

01_insert_food_banks.sql  
    - [BASIC] Insert sample food banks.

02_insert_donors.sql  
    - [BASIC] Insert sample donors.

03_insert_food_items.sql  
    - [BASIC] Insert sample food items.

04_insert_inventory_entries.sql  
    - [BASIC] Insert sample inventory entries.

05_insert_recipients.sql  
    - [BASIC] Insert sample recipients.

06_insert_distributions.sql  
    - [BASIC] Insert sample distributions.

07_insert_distributed_items.sql  
    - [BASIC] Insert sample distributed items.

08_insert_transfers.sql  
    - [BASIC] Insert sample transfers.

09_select_all_food_banks.sql  
    - [BASIC] View all food banks.

10_select_all_donors.sql  
    - [BASIC] View all donors.

11_select_all_food_items_sorted.sql  
    - [BASIC] View all food items sorted by shelf life.

12_select_all_recipients.sql  
    - [BASIC] View all recipients.

13_view_inventory_by_foodbank.sql  
    - [INTERMEDIATE] View inventory available at each food bank.

14_view_low_stock_items.sql  
    - [INTERMEDIATE] List food items with quantity less than 50 units.

15_view_transfer_history.sql  
    - [ADVANCED] View full transfer history showing movement between food banks.

**Mathematical Notation Queries (8 Total):**

M01_select_all_food_banks.sql  
    - [BASIC] Projection π on Food_Bank table.

M02_select_all_donors.sql  
    - [BASIC] Projection π on Donor table.

M03_select_all_food_items_sorted.sql  
    - [BASIC] Projection π + sort on Food_Item table.

M04_select_all_recipients.sql  
    - [BASIC] Projection π on Recipient table.

M05_insert_distributed_items.sql  
    - [BASIC] Insert operation into Distributed_Item relation.

M06_view_inventory_by_foodbank.sql  
    - [INTERMEDIATE] Join ⨝ between Inventory, Food_Bank, Food_Item.

M07_view_low_stock_items.sql  
    - [INTERMEDIATE] Join ⨝ and Selection σ on Inventory where Quantity < 50.

M08_view_transfer_history.sql  
    - [ADVANCED] Multi-Join ⨝ operation: Inventory_Transfer → Food_Item → Source Bank → Destination Bank.

Execution Instructions:
------------------------
1. Open MySQL Workbench.
2. Connect to your database server.
3. Run the `CREATE DATABASE` script to create the database (provided separately if needed).
4. Run the sample insert scripts (01-08) to populate the database.
5. Execute each of the SELECT query files (09-15) to demonstrate database functionality.
6. Use Mathematical Notation query files (M01-M08) to explain relational algebra logic separately.

Presentation Flow Suggestion:
------------------------------
- Start by running sample data scripts (01-08).
- Demonstrate BASIC queries first (09-12).
- Move to INTERMEDIATE queries (13-14).
- Finish with ADVANCED query (15).
- After demonstration, present Mathematical Notation queries separately (M01-M08).
- Optionally discuss how the system can be expanded (e.g., adding automatic expiration alerts, automation).

Contact:
--------
Author: Aman Imran  
Email: abdullahimran234@gmail.com  
Date: 05/05/2025

=============================================

Thank you!
