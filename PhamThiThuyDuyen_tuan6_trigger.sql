--1. T?o m?t Instead of trigger th?c hi?n tr�n view. Th?c hi?n theo c�c b??c sau:
---  T?o m?i 2 b?ng M_Employees v� M_Department theo c?u tr�c sau: 
create table M_Department
(
DepartmentID int not null primary key, 
Name nvarchar(50),
GroupName nvarchar(50)
)
create table M_Employees 
(
EmployeeID int not null primary key, 
Firstname nvarchar(50),
MiddleName nvarchar(50), 
LastName nvarchar(50),
DepartmentID int foreign key references M_Department(DepartmentID)
)
---  T?o  m?t  view  t�n  EmpDepart_View  bao  g?m  c�c  field:  EmployeeID,
--FirstName,  MiddleName,  LastName, DepartmentID,  Name,  GroupName,  d?a 
--tr�n 2 b?ng M_Employees v� M_Department.
---  T?o m?t trigger t�n InsteadOf_Trigger th?c hi?n tr�n view EmpDepart_View, 
--d�ng ?? ch�n d? li?u v�o c�c b?ng M_Employees v� M_Department khi ch�n 
--m?t record m?i th�ng qua view EmpDepart_View.
go
create view EmpDepart_View
as
select EmployeeID, FirstName,  MiddleName,  LastName, d.DepartmentID,  Name,  GroupName
from M_Employees e join M_Department d on e.DepartmentID = d.DepartmentID
go
--select * from EmpDepart_View
--select * from M_Department
create trigger InsteadOf_Trigger
on EmpDepart_View
instead of insert 
as
begin
	if not exists (select * from inserted)
	begin
		insert into M_Department(DepartmentID, Name, GroupName)
		values (11,'Marketing','Sales')
		insert into M_Employees (EmployeeID, Firstname, MiddleName, LastName)
		values (1, 'Nguyen','Hoang','Huy')
	end
end
insert into EmpDepart_View (EmployeeID, Firstname, MiddleName, LastName, DepartmentID,Name, GroupName)
values (1, 'Nguyen','Hoang','Huy', 11,'Marketing','Sales')
--2.  T?o m?t trigger th?c hi?n tr�n b?ng MSalesOrders c� ch?c n?ng thi?t l?p ?? ?u 
--ti�n c?a kh�ch h�ng (CustPriority) khi ng??i d�ng th?c hi?n c�c thao t�c Insert, 
--Update v� Delete tr�n b?ng MSalesOrders theo ?i?u ki?n nh? sau:
---  N?u t?ng ti?n Sum(SubTotal) c?a kh�ch h�ng d??i 10,000 $ th� ?? ?u ti�n c?a 
--kh�ch h�ng (CustPriority) l� 3
---  N?u t?ng ti?n Sum(SubTotal) c?a kh�ch h�ng t? 10,000 $ ??n d??i 50000 $ th� 
--?? ?u ti�n c?a kh�ch h�ng (CustPriority) l� 2
---  N?u t?ng ti?n Sum(SubTotal) c?a kh�ch h�ng t? 50000 $ tr? l�n th� ?? ?u ti�n 
--c?a kh�ch h�ng (CustPriority) l� 1

create table MCustomer
(
CustomerID int not null primary key, 
CustPriority int 
)
create table MSalesOrders 
(
	SalesOrderID int not null primary key, 
	OrderDate date,
	SubTotal money,
	CustomerID int foreign key references MCustomer(CustomerID) )

--Ch�n  d?  li?u  cho  b?ng MCustomers,  l?y  d?  li?u  t?  b?ng Sales.Customer, 
--nh?ng ch? l?y CustomerID>30100 v� CustomerID<30118, c?t CustPriority cho 
--gi� tr? null.
insert into MCustomer(CustomerID, CustPriority)
select CustomerID, null
from Sales.Customer
where CustomerID > 30100 and CustomerID < 30118

select * from MCustomer
--Ch�n d? li?u cho b?ng MSalesOrders, l?y d? li?u t? b?ng
--Sales.SalesOrderHeader, ch? l?y nh?ng h�a ??n c?a kh�ch h�ng c� trong b?ng 
--kh�ch h�ng.
insert into MSalesOrders(SalesOrderID, OrderDate, SubTotal, CustomerID)
select SalesOrderID, OrderDate, SubTotal, CustomerID
from Sales.SalesOrderHeader
where CustomerID in(select CustomerID from MCustomer)

select * from MSalesOrders
--Vi?t trigger ?? l?y d? li?u t? 2 b?ng inserted v� deleted.
go
alter trigger alter_Trigger on [dbo].[MSalesOrders]
after  insert, update, delete
as
begin
	declare @maKH int, @tong money

	if exists (select * from inserted)
	begin
		print('Dang chay Trigger')
		raiserror('Co chen/Cap nhat du lieu',11,3)

		select @maKH = customerID, @tong = Sum(Subtotal)
		from inserted
		group by CustomerID


		update MCustomer
		set CustPriority = 
		case
			when @tong < 10000 then 3
			when @tong >= 10000 and @tong <50000 then 2
			when @tong >= 50000 then 1
		end
		where CustomerID = @maKH
	end
		if exists (select * from deleted) and not exists (select * from inserted)
		begin
			raiserror(N'Xoa du lieu',11,4)
			select @maKH = CustomerID
			from deleted

			update MCustomer
			set CustPriority = Null
			where CustomerID = @maKH
		end
end
go
select * from [dbo].[MSalesOrders]
select * from MCustomer
update [dbo].[MSalesOrders]
set Subtotal = Subtotal * 0.7
where CustomerID = 30107

