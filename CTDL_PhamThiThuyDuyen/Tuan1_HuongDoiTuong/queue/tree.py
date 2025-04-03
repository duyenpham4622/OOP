class Nut:
    #Định nghĩa lớp nút:
    def __init__(self, khoa = None):
        self.khoa = khoa
        self.trai = None
        self.phai = None
    #def
    def chen(self, khoa):
        if self is None:
            nut = Nut(khoa)
            self = nut
            return
        #if nút chưa được khởi tạo
        #nút đã khởi tạo rồi, Nút khác None
        if khoa < self.khoa:
            if self.trai == None:
                self.trai = Nut(khoa) #Nút trái chưa có giá trị
            else: #Nút trái đã có giá trị
                self.trai.chen(khoa)
                
        elif khoa > self.khoa:
            if self.phai == None:
                self.phai = Nut(khoa)
            else:
                self.phai.chen(khoa)
        else:
            print(f'Bị trùng khóa : {khoa}')
#Định nghĩa lớp cây nhị phân tìm kiếm
class CayNhiPhanTimKiem:
    def __init__(self, khoa = None):
        if khoa == None:#Không truyền vào tham số
            self.goc = None
        else:
            self.goc = Nut(khoa)
    #Chèn vào một giá trị khóa
    def chen(self, khoa):
        if self.goc == None:
            self.goc = Nut(khoa)
        else:#Có nút rồi
            self.goc.chen(khoa)
            
    #Xóa 1 nút
    def xoa(self, khoa):
        nut_cha = None
        cha_con = None
        nut_ht = self.goc
        #Tìm nút xóa
        #Các trường hợp xóa nút lá, xóa nút có 1 con trái, xóa nút có 1 con phải
        #Xóa nút có cả 2 con, xóa nút gốc
        while nut_ht != None:
            if nut_ht.khoa > khoa: #Khóa xóa nhỏ hơn
                nut_cha = nut_ht
                nut_ht = nut_ht.trai #Tìm nhánh bên trái
                cha_con = 'trai'
            elif nut_ht.khoa < khoa:
                nut_cha = nut_ht
                nut_ht = nut_ht.phai
    
    
    
    #Duyệt cây
    def duyet_trai_nut_phai(self, goc = 0):
        #duyệt theo LNR
        nut_ht = goc
        if goc == 0:
            nut_ht = self.goc
            #Kiểm tra nút hiện tại có = None không
        if nut_ht == None:
            return []
        else: # Cây có giá trị
            kq = []
            kq_trai = self.duyet_trai_nut_phai(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            #For duyệt trái
            kq.append(nut_ht.khoa)
            #Duyệt phải
            kq_phai = self.duyet_trai_nut_phai(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            return kq
    #duyệt LNR    
    def duyet_nut_trai_phai(self, goc = 0):
        #Duyệt theo LNR
        nut_ht = goc
        if goc == 0:
            nut_ht = self.goc
        #Kiểm tra nút hiện tại có = None không
        if nut_ht == None:
            return []
        else: # Cây có giá trị
            kq = []
            kq.append(nut_ht.khoa)
            kq_trai = self.duyet_nut_trai_phai(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            #For duyệt trái
            
            #Duyệt phải
            kq_phai = self.duyet_nut_trai_phai(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            return kq
    #Duyệt theo LNR    
    def duyet_trai_phai_nut(self, goc = 0):
        nut_ht = goc
        if goc == 0:
            nut_ht = self.goc
        #Kiểm tra nút hiện tại có = None không    
        if nut_ht == None:
            return []
        else: # Cây có giá trị
            kq = []
            kq_trai = self.duyet_trai_phai_nut(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            #For duyệt trái
            
            #Duyệt phải
            kq_phai = self.duyet_trai_phai_nut(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            kq.append(nut_ht.khoa)
            return kq
#Ham Main
def main():
    SO_PHAN_TU = 10
    cay = CayNhiPhanTimKiem()
    print("*******Chèn vào cây********")
    tap_gia_tri = set()
    from random import randint
    while len(tap_gia_tri) < SO_PHAN_TU:
        gt = randint (1,100)#
        tap_gia_tri.add(gt)
    #
    tap_gia_tri = [66,46,84,11,81,99,77,87,100,86,85]
    print('',tap_gia_tri)
    for x in tap_gia_tri:
        cay.chen(x)
    kq = cay.duyet_trai_nut_phai()
    print('***********Duyệt cây theo Trái - Nút - Phải (LNR):',kq)
    
    kq = cay.duyet_nut_trai_phai()
    print('***********Duyệt cây theo Nút - Trái - Phải (NLR):',kq)
    
    kq = cay.duyet_trai_phai_nut()
    print('***********Duyệt cây theo Trái - Phải - Nút (LRN):',kq)
    
    print('*******Xóa 1 phần tử có trong cây:')
    gt = int(input('Nhập giá trị cần xóa: '))
    print(f'Xóa {gt}')
    cay.xoa(gt)
    
    kq = cay.duyet_trai_nut_phai()
    print('***********Duyệt cây theo Trái - Nút - Phải (LNR):',kq)
    
    kq = cay.duyet_nut_trai_phai()
    print('***********Duyệt cây theo Nút - Trái - Phải (NLR):',kq)
    
    kq = cay.duyet_trai_phai_nut()
    print('***********Duyệt cây theo Trái - Phải - Nút (LRN):',kq)
    
if __name__=="__Main__":
    main()