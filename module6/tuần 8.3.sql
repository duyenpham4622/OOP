select * from [HumanResources].[Employee]
--chưa cấp quyền nên chưa thể select

--grant select on [HumanResources].[Employee] to user2
--đã cấp quyền cho user2
select * from [HumanResources].[Employee]

--revoke select on [HumanResources].[Employee] from user2
-- xóa quyền truy cập
select * from [HumanResources].[Employee]

--a)  Tại kết nối với User2, thực hiện câu lệnh Select để xem thông tin của bảng 
--Employee
select * from [HumanResources].[Employee]

--c)  Tại kết nối User2, dùng câu lệnh Select xem lại kết  quả.
--exec sp_droprolemember Employee_Role, user2

select * from [HumanResources].[Employee]

--kết quả Msg 229, Level 14, State 5, Line 1
--The SELECT permission was denied on the object 'Employee', database 'AdventureWorks2008R2', schema 'HumanResources'.
-- vi xoa ket noi cua role voi user 2 neen khong the dung lenh select