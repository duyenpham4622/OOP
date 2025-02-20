#
class Nut:
    def __init__(self,gia_tri):
        self.gia_tri = gia_tri
        self.nut_ke_tiep = None
    
class DSLK:
    def __init__(self):
        self.dau = None
        self.cuoi = None

    def them(self,gia_tri):
        nut = Nut(gia_tri)
        if self.dau == None:
            self.dau = nut
            self.duoi = nut
        else :
            self.duoi.nut_ke_tiep = nut
            self.duoi = nut

    def chen(self,chi_muc,gia_tri):

        nut = Nut(gia_tri)
        truoc = None
        hientai = self.dau
        i = 0
        while i < chi_muc and hien_tai != None:
            i += 1
            truoc = hien_tai
            hien_tai = hien_tai.nut_ke_tiep

        if truoc == None:
            nut.nut_ke_tiep = self.dau
            self.dau = nut
            if self.duoi == None:
                self.duoi = nut
        else:
            if hien_tai == None:
                self.duoi.nut_ke_tiep = nut
                self.duoi = nut
            else:

                truoc.nut_ke_tiep = nut
                nut.nut_ke_tiep = hien_tai
    
    def in_ds(self):
        current = self.dau
        while current is not None:
            print(current.gia_tri)
            current = current.nut_ke_tiep
    
    def dem(self):
        count = 0
        hientai = self.dau
        while hientai is not None:
            count += 1
            hientai = hientai.nut_ke_tiep
        return count
    
    def tong(self):
        tong = 0
        hientai = self.dau
        while hientai is not None:
            tong += hientai.gia_tri
            hientai = hientai.nut_ke_tiep
        return tong
    def max(self):
        #max = 0
        hientai = self.dau
        max = hientai.gia_tri
        while hientai is not None:
            if hientai.gia_tri > max:
                max = hientai.gia_tri
            hientai = hientai.nut_ke_tiep
        return max
    def min(self):
        
        hientai = self.dau
        min = hientai.gia_tri
        while hientai is not None:
            if hientai.gia_tri < min:
                min = hientai.gia_tri
            hientai = hientai.nut_ke_tiep
        return min
    def chan(self):
        hientai = self.dau
        while hientai is not None:
            if (hientai.gia_tri % 2 == 0):
                print(hientai.gia_tri)
            hientai = hientai.nut_ke_tiep
    def sapxep_tangdan(self):
        hientai = self.dau
        while hientai is not None:
            sau = hientai.nut_ke_tiep
            while sau is not None:
                if sau.gia_tri < hientai.gia_tri:
                    sau.gia_tri, hientai.gia_tri = hientai.gia_tri, sau.gia_tri
                sau = sau.nut_ke_tiep
            hientai = hientai.nut_ke_tiep
    def sapxep_giamdan(self):
        hientai = self.dau
        while hientai is not None:
            sau = hientai.nut_ke_tiep
            while sau is not None:
                if sau.gia_tri > hientai.gia_tri:
                    sau.gia_tri, hientai.gia_tri = hientai.gia_tri, sau.gia_tri
                sau = sau.nut_ke_tiep
            hientai = hientai.nut_ke_tiep
    def tim(self,gia_tri):
        hientai




