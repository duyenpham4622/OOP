import os
class Fruit:
    def __init__(self,id, Ten, Soluong, Dongia):
        self.id = id
        self.Ten = Ten
        self.Soluong = Soluong
        self.Dongia = Dongia
        
    def get_id(self):
        return self.id
    
    def set_id(self, id):
        self.id = id
        
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
        print(f'ID: {self.id}')
        print(f'Ten: {self.Ten}')
        print(f'So luong: {self.Soluong}')
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
            #print('Khong co phn tu nao')
            raise Exception("Khong co phan tu nao")
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
        de = 0
        while self.pHead != None:
            de += 1
            self.pHead = self.pHead.pNext
        return de
    
    def in_het(self):
        tmp = self.pHead
        while tmp != None:
            tmp.data1.in_thong_tin()
            tmp = tmp.pNext
            
    def in_ra_file(self):
        fr = open('Traicay.txt', mode = 'w', encoding = 'utf-8')
        tmo = self.pHead
        while tmo != None:
            fr.write(str(tmo.data1.id) + "," + tmo.data1.Ten + "," + 
                     str(tmo.data1.Soluong) + "," + str(tmo.data1.Dongia) + "\n") 
            tmo = tmo.pNext
        fr.close()
        
ds = DSLK()
while True:
    os.system("cls")
    print("1. Enqueue a fruit")
    print("2. Dequeue a fruit")
    print("3. View the front fruit")
    print("4. View the size of the queue")
    print("5. Print all")
    print("6. Read file.txt")
    print("7. Print all data into file.txt")
    print("0. Exit")
    
    choice = input("Nhap lua chon cua ban: ")
    if choice == "1":
        id = int(input("Nhap ma: "))
        tenTraiCay = input("Nhap ten trai cay: ")
        soluong = input("Nhap so luong trai cay: ")
        giatien = float(input("Nhap gia tien: "))
        fruit = Fruit(id, tenTraiCay, soluong, giatien)
        ds.enqueue(fruit)
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
        fr = open("Fruit.txt", mode="r", encoding='utf_8')
        for line in fr:
            stripline = line.strip("/n")
            danh_sach = stripline.split(",")
            id = int(danh_sach[0])
            tenTraiCay = danh_sach[1]
            soluong = int(danh_sach[2])
            giatien = float(danh_sach[3])
            tmp = Fruit(id, tenTraiCay, soluong, giatien)
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

        
        