--user 3
exec sp_addrolemember Employee_Role, user3
-- vì kết nối với role nên user3 có thể select update và delete
select * from [HumanResources].[Employee]
--b)  Tại kết nối của User3, thực hiện cập nhật JobTitle=’Sale Manager’ của  nhân 
--viên có BusinessEntityID=1
select * from [HumanResources].[Employee]
where BusinessEntityID=1

update [HumanResources].[Employee]
set JobTitle='Sale Manager'
where BusinessEntityID=1
