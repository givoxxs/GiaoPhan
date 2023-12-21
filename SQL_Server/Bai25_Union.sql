-- UNION / UNION ALL
-- Truy van 1 -- 22
SELECT od.OrderID
FROM [dbo]. [Order Details] od
WHERE [UnitPrice] BETWEEN 100 AND 200;
-- Truy van 2 -- 433
SELECT od.OrderID
FROM [dbo]. [Order Details] od
WHERE od.Quantity IN (10,20)
-- Truy van 3 -- 7
SELECT od.OrderID
FROM [dbo]. [Order Details] od
WHERE [UnitPrice] BETWEEN 100 AND 200
	AND od.Quantity IN (10,20)
-- Truy van 4 -- 448
SELECT od.OrderID
FROM [dbo]. [Order Details] od
WHERE [UnitPrice] BETWEEN 100 AND 200
	OR od.Quantity IN (10,20)
-- Truy van 5 -- 360 Dong
SELECT DISTINCT od.OrderID
FROM [dbo]. [Order Details] od
WHERE [UnitPrice] BETWEEN 100 AND 200
	OR od.Quantity IN (10,20)
-- UNION = 360
	SELECT od.OrderID
	FROM [dbo]. [Order Details] od
	WHERE [UnitPrice] BETWEEN 100 AND 200
UNION
	SELECT od.OrderID
	FROM [dbo]. [Order Details] od
	WHERE od.Quantity IN (10,20)
-- UNION ALL = 455
	SELECT od.OrderID
	FROM [dbo]. [Order Details] od
	WHERE [UnitPrice] BETWEEN 100 AND 200
UNION ALL
	SELECT od.OrderID
	FROM [dbo]. [Order Details] od
	WHERE od.Quantity IN (10,20)
-- VD3
-- UNION = 93
	SELECT s.Country, s.City
	FROM dbo.Suppliers s
UNION
	SELECT c.Country, c.City 
	FROM dbo.Customers c
-- UNION ALL = 120
	SELECT s.Country, s.City
	FROM dbo.Suppliers s
UNION ALL
	SELECT c.Country, c.City 
	FROM dbo.Customers c
-- UNION DISTINCT = 93
	SELECT DISTINCT s.Country, s.City
	FROM dbo.Suppliers s
UNION
	SELECT DISTINCT c.Country, c.City 
	FROM dbo.Customers c
-- UNION ALL + DISTINCT = 98
	SELECT DISTINCT s.Country, s.City
	FROM dbo.Suppliers s
UNION ALL
	SELECT DISTINCT c.Country, c.City 
	FROM dbo.Customers c
