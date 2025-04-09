--I.  SINGLE TRANSACTION
--Autocommit mode là chế độ quản lý giao dịch mặc định của SQL Server Database 
--Engine. Mỗi lệnh Transact-SQL được Commit hoặc Rollback khi nó hoàn thành.
--1)  Thêm  vào  bảng  Department  một  dòng  dữ  liệu  tùy  ý  bằng  câu  lệnh 
--INSERT..VALUES…
select * from [HumanResources].[Department] --16 phòng ban

--a)  Thực hiện lệnh chèn thêm vào bảng Department một dòng dữ liệu tùy ý bằng 
--cách thực hiện lệnh Begin tran và Rollback, dùng câu lệnh Select * From 
--Department xem kết quả.
begin tran t1
insert into HumanResources.Department(DepartmentID,Name,GroupName,ModifiedDate)
values(21,'Custom Care',N'Chăm sóc khách hàng',GETDATE())
rollback tran t1

select * from [HumanResources].[Department] 
-- kết quả 17 row vì câu lệnh cuối là rollback, khôi phục lại trạng thái trước khi transaction

-- tính năng IDENTITY_INSERT đang tắt nên không thể chèn.
--b)  Thực hiện câu lệnh trên với lệnh Commit và kiểm tra kết  quả.

begin tran t1
insert into HumanResources.Department(DepartmentID,Name,GroupName,ModifiedDate)
values(21,'Custom Care',N'Chăm sóc khách hàng',GETDATE())
commit tran t1

select * from [HumanResources].[Department] 
-- kết quả có dòng 21


--2)  Tắt chế độ autocommit của SQL Server (SET IMPLICIT_TRANSACTIONS 
--ON). 


--  Xem dữ liệu ở bảng Department và Test để kiểm tra dữ liệu, giải thích kết 
--quả.

SET IMPLICIT_TRANSACTIONS ON

--Tạo đoạn batch gồm các thao  tác:
--  Tạo một bảng Test (ID int, Name  nvarchar(10))
insert into HumanResources.Department(DepartmentID,Name,GroupName,ModifiedDate)
values(17,'Customer Care',N'Chăm sóc khách hàng',GETDATE())

create table Test
(
	ID int primary key,
	 Name  nvarchar(10)
)

--  Thêm một dòng vào Test
--  ROLLBACK;
select * from Test

insert into Test values(1,'Test')
rollback
go
--kết quả không tạo table và không có dòng 17
select * from HumanResources.Department

--3)  Viết  đoạn  batch  thực  hiện  các  thao  tác  sau  (lưu  ý  thực  hiện  lệnh  SET 
--XACT_ABORT ON: nếu câu lệnh T-SQL làm phát sinh lỗi run-time, toàn bộ giao 
--dịch được chấm dứt và  Rollback)
set XACT_ABORT ON -- giao tác gặp lỗi thì quay lại

--batch
--  Câu lệnh SELECT với phép chia 0 :SELECT 1/0 as  Dummy
select 1/0 as Dummy
--  Cập nhật một dòng trên bảng Department với DepartmentID=’9’ (id này 
--không tồn  tại)
update HumanResources.Department
set Name = 'New Department'
where DepartmentID=17

--  Xóa một dòng không tồn tại trên bảng Department  (DepartmentID =’66’)
delete from HumanResources.Department
	where DepartmentID = 66

--  Thêm một dòng bất kỳ vào bảng  Department
--  COMMIT;
insert into HumanResources.Department(DepartmentID,Name,GroupName,ModifiedDate)
values(18,'Inventory Management',N'Quản lý kho hàng',GETDATE())
commit



--Thực thi đoạn batch, quan sát kết quả và các thông báo lỗi và giải thích kết quả.

--kết quả: vì chia 0 lỗi nên các lệnh ở sau không tiếp tục chạy
select * from HumanResources.Department

--4)  Thực  hiện  lệnh  SET  XACT_ABORT  OFF  (những  câu  lệnh  lỗi  sẽ  rollback, 
--transaction vẫn tiếp tục) sau đó thực thi lại các thao tác của đoạn batch ở câu 3. Quan 
--sát kết quả và giải thích kết  quả?
SET  XACT_ABORT  OFF -- (những  câu  lệnh  lỗi  sẽ  rollback, transaction vẫn tiếp tục)

--batch
--  Câu lệnh SELECT với phép chia 0 :SELECT 1/0 as  Dummy
select 1/0 as Dummy
--  Cập nhật một dòng trên bảng Department với DepartmentID=’9’ (id này 
--không tồn  tại)
update HumanResources.Department
set Name = 'New Department'
where DepartmentID=17

--  Xóa một dòng không tồn tại trên bảng Department  (DepartmentID =’66’)
delete from HumanResources.Department
	where DepartmentID = 66

--  Thêm một dòng bất kỳ vào bảng  Department
--  COMMIT;
insert into HumanResources.Department(DepartmentID,Name,GroupName,ModifiedDate)
values(18,'Inventory Management',N'Quản lý kho hàng',GETDATE())
commit

--Thực thi đoạn batch, quan sát kết quả và các thông báo lỗi và giải thích kết quả.

--kết quả: vì chia 0 lỗi nên các lệnh ở sau không tiếp tục chạy
select * from HumanResources.Department
--kết quả có dòng 18 vì SET  XACT_ABORT  OFF (những  câu  lệnh  lỗi  sẽ  rollback, transaction vẫn tiếp tục) nên lệnh insert cuối cùng vẫn chạy được

