CREATE DATABASE QuickBite;
USE QuickBite;

CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    city VARCHAR(50)
);

CREATE TABLE Restaurants (
    restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    cuisine_type VARCHAR(50),
    city VARCHAR(50)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    restaurant_id INT,
    order_amount DECIMAL(10,2),
    order_date DATE,
    
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id)
);

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

SELECT * FROM Customers;
SELECT * FROM Restaurants;
SELECT * FROM Orders;

SELECT 
    c.name AS customer_name,
    r.name AS restaurant_name,
    o.order_amount,
    o.order_date
FROM Orders o
JOIN Customers c ON o.customer_id = c.customer_id
JOIN Restaurants r ON o.restaurant_id = r.restaurant_id;