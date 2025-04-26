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

Files Included:
---------------

00_sample_data.sql
    - Inserts sample food banks, donors, food items, inventory entries, recipients, distributions, and transfer records for demo purposes.

01_view_food_banks.sql
    - [BASIC] View all food banks.

02_view_donors.sql
    - [BASIC] View all donors.

03_view_food_items.sql
    - [BASIC] View all food items, sorted by shelf life.

04_view_recipients.sql
    - [BASIC] View all recipients.

05_inventory_by_foodbank.sql
    - [INTERMEDIATE] View current inventory available at each food bank.

06_low_stock_items.sql
    - [INTERMEDIATE] List food items with quantity less than 50 units.

07_transfer_history.sql
    - [ADVANCED] View full transfer history showing movement between food banks.

08_most_transferred_items.sql
    - [ADVANCED] Show food items that have been transferred the most between banks.

09_banks_with_most_inventory.sql
    - [ADVANCED] Show food banks with the highest total inventory.

Execution Instructions:
------------------------
1. Open MySQL Workbench.
2. Connect to your database server.
3. Run the `CREATE DATABASE` script to create the database (provided separately if needed).
4. Run `00_sample_data.sql` to insert sample records into the database.
5. Execute each of the query files (01 through 09) to demonstrate database functionality.

Presentation Flow Suggestion:
------------------------------
- Start by running sample data script.
- Then run BASIC queries first (01-04).
- Move to INTERMEDIATE queries (05-06).
- Finish with ADVANCED queries (07-09).
- Optionally discuss how the system can be expanded (e.g., adding automatic alerts for expirations).

Contact:
--------
Author: [Your Name]
Email: [Your Email] (optional)
Date: [Presentation Date]

=============================================

Thank you!
