--question4--
--function--
CREATE FUNCTION UnitPrice ( @salesOrderId int, @currencyCode nvarchar(20), @date date )
RETURNS TABLE AS RETURN ( SELECT OrderQty , ProductID, Unitprice * 
( SELECT EndOfdayRate FROM Sales.CurrencyRate WHERE ModifiedDate = @date AND ToCurrencyCode = @currencyCode ) AS UnitPrice 
FROM Sales.SalesOrderDetail WHERE SalesOrderID = @salesOrderId )go
--function call --
SELECT * FROM UnitPrice (43660,'AUD','2005-07-01');