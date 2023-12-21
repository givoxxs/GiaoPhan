-- JOIN / INNER JOIN
-- VD1
SELECT o.OrderID, c.CompanyName
FROM Orders o
INNER JOIN Customers c 
ON o.CustomerID = c.CustomerID
-- VD2
SELECT c.CategoryID, c.CategoryName, p.ProductID, p.ProductName
FROM Categories c
INNER JOIN Products p
ON c.CategoryID = p.CategoryID
-- VD3
SELECT c.CategoryID, c.CategoryName, COUNT(p.ProductID) AS [Total Products]
FROM Categories c
INNER JOIN Products p
ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID, c.CategoryName
/****** Script for SelectTopNRows command from SSMS ******/
SELECT TOP (1000) [CategoryID]
		, [CategoryName]
		, [Description]
		, [Picture]
FROM [NORTHWND].[dbo].[Categories]
-- VD ve LEFT JOIN
SELECT c.CategoryID, c.CategoryName, p.ProductID, p.ProductName
FROM Categories c
LEFT JOIN Products p
ON c.CategoryID = p.CategoryID

SELECT c.CategoryID, c.CategoryName, COUNT(p.ProductID) AS TOTAL 
FROM Categories c
LEFT JOIN Products p
ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID, c.CategoryName
-- VD ve RIGHT JOIN
SELECT c.CategoryID, c.CategoryName, p.ProductID, p.ProductName
FROM Categories c
RIGHT JOIN Products p
ON c.CategoryID = p.CategoryID

SELECT c.CategoryID, c.CategoryName, COUNT(p.ProductID) AS TOTAL 
FROM Categories c
RIGHT JOIN Products p
ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID, c.CategoryName
-- Bai tap
-- Sử dụng RIGHT JOIN, hãy in ra các thông tin sau đây:
-- Mã đơn hăng
-- Tên công ty khách hàng
SELECT o.OrderID, c.CompanyName
FROM Orders o
RIGHT JOIN Customers c 
ON o.CustomerID = c.CustomerID

SELECT c.CompanyName, COUNT(o.OrderID)
FROM Orders o
RIGHT JOIN Customers c 
ON o.CustomerID = c.CustomerID
GROUP BY c.CompanyName
-- Sử dụng FULL OUTER JOIN
-- Từ bảng Products và Categories, hãy in ra các thông tin sau đây:
-- Mã thể loại
-- Tên thể loại
-- Mã sản phẩm
-- Tên sản phẩm
SELECT c.CategoryID, c.CategoryName, p.ProductID, p.ProductName
FROM Categories c
FULL JOIN Products p
ON c.CategoryID = p.CategoryID


-- BAI TAP 
-- Câu hỏi 1 (INNER JOIN): Hãy liệt kê tên nhân viên và tên khách hàng của các đơn hàng trong bảng "Orders".
SELECT e.LastName, e.FirstName, c.ContactName
FROM Orders o 
INNER JOIN Customers c
	ON o.CustomerID = c.CustomerID
INNER JOIN Employees e
	ON e.EmployeeID = o.EmployeeID
-- Câu hỏi 2 (LEFT JOIN): Hãy liệt kê tên nhà cung cấp và tên sản phẩm của các sản phẩm trong bảng "Products", 
-- bao gồm cả các sản phẩm không có nhà cung cấp.
SELECT s.ContactName, p.ProductName
FROM Products p
LEFT JOIN Suppliers s
	ON p.SupplierID = s.SupplierID
-- Câu hỏi 3 (RIGHT JOIN): Hãy liệt kê tên khách hàng và tên đơn hàng của các
-- đơn hàng trong bảng "Orders", bao gồm cả các khách hàng không có đơn hàng.
SELECT c.ContactName, o.ShipName
FROM Orders o
RIGHT JOIN Customers c
	ON o.CustomerID = c.CustomerID
-- Câu hỏi 4 (FULL JOIN): Hãy liệt kê tên danh mục và tên nhà cung cấp của các
-- sản phẩm trong bảng "Products", bao gồm cả các danh mục và nhà cung cấp không có sản phẩm.
SELECT c.CategoryName, s.CompanyName
FROM Products p
FULL JOIN Categories c
	ON c.CategoryID = p.CategoryID
FULL JOIN Suppliers s
	ON s.SupplierID = p.SupplierID