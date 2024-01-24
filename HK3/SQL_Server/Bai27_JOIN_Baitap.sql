-- • Bài tập 1 (INNER JOIN): Liệt kê tên sản phẩm và tên nhà cung cấp của các sản phẩm đã được đặt hàng trong bảng "Order Details". 
-- Sử dụng INNER JOIN để kết hợp bảng "Order Details" với các bảng liên quan để lấy thông tin sản phẩm và nhà cung cấp.
SELECT DISTINCT od.ProductID, p.ProductName, s.CompanyName
FROM dbo.[Order Details] od
JOIN Products p ON od.ProductID = p.ProductID
JOIN Suppliers s ON s.SupplierID = p.SupplierID
-- Bài tập 2 (LEFT JOIN): Liệt kê tên khách hàng và tên nhân viên phụ trách của các đơn hàng trong bảng "Orders". 
-- Bao gồm cả các đơn hàng không có nhân viên phụ trách. 
-- Sử dụng LEFT JOIN để kết hợp bảng "Orders" với bảng "Employees" để lấy thông tin về khách hàng và nhân viên phụ trách.
SELECT o.OrderID, c.CompanyName, e.FirstName, e.LastName
FROM dbo.Orders o
LEFT JOIN Customers c ON c.CustomerID = o.CustomerID
LEFT JOIN Employees e ON e.EmployeeID = o.EmployeeID
-- • Bài tập 3 (RIGHT JOIN): Liệt kê tên khách hàng và tên nhân viên phụ trách của các đơn hàng trong bảng "Orders". 
-- Bao gồm cả các khách hàng không có đơn hàng. 
-- Sử dụng RIGHT JOIN để kết hợp bảng "Orders" với bảng "Customers" để lấy thông tin về khách hàng và nhân viên phụ trách.
SELECT o.OrderID, c.CompanyName, e.FirstName, e.LastName
FROM Orders o
RIGHT JOIN Customers c ON c.CustomerID = o.CustomerID
RIGHT JOIN Employees e ON e.EmployeeID = o.EmployeeID
-- • Bài tập 4 (FULL JOIN): Liệt kê tên danh mục và tên nhà cung cấp của các sản phẩm trong bảng "Products". 
-- Bao gồm cả các danh mục và nhà cung cấp không có sản phẩm. 
-- Sử dụng FULL JOIN hoặc kết hợp LEFT JOIN và RIGHT JOIN để lấy thông tin về danh mục và nhà cung cấp.
SELECT p.ProductID, p.ProductName, c.CategoryName, s.CompanyName
FROM Products p
FULL JOIN Suppliers s ON s.SupplierID = p.SupplierID
FULL JOIN Categories c ON c.CategoryID = p.CategoryID
-- • Bài tập 5 (INNER JOIN): Liệt kê tên khách hàng và tên sản phẩm đã được đặt hàng trong bảng "Orders" và "Order Details". 
-- Sử dụng INNER JOIN để kết hợp bảng "Orders" và "Order Details" để lấy thông tin khách hàng và sản phẩm đã được đặt hàng.
SELECT od.OrderID, c.CompanyName, p.ProductName
FROM Orders o
JOIN [Order Details] od ON o.OrderID = od.OrderID
JOIN Customers c  ON c.CustomerID = o.CustomerID
JOIN Products p ON p.ProductID = od.ProductID
-- • Bài tập 6 (FULL JOIN): Liệt kê tên nhân viên và tên khách hàng của các đơn hàng trong bảng "Orders".
-- Bao gồm cả các đơn hàng không có nhân viên hoặc khách hàng tương ứng. 
-- Sử dụng FULL JOIN hoặc kết hợp LEFT JOIN và RIGHT JOIN để kết hợp bảng "Orders" với bảng "Employees" và "Customers" để
-- lấy thông tin về nhân viên và khách hàng.
SELECT o.OrderID, c.CompanyName, e.FirstName, e.LastName
FROM dbo.Orders o
FULL JOIN Customers c ON c.CustomerID = o.CustomerID
FULL JOIN Employees e ON e.EmployeeID = o.EmployeeID


