--1 question--
select COUNT(*) from Sales.SalesPerson;
--2 question--

select FirstName,LastName from Person.Person where FirstName Like 'b%';
--3 question--
select * from Person.Person;
select * from Person.vAdditionalContactInfo
select * from HumanResources.Employee where JobTitle='Marketing Assistant';
select Person.Person.FirstName,Person.Person.LastName From Person.Person Inner join HumanResources.Employee on Person.BusinessEntityID = HumanResources.Employee.BusinessEntityID where HumanResources.Employee.JobTitle = 'Design Engineer' or HumanResources.Employee.JobTitle='Tool Designer' or HumanResources.Employee.JobTitle= 'Marketing Assistant';

--4 question--
select * from Production.Product;
select Production.Product.Name,Production.Product.Color from Production.Product where Weight =(select max(Weight)from Production.Product);

--5 question--
select * from Sales.SpecialOffer;
select Sales.SpecialOffer.Description, Isnull(Sales.SpecialOffer.MaxQty,0) from Sales.SpecialOffer ;

--6 question--
select * from Sales.CurrencyRate;
select Avg(Sales.CurrencyRate.AverageRate) as 'Average exchange rate for the day' from Sales.CurrencyRate where FromCurrencyCode= 'USD' and ToCurrencyCode = 'GBP' and year(CurrencyRateDate)=2005 ;

--7 question--
select ROW_NUMBER() OVER(ORDER BY LastName DESC) AS No, FirstName,LastName  from Person.Person where FirstName Like '%ss%';

--8 question--
select * from Sales.SalesPerson;

select  Sales.SalesPerson.BusinessEntityID as 'SalesPersonID', CASE
    WHEN CommissionPct = 0.00   THEN 'Band 0'
    WHEN CommissionPct <= 1.00 and CommissionPct >0.0 THEN 'Band 1'
	 WHEN CommissionPct <= 1.50 and CommissionPct > 1.00  THEN 'Band 2'
    ELSE 'Band 3'
END AS 'Commission Band' from Sales.SalesPerson; 

--9 question--

DECLARE @EmployeeID int = ( SELECT Person.Person.BusinessEntityID 
FROM Person.Person WHERE FirstName = 'Ruth' AND LastName = 'Ellerbrock' AND PersonType ='EM' ) ; 
EXEC dbo.uspGetEmployeeManagers @BusinessEntityID = @EmployeeID;

--10 question--

select * from Production.ProductInventory
Select DISTINCT ProductID from Production.ProductInventory where LocationID=6
SELECT dbo.ufnGetStock(357) as 'result';


