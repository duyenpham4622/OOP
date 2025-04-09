class Nut:
    #dinh nghia lop nut
    def __init__(self, khoa = None):
        self.khoa = khoa
        self.trai = None
        self.phai = None
    #def
    def chen(self, khoa):
        if self is None :
            nut = Nut(khoa)
            self = nut
            return
        #if nut chua duoc khoi tao
        #nut da duoc khoi tao roi, nut khac None
        if khoa < self.khoa:
            if self.trai == None:
                self.trai = Nut(khoa) #nut trai chua co gia tri
            else: #nut trai da co gia tri
                self.trai.chen(khoa)
                #if
        elif khoa> self.khoa:
            if self.phai == None:
                self.phai = Nut(khoa) #tao 1 nut moi
                
            else:
                #co nut ben phai roi
                self.phai.chen(khoa)#goi de quy
                #if
        else:
            #khong lon hon hay khong nho hon , bi trung khoa
            print(f'bi trung khoa {khoa}')
            #if
    #def
#class Nut
class CayNhiPhanTimKiem:
    def __init__(self, khoa = None):
        if khoa == None:#khong truyen vao tham so
            self.goc = None
        else:
            self.goc = Nut(khoa)
        #if
    #def
    #chen vao 1 gia tri khoa
    def chen(self, khoa):
        if self.goc== None:
            self.goc == Nut(khoa)
        else: #co nut roi
            self.goc.chen(khoa)
        #if
    #def chen 1 nut vao cay
            
    #Duyet cay
    def duyet_trai_nut_phai(self, goc = 0):
        #duyet theo LNR
        nut_ht = goc
        if goc == 0:
            nut_ht = self.goc
        #if
        #kiem tra nut hien tai co bang None khong
        if nut_ht == None:
            return []
        else: #cay co gia tri
            kq = []
            kq_trai = self.duyet_trai_nut_phai(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            #for duyet trai
            kq.append(nut_ht.khoa)
            #duyet phai
            kq_phai = self.duyet_trai_nut_phai(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            #for
            return kq
        #if
    #def
    def duyet_nut_trai_phai(self, goc = 0):
        #duyet theo NLR
        nut_ht = goc
        if goc==0:
            nut_ht=self.goc
        #if
        #kiem tra nut hien tai co bang None khong
        if nut_ht == None:
            return []
        else: #cay co gia tri
            kq = []
            kq.append(nut_ht.khoa)
            kq_trai = self.duyet_nut_trai_phai(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            #for duyet trai
            kq.append(nut_ht.khoa)
            #duyet trai
            kq_phai = self.duyet_trai_nut_phai(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            #for
                
    def duyet_trai_phai_nut(self, goc =0):
        #duyet theo LRN
        nut_ht = goc
        if goc == 0:
            nut_ht = self.goc
        #if
        #kiem tra nut hien tai co bang none khong
        if nut_ht == None:
            return []
        else: #cay co gia tri
            kq = []
            kq_trai = self.duyet_trai_phai_nut(nut_ht.trai)
            for x in kq_trai:
                kq.append(x)
            #for duyet trai
            
            #duyet phai
            kq_phai = self.duyet_trai_phai_nut(nut_ht.phai)
            for x in kq_phai:
                kq.append(x)
            #Not
            kq.append(nut_ht.khoa)
            #for
            return kq
        #if
    #def
        
#class
def main():
    so_phan_tu = 10
    cay = CayNhiPhanTimKiem()
    print('Chen vao cay')
    tap_gia_tri = set()
    from random import randint
    while len(tap_gia_tri) < so_phan_tu:
        gt = randint(1,100) #lay 10 phan tu khong trung nhau nen dung tap hop
        tap_gia_tri.add(gt)
    tap_gia_tri = list(tap_gia_tri) #phat sinh danh sach ngau nhien

    # c2: 
    #tap_gia_tri=[66, 46, 84, 11, 81, 99, 36, 77, 83, 87, 100, 86, 85]
    print('chen lan luot', tap_gia_tri)
    for x in tap_gia_tri:
        cay.chen(x)
    kq = cay.duyet_trai_nut_phai()
    print("Duyet cay theo trai-nut-phai (LNR):", kq)

    kq = cay.duyet_nut_trai_phai()
    print("Duyet cay theo nut-trai-phai (NLR):", kq)

    kq = cay.duyet_trai_phai_nut
    print("Duyet cay theo trai-phai-nut (LRN):", kq)

if __name__=='main':
    main()


                