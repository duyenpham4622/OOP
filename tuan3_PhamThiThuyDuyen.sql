--1)  Liệt kê các sản phẩm gồm các thông tin Product Names và Product ID có trên 
--100 đơn đặt hàng trong tháng 7 năm 2008
select p.ProductID, Name, count(p.ProductID) as count
from Production.Product p join Sales.SalesOrderDetail s 
on p.ProductID = s.ProductID
join Sales.SalesOrderHeader soh on soh.SalesOrderID = s.SalesOrderID
where YEAR(OrderDate) = 2008 and MONTH(OrderDate) = 7
group by p.ProductID, Name 
having count(p.ProductID) > 100;

--2)  Liệt kê các sản phẩm (ProductID, Name) có số hóa đơn đặt hàng nhiều nhất trong 
--tháng 7/2008
select p.ProductID, Name , CountOfOrders = Count(s.SalesOrderID)
from Production.Product p join Sales.SalesOrderDetail s 
on p.ProductID = s.ProductID
join Sales.SalesOrderHeader soh on soh.SalesOrderID = s.SalesOrderID
where YEAR(OrderDate) = 2008 and MONTH(OrderDate) = 7 
group by p.ProductID, Name
having 

--3)  Hiển thị thông tin của khách hàng có số đơn đặt hàng nhiều nhất, thông tin gồm: 
--CustomerID, Name, CountOfOrder

--4)  Liệt kê các sản phẩm (ProductID, Name) thuộc mô hình sản phẩm áo dài tay với 
--tên bắt đầu với “Long-Sleeve Logo Jersey”, dùng phép IN và EXISTS, (sử dụng 
--bảng Production.Product và Production.ProductModel) 
select ProductID, Name
from Production.Product
where ProductModelID in (select ProductModelID from Production.ProductModel
						where Name like 'Long-Sleeve Logo Jersey%'
						);

select ProductID, Name
from Production.Product
where EXISTS ( select ProductModelID from Production.ProductModel
			where Name like 'Long-Sleeve Logo Jersey%'
			)
--5)  Tìm các mô hình sản phẩm (ProductModelID) mà giá niêm yết (list price) tối
--đa cao hơn giá trung bình của tất cả các mô hình.
select ProductModelID
from Production.Product
group by ProductModelID
having max( ListPrice) > (select avg(ListPrice) from Production.Product )
--6)  Liệt kê các sản phẩm gồm các thông tin ProductID, Name, có tổng số lượng 
--đặt hàng > 5000 (dùng IN, EXISTS)

--7)  Liệt kê những sản phẩm (ProductID, UnitPrice) có đơn giá (UnitPrice) cao 
--nhất trong bảng Sales.SalesOrderDetail

--8)  Liệt kê các sản phẩm không có đơn đặt hàng nào thông tin gồm ProductID, 
--Nam; dùng 3 cách Not in, Not exists và Left join.
select p.ProductID
from Production.Product p left join Sales.SalesOrderDetail s
on p.ProductID = s.ProductID
--9)  Liệt kê các nhân viên không lập hóa đơn từ sau ngày 1/5/2008, thông tin gồm 
--EmployeeID,  FirstName,  LastName  (dữ  liệu  từ  2  bảng 
--HumanResources.Employees và Sales.SalesOrdersHeader)
select EmployeeID,  FirstName,  LastName
from HumanResources.Employee e join Person.Person ps
on e.BusinessEntityID = ps.BusinessEntityID
join Sales.SalesOrderHeader soh on soh.
--10) Liệt kê danh sách các khách hàng (CustomerID, Name) có hóa đơn dặt hàng
--trong năm 2007 nhưng không có hóa đơn đặt hàng trong năm 2008.
select c.CustomerID, Name from Sales.Customer c join Sales.SalesOrderHeader soh
on c.CustomerID = soh.CustomerID
where year(soh.OrderDate) = 2007