-- VD1
-- Khách hàng nào đã đặt đơn hàng nhiều hơn 20 hàng.
-- sắp xếp theo thứ tự tổng số đơn hàng giảm dần
SELECT CustomerID, COUNT(OrderID) AS "Total Orders"
FROM dbo.Orders
GROUP BY CustomerID
HAVING COUNT(OrderID) > 20
ORDER BY CustomerID DESC
-- VD2
-- Nhà cung cấp có số lượng hàng trong kho > 30 & Trung bình đơn giá < 50
SELECT	SupplierID, 
		SUM(UnitsInStock) AS "Total Units In Stock", 
		AVG(UnitPrice) AS "AVG Unit Price"
FROM dbo.Products
GROUP BY SupplierID 
HAVING SUM(UnitsInStock) > 30 AND AVG(UnitPrice) < 50
-- VD3
-- Tổng tiền vận chuyển của từng tháng, trong nửa năm sau của 1996, sap xep tang dan
-- Tổng tiền vận chuyển > 1000
SELECT MONTH(ShippedDate) AS "Month", SUM(Freight) AS "Total Freight"
FROM dbo.Orders
WHERE ShippedDate BETWEEN '1996-07-01' AND '1996-12-31'
GROUP BY MONTH(ShippedDate)
HAVING SUM(Freight) > 1000
ORDER BY MONTH(ShippedDate) ASC
-- BAI TAP
-- Thành phố có số lượng đơn hàng >16, sắp xếp theo tổng số lượng giảm dần
SELECT ShipCity, COUNT(OrderID) AS "Total Orders"
FROM dbo.Orders
GROUP BY ShipCity
HAVING COUNT(OrderID) > 16
ORDER BY COUNT(OrderID) DESC
