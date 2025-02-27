import os 
class TraiCay:
    def __init__(self, tenTraiCay, maLoaiTraiCay, soLuong, giaBan):
        self.__tenTraiCay = tenTraiCay
        self.__maLoaiTraiCay = maLoaiTraiCay
        self.__soLuong = soLuong
        self.__giaBan = giaBan
        
    def getTenTraiCay(self):
        return self.__tenTraiCay
    
    def setTenTraiCay(self,tenTraiCay):
        self.__tenTraiCay = tenTraiCay
        
    def getmaLoaiTraiCay(self):
        return self.__maLoaiTraiCay
    
    def setmaLoaiTraiCay(self,maLoaiTraiCay):
        self.__maLoaiTraiCay = maLoaiTraiCay
        
    def getsoLuong(self):
        return self.__soLuong
    
    def setsoLuong(self,soLuong):
        self.__soLuong = soLuong
        
    def getgiaBan(self):
        return self.__giaBan
    def setgiaBan(self, giaBan):
        self.__giaBan = giaBan
        
    def inThongTin(self):
        return "Mã: " + self.__maLoaiTraiCay + "Tên trái cây: " + self.__tenTraiCay + "giá bán: " + self.__giaBan + "số lượng: " + self.__soLuong 
class NODE:
    def __init__(self,data):
        self.data = data
        self.pNext = None
pHead = None
        
class DSLienKet:
    def tinKiemTraiCay(self, id):
        tmp = pHead
        while tmp != None:
            if tmp.data.getmaLoaiTraiCay() == id:
                return tmp.data
            tmp = tmp.pNext 
        return None
    
    def them(self, data ):
        global pHead 
        tmp = NODE(data)
        if self.tinKiemTraiCay(data.getmaLoaiTraiCay()) != None:
            print('Ma da ton tai')
            return
        if pHead == None:
            pHead = tmp
        else:
            tmp1 = pHead
            while tmp1 != None:
                tmp1.pNext = tmp
                
    def inThongTin(self):
        tmp = pHead
        while tmp != None:
            print(tmp.data.inThongTin())
            tmp = tmp.pNext 
        return None
    def sapXepTangDan(self):
        global pHead
        tmp = pHead
        while tmp != None:
            tmp1 = tmp.pNext 
            while tmp1 != None:
                if tmp.data.getsoLuong() > tmp1.data.getsoLuong():
                    tmp.data, tmp1.data = tmp1.data, tmp.data 
            
    def trungBinhGiaBan(self):
        tmp = pHead
        dem = 0
        sum = 0
        while tmp != None:
            sum += tmp.data.getgiaBan()
            dem += 1
            tmp = tmp.pNext 
            rs = sum // dem 
            return rs
l = DSLienKet()
while True:
    os.system("cls")
    print("1.Thêm Loại trái cây")
    print("2. In thông tin trái cây theo mã")
    print("3. In toàn bộ trái cay có trong cửa hàng")
    print("4. Sắp xếp trái cây theo giá tăng dần")
    print("5. Giá trị trung bình từng loại trái cây")
    n = int(input("Nhập lừạ chọn bạn muốn(Nhập 0 để thoát): "))
    if n == 1:
        maTraiCay = input("Nhập mã trái cây: ")
        ten = input("Tên trái cây: ")
        soLuong = int(input("Nhập số lượng: "))
        giaBan = float(input("Nhập giá ban: "))
        tmp = TraiCay(ten, maTraiCay, soLuong, giaBan)
        l.them(tmp)
        input("Nhấn enter để tiếp tục !!!")
    elif n == 2:
        maTraiCay = input("Nhập mã trái cây: ")
        i = l.tinKiemTraiCay(maTraiCay)
        if i != None:
            print(i.inThongTin())
        else:
            print("Không tìm thấy !!!")
        input("Nhấn enter để tiếp tục !!!")
    elif n == 3:
        l.inThongTin()
        input("Nhấn enter để tiếp tục !!!")
    elif n == 4:
        l.sapXepTangDan()
        print("Đã sắp xếp !!!")
        input("Nhấn enter để tiếp tục !!!")
    elif n == 5:
        print(f"Trung bình giá bán: {l.trungBinhGiaBan()}")
        input("Nhấn enter để tiếp tục !!!")
    elif n == 0:
        print("Thoát chương trình !!!")
        break