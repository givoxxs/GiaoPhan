SELECT CustomerID, MONTH(OrderDate) AS "Month", COUNT(*) AS "Total Orders"
FROM dbo.Orders
WHERE YEAR(OrderDate) = 1998
GROUP BY CustomerID, MONTH(OrderDate)
--
SELECT *
FROM dbo.Orders
WHERE MONTH(ShippedDate) = 5
ORDER BY YEAR(ShippedDate)