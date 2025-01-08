--1)  Liệt kê danh sách các hóa đơn (SalesOrderID) lập trong tháng  6  năm 2008  có 
--tổng tiền >70000, 
--thông tin gồm SalesOrderID, Orderdate,  SubTotal,  trong đó 
--SubTotal  =SUM(OrderQty*UnitPrice).
select o.SalesOrderID,oh.OrderDate, SubTotal  = SUM(OrderQty*UnitPrice)
from Sales.SalesOrderDetail o join Sales.SalesOrderHeader oh
on o.SalesOrderID = oh.SalesOrderID
where MONTH(oh.OrderDate) = 6 and YEAR(oh.OrderDate) = 2008 and SubTotal > 70000
group by o.SalesOrderID,oh.OrderDate

--2)  Đếm tổng số khách hàng và tổng tiền của những khách hàng thuộc các quốc gia 
--có  mã  vùng  là  US  (lấy  thông  tin  từ  các  bảng  Sales.SalesTerritory, 
--Sales.Customer,  Sales.SalesOrderHeader,  Sales.SalesOrderDetail).  Thông  tin 
--bao  gồm  TerritoryID,  tổng  số  khách  hàng  (CountOfCust),  tổng  tiền 
--(SubTotal) với  SubTotal = SUM(OrderQty*UnitPrice)
select  t.TerritoryID,CountOfCust = SUM(c.CustomerID) ,SubTotal = SUM(OrderQty*UnitPrice)
from Sales.SalesOrderDetail o join Sales.SalesOrderHeader oh
 on o.SalesOrderID = oh.SalesOrderID join Sales.Customer c
 on c.CustomerID = oh.CustomerID join Sales.SalesTerritory t
 on t.TerritoryID = c.TerritoryID
 group by t.TerritoryID
--3)  Tính  tổng  trị  giá  của  những  hóa  đơn  với  Mã  theo  dõi  giao  hàng
--(CarrierTrackingNumber)  có  3  ký  tự  đầu  là  4BD,  thông  tin  bao  gồm 
--SalesOrderID, CarrierTrackingNumber,  SubTotal=SUM(OrderQty*UnitPrice)
select SalesOrderID, CarrierTrackingNumber,  SubTotal=SUM(OrderQty*UnitPrice)
from Sales.SalesOrderDetail
where CarrierTrackingNumber like '%4BD%'
group by SalesOrderID, CarrierTrackingNumber
go
--4)  Liệt  kê  các  sản  phẩm  (Product)  có  đơn  giá  (UnitPrice)<25  và  số  lượng  bán 
--trung bình >5, thông tin gồm ProductID, Name,  AverageOfQty.
select p.ProductID, p.Name, AverageOfQty = avg(o.UnitPrice)
from Production.Product p join Sales.SalesOrderDetail o
on p.ProductID = o.ProductID
where o.UnitPrice < 25 
group by p.ProductID, p.Name 
having avg(o.UnitPrice) > 5

go
--5)  Liệt kê các công việc (JobTitle) có tổng số nhân viên >20 người, thông tin gồm 
--JobTitle,  C ountOfPerson=Count(*)
select JobTitle,  CountOfPerson= Count(*)
from HumanResources.Employee e join Person.Person ps
on e.BusinessEntityID = ps.BusinessEntityID
group by JobTitle
having Count(*) >20
--6)  Tính tổng số lượng và tổng trị giá của các sản phẩm do các nhà cung cấp có tên 
--kết  thúc  bằng  ‘Bicycles’  và  tổng  trị  giá  >  800000,  thông  tin  gồm 
--BusinessEntityID, Vendor_Name, ProductID, SumOfQty,  SubTotal
--(sử dụng các bảng [Purchasing].[Vendor] , [Purchasing].[PurchaseOrderHeader] và 
--[Purchasing].[PurchaseOrderDetail])
select v.BusinessEntityID, v.Name, pv.ProductID, SumOfQty = SUM(pod.OrderQty),  SubTotal = SUM(OrderQty*UnitPrice)
from Purchasing.Vendor v join Purchasing.ProductVendor pv
on v.BusinessEntityID = pv.BusinessEntityID join Purchasing.PurchaseOrderDetail pod
on pod.ProductID = pv.ProductID join Purchasing.PurchaseOrderHeader poh
on pod.PurchaseOrderID = poh.PurchaseOrderID
where Name like '%Bicycles%'
group by v.BusinessEntityID,pv.ProductID,v.Name
having SUM(OrderQty*UnitPrice) >800000
go
--7)  Liệt kê các sản phẩm có trên 500 đơn đặt hàng trong quí 1 năm 2008 và có tổng 
--trị giá >10000, thông tin gồm ProductID, Product_Name, CountOfOrderID và 
--SubTotal
select *
from Production.ProductListPriceHistory
go
select p.ProductID, p.Name, CountOfOrderID = COUNT(*) ,SubTotal = SUM(OrderQty*UnitPrice)
from Production.Product p join Sales.SalesOrderDetail o
on p.ProductID = o.ProductID join Sales.SalesOrderHeader oh
on oh.SalesOrderID = o.SalesOrderID
where MONTH(oh.OrderDate) in (1,2,3) and YEAR(oh.OrderDate) = 2008
group by p.ProductID, p.Name
having COUNT(*) >500

go
--8)  Liệt kê danh sách các khách hàng có trên 25 hóa đơn đặt hàng từ năm 2007 đến 
--2008, thông tin gồm mã khách (PersonID) , họ tên (FirstName +'   '+ LastName 
--as FullName), Số hóa đơn  (CountOfOrders).
select
from 
--9)  Liệt kê những sản phẩm có tên bắt đầu với ‘Bike’ và ‘Sport’ có tổng số lượng 
--bán  trong  mỗi  năm  trên  500  sản  phẩm,  thông  tin  gồm  ProductID,  Name, 
--CountOfOrderQty,  Year.  (Dữ  liệu  lấy  từ  các  bảng  Sales.SalesOrderHeader, 
--Sales.SalesOrderDetail  và Production.Product)

--10)  Liệt kê những phòng ban có lương (Rate: lương theo giờ) trung bình >30, thông 
--tin  gồm  Mã  phòng  ban  (DepartmentID),  tên  phòng  ban  (Name),  Lương  trung
--bình (AvgofRate).  Dữ  liệu  từ  các  bảng
--[HumanResources].[Department], 
--[HumanResources].[EmployeeDepartmentHistory], 
--[HumanResources].[EmployeePayHistory].
select d.DepartmentID, d.Name, AvgofRate = avg(Rate)
from HumanResources.Department d join HumanResources.EmployeeDepartmentHistory eh
on d.DepartmentID =  eh.DepartmentID join HumanResources.EmployeePayHistory ep
on ep.BusinessEntityID = eh.BusinessEntityID
group by d.DepartmentID, d.Name
