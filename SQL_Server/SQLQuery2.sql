SELECT ProductID, ProductName, MAX(UnitsInStock) AS MaxUnitsInStock 
FROM dbo.Products;