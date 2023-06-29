--question 5--
CREATE PROCEDURE usGetPersonFilterName @name nvarchar(50) AS 
BEGIN 
IF (@name = '') BEGIN SELECT * FROM Person.Person ORDER BY FirstName; 
END 
ELSE 
BEGIN 
SELECT * FROM Person.Person where FirstName = @name ORDER BY FirstName; 
END 
END 

 execute usGetPersonFilterName @name='Aaron' GO
 execute usGetPersonFilterName @name=''

