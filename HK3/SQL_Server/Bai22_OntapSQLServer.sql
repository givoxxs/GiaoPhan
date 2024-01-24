-- Bai tap 1
-- Những khách hàng đã đặt nhiều hơn 20 đơn, sắp xếp tổng đơn hàng hàng giảm dần
SELECT	CustomerID, 
		COUNT(OrderID) AS "Totel Orders"
FROM dbo.Orders
GROUP BY CustomerID
HAVING COUNT(OrderID) > 20
ORDER BY COUNT(OrderID) DESC
-- Bai tap 2
-- Lọc ra các nhân viên có tổng hợp có tổng đơn hàng >= 100, sắp xếp theo số đơn hàng giảm dần.
SELECT	EmployeeID, 
		COUNT(OrderID) AS "Total Orders"
FROM dbo.Orders
GROUP BY EmployeeID
HAVING COUNT(OrderID) >= 100
ORDER BY COUNT(OrderID) DESC
-- Bai tap 3
-- Thể loại có số sản phẩm khác nhau >= 11
SELECT	CategoryID, 
		COUNT(ProductID) AS "Total Product"
FROM dbo.Products
GROUP BY CategoryID
HAVING COUNT(ProductID) >= 11
-- Bai tap 4
-- Thể loại có tổng số sản phẩm trong kho > 350
SELECT	CategoryID, 
		SUM(UnitsInStock) AS "Total Units In Stock"
FROM dbo.Products
GROUP BY CategoryID
HAVING SUM(UnitsInStock) > 350
-- Bai tap 5
-- Quoc gia co nhieu hon 7 khach hang
SELECT	ShipCountry, 
		COUNT(CustomerID) AS "Total Customers"
FROM Orders
GROUP BY ShipCountry
HAVING COUNT(CustomerID) > 7
-- Bai tap 6
-- Những ngày có nhiều hơn 5 đơn hàng được giao, tăng dần theo ngày giao hàng
SELECT	ShippedDate, 
		COUNT(*) AS "Total Orders"
FROM Orders
GROUP BY ShippedDate
HAVING COUNT(*) > 5
ORDER BY ShippedDate ASC
-- Bai tap 7
-- Hãy cho biết những quốc gia bắt đầu bằng chữ 'A' hoặc chữ 'G'
-- Có số đơn hàng > 29
SELECT	ShipCountry, 
		COUNT(*) AS "Total Orders"
FROM Orders
WHERE ShipCountry LIKE '[A,G]%'
GROUP BY ShipCountry
HAVING COUNT(*) > 29
-- Bai tap 8
-- Hãy cho biết những thành phố nào có đơn hàng được giao <> 1 , 2; 
-- Dat hang Từ 1997-04-01 --> 1997-08-31
SELECT	ShipCity,
		COUNT(*) AS "Total Orders"
FROM Orders
WHERE OrderDate BETWEEN '1997-04-01' AND '1997-08-31'
GROUP BY ShipCity
HAVING COUNT(*) NOT IN (1,2)
