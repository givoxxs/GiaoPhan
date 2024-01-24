-- vd 1 Tim kiem cac san pham thuoc muc Seafood.
SELECT c.CategoryID, c.CategoryName, p.ProductID, p.ProductName
FROM dbo.Products as p, dbo.Categories as c
WHERE c.CategoryID = p.CategoryID 
	  AND c.CategoryName = 'Seafood'
ORDER BY p.ProductName
-- VD2 
-- Cac san pham duoc cung cap tu nuoc Germany
SELECT	p.SupplierID, s.Country, p.ProductID, p.ProductName
FROM	dbo.Products p, dbo.Suppliers s
WHERE	p.SupplierID = s.SupplierID 
		AND s.Country = 'Germany'
-- VD 3
-- Cac don hang den tu London
SELECT	o.OrderID, c.ContactName, s.CompanyName
FROM	dbo.Orders o, dbo.Customers c, dbo.Shippers s
WHERE	o.CustomerID = c.CustomerID
		AND s.ShipperID = o.ShipVia
		AND c.City = 'London'
-- VD 4
-- Cac don hang bi giao muon hon quy dinh
SELECT o.OrderID, c.ContactName, s.CompanyName, o.RequiredDate, o.ShippedDate
FROM dbo.Orders o, dbo.Customers c, dbo.Shippers s
WHERE o.CustomerID = c.CustomerID
	  AND o.ShipVia = s.ShipperID
	  AND RequiredDate < ShippedDate
-- EXERCISE
-- Give these shipcountries for which customers don't come from the United States.
-- Select only this countries which is over than 100 orders.
-- Display Shipcountry and Number of orders
SELECT o.ShipCountry, COUNT(o.OrderID) AS [Total Order] 
FROM dbo.Orders o, dbo.Customers c, dbo.Shippers s
WHERE o.CustomerID = c.CustomerID
	 AND o.ShipVia = s.ShipperID
	 AND NOT o.ShipCountry = 'USA'
GROUP BY o.ShipCountry
HAVING COUNT(o.OrderID) > 100

