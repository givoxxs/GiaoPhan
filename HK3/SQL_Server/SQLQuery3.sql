SELECT CustomerID, MONTH(OrderDate) AS "Month", COUNT(*) AS "Total Orders"
FROM dbo.Orders
WHERE YEAR(OrderDate) = 1998
GROUP BY CustomerID, MONTH(OrderDate)

---

