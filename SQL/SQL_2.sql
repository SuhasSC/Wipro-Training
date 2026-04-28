-- =========================================
-- ACTIVITY 1: DATABASE DESIGN & CREATION
-- METHODS USED: DDL (CREATE)
-- =========================================

-- TASK 1: CREATE DATABASE
CREATE DATABASE IF NOT EXISTS QuickBite;
USE QuickBite;

-- TASK 2: CREATE TABLES

-- Customers Table
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    city VARCHAR(50)
);

-- Restaurants Table
CREATE TABLE Restaurants (
    restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    cuisine_type VARCHAR(50),
    city VARCHAR(50)
);

-- Orders Table (with relationships)
CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    restaurant_id INT,
    order_amount DECIMAL(10,2),
    order_date DATE,
    
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

-- =========================================
-- ACTIVITY 2: DATA INSERTION & QUERY OPERATIONS
-- METHODS USED: DML (INSERT, UPDATE, DELETE), DQL (SELECT)
-- =========================================

-- TASK 1: INSERT DATA

INSERT INTO Customers (name, email, city) VALUES
('Suhas', 'suhas@gmail.com', 'Mysore'),
('Rahul', 'rahul@gmail.com', 'Bangalore'),
('Ananya', 'ananya@gmail.com', 'Delhi');

INSERT INTO Restaurants (name, cuisine_type, city) VALUES
('Pizza Palace', 'Italian', 'Bangalore'),
('Spice Hub', 'Indian', 'Mysore'),
('Burger Town', 'Fast Food', 'Delhi');

INSERT INTO Orders (customer_id, restaurant_id, order_amount, order_date) VALUES
(1, 2, 250.50, '2026-04-28'),
(2, 1, 500.00, '2026-04-27'),
(3, 3, 150.75, '2026-04-26');

-- TASK 2: BASIC SELECT

SELECT * FROM Customers;
SELECT * FROM Restaurants;
SELECT * FROM Orders;

-- TASK 3: JOIN QUERY

SELECT 
    c.name AS customer_name,
    r.name AS restaurant_name,
    o.order_amount,
    o.order_date
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Restaurants r ON o.restaurant_id = r.restaurant_id;

-- TASK 4: USE CASE SELECT QUERIES

-- View all customers
SELECT * FROM Customers;

-- Customers from Mysore
SELECT * FROM Customers
WHERE city = 'Mysore';

-- Orders above ₹300
SELECT * FROM Orders
WHERE order_amount > 300;

-- Orders on specific date
SELECT * FROM Orders
WHERE order_date = '2026-04-28';

-- Sort by highest order amount
SELECT * FROM Orders
ORDER BY order_amount DESC;

-- Top 2 highest orders
SELECT * FROM Orders
ORDER BY order_amount DESC
LIMIT 2;

-- TASK 5: UPDATE QUERIES

SET SQL_SAFE_UPDATES = 0;

UPDATE Customers
SET city = 'Pune'
WHERE name = 'Ravi';

UPDATE Restaurants
SET cuisine_type = 'Fast Food'
WHERE name = 'Pizza Palace';

UPDATE Orders
SET order_amount = 550
WHERE order_id = 1;

-- TASK 6: DELETE QUERIES

-- Check before delete
SELECT * FROM Customers WHERE customer_id = 3;

-- Delete customer
DELETE FROM Customers
WHERE customer_id = 3;

-- Cancel order
DELETE FROM Orders
WHERE order_id = 2;

-- Remove restaurants from Bangalore
DELETE FROM Restaurants
WHERE city = 'Bangalore';

-- TASK 7: VERIFICATION

SHOW TABLES;

SELECT * FROM Customers;
SELECT * FROM Restaurants;
SELECT * FROM Orders;

-- JOIN after operations
SELECT 
    c.customer_id,
    c.name AS customer_name,
    r.name AS restaurant_name,
    o.order_amount,
    o.order_date
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Restaurants r ON o.restaurant_id = r.restaurant_id;

-- Describe tables
DESCRIBE Customers;
DESCRIBE Restaurants;
DESCRIBE Orders;

-- =========================================
-- ACTIVITY 3: TABLE MODIFICATION
-- METHODS USED: DDL (ALTER, TRUNCATE, RENAME)
-- =========================================

-- TASK 1: ALTER TABLE

-- Add new column
ALTER TABLE Customers
ADD phone VARCHAR(15);

-- Modify column
ALTER TABLE Customers
MODIFY name VARCHAR(150);

-- Rename column
ALTER TABLE Customers
RENAME COLUMN city TO location;

-- Add column to Orders
ALTER TABLE Orders
ADD status VARCHAR(20);

-- TASK 2: TRUNCATE TABLE

TRUNCATE TABLE Orders;

-- TASK 3: RENAME TABLE

RENAME TABLE Customers TO Users;

