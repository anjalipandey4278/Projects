--Question3--

select * from Sales.SalesOrderHeader;
WITH Accountorders AS ( SELECT SUM(TotalDue) AS TotalSum , YEAR(OrderDate) AS Year, MONTH(OrderDate) AS Month, DAY(OrderDate) AS 'Date' FROM Sales.SalesOrderHeader AS soh GROUP BY AccountNumber, OrderDate ) 
SELECT top 5* FROM Accountorders WHERE TotalSum > 70000 ORDER BY Year DESC, Month DESC;
