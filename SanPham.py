class SanPham:
    def __init__(self,masp,ten,gia,soluong):
        self.masp = masp
        self.ten = ten
        self.gia = gia
        self.soluong = soluong

    def tonggia(self):
        return self.gia * self.soluong
    
    def giamoi(self,giamoi):
        if giamoi > 0:
            self.giamoi = giamoi

    def display(self):
        print(f'Ma: {self.masp},Ten:    {self.ten},Gia:    {self.gia},Soluong: {self.soluong}\n')

    