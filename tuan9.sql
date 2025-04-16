--1.  Trong SQL Server, tạo thiết bị backup có tên adv2008back lưu trong thư mục 
--T:\backup\adv2008back.bak
exec sp_addumpdevice
	'disk',
	'adv2008back',
	'T:\backup\adv2008back.bak'
--2.  Attach CSDL AdventureWorks2008, chọn mode recovery cho CSDL này là full, rồi 
--thực hiện full backup vào thiết bị backup vừa tạo
alter database AdventureWorks2008R2
set recovery full
--------
BACKUP DATABASE AdventureWorks2008R2
	TO adv2008back
	with name = 'bk lan 1'
--3.  Mở CSDL AdventureWorks2008, tạo một transaction giảm giá tất cả mặt hàng xe 
--đạp trong bảng Product xuống $15 nếu tổng trị giá các mặt hàng xe đạp không thấp 
--hơn 60%.
select * from Production.Product
where ProductSubcategoryID in (select ProductSubcategoryID from Production.ProductSubcategory
								where ProductCategoryID in (select ProductCategoryID from Production.ProductCategory
															where Name = 'Bikes'))
select * from Production.ProductCategory
begin tran
	select ProductID, Name, ProductSubcategoryID, sum(ListPrice) as SumOf 
	from Production.Product
	where ListPrice * 0.6 < Sum(ListPrice) 
rollback
--4.  Thực hiện các backup sau cho CSDL AdventureWorks2008, tất cả backup đều lưu 
--vào thiết bị backup vừa tạo
--a.  Tạo 1 differential backup 
--b.  Tạo 1 transaction log backup
--5.  (Lưu ý ở bước 7 thì CSDL AdventureWorks2008 sẽ bị xóa. Hãy lên kế hoạch phục 
--hồi cơ sở dữ liệu cho các hoạt động trong câu 5, 6). 
--Xóa mọi bản ghi trong bảng Person.EmailAddress, tạo 1 transaction log backup
--6.  Thực hiện lệnh:
--a.  Bổ sung thêm 1 số phone mới cho nhân viên có mã số business là 10000 như 
--sau:
--INSERT INTO Person.PersonPhone VALUES (10000,'123-456-7890',1,GETDATE())
--b.  Sau đó tạo 1 differential backup cho AdventureWorks2008 và lưu vào thiết bị 
--backup vừa tạo. 
--c.  Chú ý giờ hệ thống của máy. 
--Đợi 1 phút sau, xóa bảng Sales.ShoppingCartItem
--7.  Xóa CSDL AdventureWorks2008
--8.  Để khôi phục lại CSDL: 
--a.  Như lúc ban đầu (trước câu 3) thì phải restore thế nào? 
--b.  Ở tình trạng giá xe đạp đã được cập nhật và bảng Person.EmailAddress vẫn 
--còn nguyên chưa bị xóa (trước câu 5) thì cần phải restore thế nào?
--c.  Đến thời điểm đã được chú ý trong câu 6c thì thực hiện việc restore lại CSDL 