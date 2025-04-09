--Sử dụng SSMS (Sql Server Management Studio) để thực hiện các thao tác sau:
exec sp_helplogins
exec sp_helplogins 'sa'

--1)  Đăng nhập vào  SQL  bằng SQL  Server authentication, tài khoản sa.  Sử dụng TSQL.

--2)  Tạo hai login SQL server Authentication User2 và  User3
create login user2 with password='@user2',
default_database= AdventureWorks2008R2
create login user3 with password='@user3',
default_database= AdventureWorks2008R2
--3)  Tạo một database user User2 ứng với login User2 và một database user   User3
create user user2 for login user2
create user user3 for login user3

exec sp_helpuser 'dbo'
exec sp_helpuser

--ứng với login User3 trên CSDL AdventureWorks2008.
--4)  Tạo 2 kết nối đến server thông qua login  User2  và  User3, sau đó thực hiện các 
--thao tác truy cập CSDL  của 2 user  tương ứng (VD: thực hiện  câu Select). Có thực 
--hiện được không?

select * from [HumanResources].[Employee]

--Msg 229, Level 14, State 5, Line 1
--The SELECT permission was denied on the object 'Employee', database 'AdventureWorks2008R2', schema 'HumanResources'.


--5)  Gán quyền select trên Employee cho User2, kiểm tra kết quả.  Xóa quyền select 
--trên Employee cho User2. Ngắt 2 kết nối của User2 và  User3

 --Gán quyền select trên Employee cho User2
grant select on [HumanResources].[Employee] to user2

 
--Xóa quyền select  trên Employee cho User2
revoke select on [HumanResources].[Employee] from user2

--Ngắt 2 kết nối của User2 và  User3
--disconnect


--6)  Trở lại kết nối của sa, tạo một user-defined database Role tên Employee_Role trên 
--CSDL  AdventureWorks2008,
create role Employee_Role
--  sau  đó  gán  các  quyền  Select,  Update,  Delete  cho Employee_Role.
grant select,update , delete on [HumanResources].[Employee] to Employee_Role

--7)  Thêm các  User2  và  User3  vào  Employee_Role.  Tạo  lại  2  kết  nối  đến  server  thông qua login User2 và User3 thực hiện các thao tác  sau:
exec sp_addrolemember Employee_Role, user2
exec sp_addrolemember Employee_Role, user3

--a)  Tại kết nối với User2, thực hiện câu lệnh Select để xem thông tin của bảng 
--Employee
select * from [HumanResources].[Employee]
--b)  Tại kết nối của User3, thực hiện cập nhật JobTitle=’Sale Manager’ của  nhân 
--viên có BusinessEntityID=1
--c)  Tại kết nối User2, dùng câu lệnh Select xem lại kết  quả.
exec sp_droprolemember Employee_Role, user2
--d)  Xóa role Employee_Role, (quá trình xóa role ra sao ?)
exec sp_droprole Employee_Role
-- không thể xóa vì bên trong còn member
exec sp_droprolemember Employee_Role, user3

exec sp_droprole Employee_Role
--xóa thành công vì bên trong không còn member