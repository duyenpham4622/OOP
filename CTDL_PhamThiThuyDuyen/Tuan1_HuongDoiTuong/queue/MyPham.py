'''
Quản lý khách hàng mua mỹ phẩm tại cửa hàng.Thông tin bao gồm:
    Mã sản phẩm, tên mỹ phẩm, số lượnglượng mỹ phẩm, giá tiền
    Sử dụng DSLK để lưu trữ
    Sử dụng Stack và Queue để thêm và bán
    Tạo một menu gồm các mục:
    Thêm sản phẩm vào danh sách (enqueue)
    Xóa sản phẩm đầu tiên khỏi danh sách (dequeue)
    Xem sản phẩm đầu tiên trong danh sách
    Xem số lượng sản phẩm trong danh sách
    In ra toàn bộ danh sách mỹ phẩm
    Lưu danh sách vào tệp tin (MyPham.txt)
    Đọc danh sách từ tệp tin để khôi phục dữ liệu

    '''
import os
class MyPham:
    def __init__(self,maMP, Ten, Soluong, Dongia):
        self.maMP = maMP
        self.Ten = Ten
        self.Soluong = Soluong
        self.Dongia = Dongia
        
    def get_id(self):
        return self.maMP
    
    def set_id(self, maMP):
        self.maMP = maMP
        
    def get_Ten(self):
        return self.Ten
    
    def set_Ten(self, Ten):
        self.Ten = Ten
        
    def get_Soluong(self):
        return self.Soluong
    
    def set_Soluong(self,Soluong):
        self.Soluong = Soluong
    
    def get_Dongia(self):
        return self.Dongia
     
    def set_Dongia(self, Dongia):
        self.Dongia = Dongia
        
    def in_thong_tin(self):
        print(f'Ma my pham: {self.maMP}')
        print(f'Ten: {self.Ten}')
        print(f'So luong my pham: {self.Soluong}')
        print(f'Don gia: {self.Dongia}')
        
class NODE:
    def __init__(self, data):
        self.data1 = data
        self.pNext = None
        
class DSLK:
    def __init__(self):
        self.pHead = None
    #Stack
    def enqueue(self, data):
        if self.pHead == None:
            self.pHead = NODE(data)
        else:
            zz = NODE(data)
            tmp = self.pHead
            while tmp.pNext != None:
                if tmp.pNext == None:
                    tmp.pNext = zz
                    tmp == zz
                tmp = tmp.pNext
        
    def is_empty(self):
        if self.pHead is None:
            return True
        return False
    
    def dequeue(self):
        if self.is_empty() == True:
            print('Khong co phan tu nao')
            #raise Exception("Khong co phan tu nao")
            return
        tmp = self.pHead.data1
        self.pHead = self.pHead.pNext
        tmp.in_thong_tin()
        
    def front(self):
        if self.is_empty() == True:
            print("Khong co phan tu nao!!!")
            return
        self.pHead.data1.in_thong_tin()
        
    def size(self):
        count = 0
        while self.pHead != None:
            count += 1
            self.pHead = self.pHead.pNext
        return count
    
    def in_het(self):
        tmp = self.pHead
        while tmp != None:
            tmp.data1.in_thong_tin()
            tmp = tmp.pNext
            
    def in_ra_file(self):
        fr = open('MyPham.txt', mode = 'w', encoding = 'utf-8')
        tmo = self.pHead
        while tmo != None:
            fr.write(str(tmo.data1.maMP) + "," + tmo.data1.Ten + "," + 
                     str(tmo.data1.Soluong) + "," + str(tmo.data1.Dongia) + "\n") 
            tmo = tmo.pNext
        fr.close()
        
ds = DSLK()
while True:
    os.system("cls")
    print("1. Thêm sản phẩm vào danh sách")
    print("2. Xóa sản phẩm đầu tiên khỏi danh sách ")
    print("3. Xem sản phẩm đầu tiên trong danh sách")
    print("4. Xem số lượng sản phẩm trong danh sách")
    print("5. In toàn bộ thông tin khách hàng chờ thanh toán ")
    print("6. Đọc file.txt")
    print("7. Xuất tất cả dữ liệu ra file.txt")
    print("0. Thoát chương trìnhtrình")
    
    choice = input("Nhap lua chon cua ban: ")
    if choice == "1":
        maMP = int(input("Nhap ma my pham: "))
        tenMyPham = input("Nhap ten my pham: ")
        soluong = input("Nhap so luong my pham: ")
        giatien = float(input("Nhap gia tien: "))
        mypham = MyPham(maMP, tenMyPham, soluong, giatien)
        ds.enqueue(mypham)
        input("Nhan enter de tiep tuc!")
    elif choice == "2":
        ds.dequeue()
        input("Nhan enter de tiep tuc!")
    elif choice == "3":
        ds.front()
        input("Nhan enter de tiep tuc!")
    elif choice == "4":
        size = ds.size()
        print('Size: ',size)
        input("Nhan enter de tiep tuc!")
    elif choice == "5":
        ds.in_het()
        input("Nhan enter de tiep tuc!")
    elif choice == "6":
        fr = open("MyPham.txt", mode="r", encoding='utf_8')
        for line in fr:
            stripline = line.strip("/n")
            danh_sach = stripline.split(",")
            id = int(danh_sach[0])
            tenTraiCay = danh_sach[1]
            soluong = int(danh_sach[2])
            giatien = float(danh_sach[3])
            tmp = MyPham(maMP, tenMyPham, soluong, giatien)
            ds.push(tmp)
        print('DOC THANH CONG !!!')
        input("Nhan enter de tiep tuc!")
    elif choice == "7":
        ds.in_ra_file()
        print('IN THANH CONG !!!')
        input("Nhan enter de tiep tuc!")
    elif choice == "0":
        break
    else:
        print('Invailid choice. Please try again. ')
        input("Nhan enter de tiep tuc!")
