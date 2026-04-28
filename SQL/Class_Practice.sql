-- =========================================
-- DATABASE SETUP
-- =========================================

SHOW DATABASES;

CREATE DATABASE IF NOT EXISTS EMS;
USE EMS;

-- =========================================
-- TABLE CREATION
-- =========================================

CREATE TABLE employees (
    emp_id INT,
    emp_name VARCHAR(30),
    password VARCHAR(40) NOT NULL,
    emp_dept VARCHAR(40) NOT NULL,
    salary INT
);

CREATE TABLE users (
    emp_id INT,
    username VARCHAR(30),
    role VARCHAR(30)
);

DESCRIBE employees;

-- =========================================
-- INSERT DATA
-- =========================================

INSERT INTO employees VALUES
(101, 'Niti Dwivedi', 'pass@123', 'Training', 50000),
(102, 'Nitin Mehta', 'password@123', 'Admin', 60000),
(103, 'Jaya Kishori', 'jaya@123', 'Finance', 80000),
(104, 'Deepika', 'deep@123', 'Finance', 80000),
(105, 'Madan', 'mad@123', 'Admin', 80000),
(106, 'Shubham Dwivedi', 'pass@123', 'Training', 50000),
(107, 'Abhay Dwivedi', 'pass@123', 'Training', 50000);

-- Partial insert
INSERT INTO employees (emp_id, emp_name, password)
VALUES (108, 'Meenu Kumari', 'meenu@123');

SELECT * FROM employees;

-- =========================================
-- BASIC OPERATIONS
-- =========================================

SELECT salary + 2000 AS increment FROM employees;

-- UPDATE
UPDATE employees
SET password = 'Hello@123'
WHERE emp_id = 102;

SET SQL_SAFE_UPDATES = 0;

-- DELETE
DELETE FROM employees
WHERE emp_id = 103;

SELECT * FROM employees;

-- SORTING
SELECT emp_id, emp_name, salary
FROM employees
ORDER BY emp_id DESC;

-- TOP SALARY
SELECT *
FROM employees
ORDER BY salary DESC
LIMIT 2;

-- OFFSET example (3rd highest)
SELECT *
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 2;

-- =========================================
-- ALTER OPERATIONS
-- =========================================

ALTER TABLE employees ADD joiningdate DATETIME;

UPDATE employees SET joiningdate = NOW() WHERE salary = 50000;
UPDATE employees SET joiningdate = '2026-04-10 15:31:58' WHERE salary = 60000;
UPDATE employees SET joiningdate = '2026-04-15 15:31:58' WHERE salary = 80000;

RENAME TABLE employees TO emp_data;

SELECT * FROM emp_data;

ALTER TABLE emp_data
MODIFY emp_id INT AUTO_INCREMENT PRIMARY KEY;

DESCRIBE emp_data;

INSERT INTO emp_data (emp_name, password, emp_dept, salary, joiningdate)
VALUES ('Bhargavi', 'bhargav@123', 'Training', 67000, '2026-05-01 15:31:58');

-- =========================================
-- TASK: USE CASE QUERIES
-- =========================================

-- =========================
-- PART 1: SELECT QUERIES
-- =========================

-- Use Case 1: View all customers
SELECT * FROM emp_data;

-- Use Case 2: Employees in Finance Department
SELECT *
FROM emp_data
WHERE emp_dept = 'Finance';

-- Use Case 3: Salary above 60000
SELECT *
FROM emp_data
WHERE salary > 60000;

-- Use Case 4: Orders on specific date (Using joiningdate as reference)
SELECT *
FROM emp_data
WHERE DATE(joiningdate) = '2025-01-11';

-- Use Case 5: Sort by highest salary
SELECT emp_name, salary
FROM emp_data
ORDER BY salary DESC;

-- Use Case 6: Top 2 highest salary
SELECT *
FROM emp_data
ORDER BY salary DESC
LIMIT 2;

-- =========================
-- PART 2: UPDATE QUERIES
-- =========================

-- Use Case 7: Ravi moved city (Assuming column exists)
-- First add column if needed
ALTER TABLE emp_data ADD city VARCHAR(30);

UPDATE emp_data
SET city = 'Pune'
WHERE emp_name = 'Ravi';

-- Use Case 8: Restaurant cuisine (Not applicable → Example table)
-- Skipped since no restaurant table

-- Use Case 9: Order amount update (Assume salary as amount)
UPDATE emp_data
SET salary = 550
WHERE emp_id = 1001;

-- =========================
-- PART 3: DELETE QUERIES
-- =========================

-- Use Case 10: Delete customer with ID 3
DELETE FROM emp_data
WHERE emp_id = 3;

-- Use Case 11: Cancel order 1002
DELETE FROM emp_data
WHERE emp_id = 1002;

-- Use Case 12: Remove employees from Bangalore
DELETE FROM emp_data
WHERE city = 'Bangalore';

-- =========================================
-- SAFETY CHECK BEFORE DELETE
-- =========================================

SELECT * FROM emp_data WHERE emp_id = 3;