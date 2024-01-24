-- Vi du 1
SELECT	c.CategoryID, c.CategoryName, 
		p.ProductID, p.ProductName
FROM Categories AS c, Products AS p
WHERE c.CategoryID = p.CategoryID
-- Vi du 2
SELECT	e.EmployeeID, e.FirstName, e.LastName, 
		COUNT(o.OrderID) AS "Total Orders"
FROM Employees AS e, Orders AS o
WHERE e.EmployeeID = o.EmployeeID
GROUP BY e.EmployeeID, e.FirstName, e.LastName
-- Vi du 3
SELECT	c.CustomerID, c.CompanyName, c.ContactName, 
		COUNT(o.OrderID) AS "Total Orders"
FROM Customers AS c, Orders AS o
WHERE c.CustomerID = o.CustomerID
GROUP BY c.CustomerID, c.CompanyName, c.ContactName
-- Vi du 4
SELECT	s.ShipperID, s.CompanyName, SUM(o.Freight) AS "Total Freight"
FROM Orders AS o, Shippers AS s
WHERE o.ShipVia = s.ShipperID
GROUP BY s.ShipperID, s.CompanyName
ORDER BY SUM(o.Freight) DESC
-- Vi du 5
SELECT TOP 1	s.SupplierID, s.CompanyName, 
				COUNT(p.ProductID) AS "Total Products"
FROM Products AS p, Suppliers AS s
WHERE p.SupplierID  = s.SupplierID
GROUP BY s.SupplierID, s.CompanyName
ORDER BY COUNT(p.ProductID) DESC
-- Vi du 6
SELECT	o.OrderID, c.CustomerID,
		SUM(od.UnitPrice * od.Quantity) AS "Total"
FROM Orders AS o, [Order Details] AS od, Customers AS c
WHERE o.OrderID = od.OrderID
GROUP BY o.OrderID, c.CustomerID
-- Vi du 7
SELECT	o.OrderID, e.FirstName, e.LastName, 
		SUM(od.UnitPrice * od.Quantity) AS "Total"
FROM [Order Details] AS od, Orders AS o, Employees AS e
WHERE od.OrderID = o.OrderID AND e.EmployeeID = o.EmployeeID
GROUP BY o.OrderID, e.FirstName, e.LastName
-- Bai tap 1
SELECT	o.OrderID, c.CustomerID, s.CompanyName
FROM Customers AS c, Orders AS o, Shippers AS s
WHERE	c.CustomerID = o.CustomerID AND 
		s.ShipperID = o.ShipVia AND
		o.ShipCountry = 'UK' AND
		YEAR(o.OrderDate) = 1997
GROUP BY o.OrderID, c.CustomerID, s.CompanyName