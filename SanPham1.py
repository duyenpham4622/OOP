'''
Opt-1: Tải danh sách sản phẩm từ file dbproduct_input.db.
Opt-2: Thêm sản phẩm mới vào danh sách.
Opt-3: Hiển thị danh sách sản phẩm.
Opt-4: Hiển thị thông tin chi tiết của một sản phẩm (theo ID).
Opt-5: Chỉnh sửa thông tin sản phẩm.
Opt-6: Xóa một sản phẩm khỏi danh sách.
Opt-7: Tăng giá của một sản phẩm.
Opt-8: Giảm giá của một sản phẩm.
Opt-9: Tính tổng số lượng sản phẩm trong kho và xuất ra màn hình.
Opt-10: Tính tổng giá trị hàng tồn kho của toàn bộ sản phẩm và xuất ra màn hình.
Opt-11: Tìm sản phẩm có giá cao nhất, hiển thị thông tin chi tiết.
Opt-12: Tìm sản phẩm có giá thấp nhất, hiển thị thông tin chi tiết.
Opt-13: Sắp xếp danh sách sản phẩm theo giá tăng dần.
Opt-14: Sắp xếp danh sách sản phẩm theo giá trị hàng tồn kho giảm dần.
Opt-15: Vẽ biểu đồ so sánh giá trung bình giữa các loại sản phẩm.
Opt-16: Lưu danh sách sản phẩm xuống file dbproduct_output.db, biết rằng mỗi sản phẩm là một dòng, các thuộc tính cách nhau bằng dấu -.
Opt-Khác: Thoát chương trình.
'''
import matplotlib.pyplot as plt
import SanPham as sp
menu_option = {
    1:' Tải danh sách sản phẩm từ file dbproduct_input.db.',
    2:' Thêm sản phẩm mới vào danh sách.',
    3:' Hiển thị danh sách sản phẩm.',
    4:' Hiển thị thông tin chi tiết của một sản phẩm (theo ID).',
    5:' Chỉnh sửa thông tin sản phẩm.',
    6:' Xóa một sản phẩm khỏi danh sách.',
    7:' Tăng giá của một sản phẩm.',
    8:' Giảm giá của một sản phẩm.',
    9:' Tính tổng số lượng sản phẩm trong kho moi thang và xuất ra màn hình.',
    10:' Tính tổng giá trị hàng tồn kho của toàn bộ sản phẩm moi thang và xuất ra màn hình.',
    11:' Tìm sản phẩm có giá cao nhất, hiển thị thông tin chi tiết.',
    12:' Tìm sản phẩm có giá thấp nhất, hiển thị thông tin chi tiết.',
    13:' Sắp xếp danh sách sản phẩm theo giá tăng dần.',
    14:' Vẽ biểu đồ thể hiện giá trị hàng tồn kho của các sản phẩm.',
    15:' Vẽ biểu đồ so sánh giá trung bình giữa các sản phẩm.',
    16:' Lưu danh sách sản phẩm xuống file dbproduct_output.db, biết rằng mỗi sản phẩm là một dòng, các thuộc tính cách nhau bằng dấu -.',
    'Orthers':' Thoát chương trình.'
}
def print_menu():
    for key in menu_option.keys():
        print(key,'--',menu_option[key])


dsSanPham = []

while(True):
    print_menu()
    userChoice = ""
    try:
        userChoice =  int(input('Input choice: ')) 
    except: 
        print('Invalid input, try again') 
        continue

    if userChoice == 1:
        #Tải danh sách sản phẩm từ file dbproduct_input.db. 
        fr = open('dbemp_input.db',mode='r',encoding='utf-8') 
        for line in fr:
            stripLine = line.strip('\n') 
            ds = stripLine.split(',')
            masp = ds[0]
            ten = ds[1]
            gia = float(ds[2])
            soluong = int(ds[3]) 
            sosp = sp.SanPham(masp,ten,gia,soluong)
            dsSanPham.append(sosp)
        fr.close()

    elif userChoice == 2: 
           #Thêm sản phẩm mới vào danh sách
           maso = input("Nhap ma")
           ten = input("Nhap ten")
           gia = float(input("Nhap gia"))
           soluong = int(input("Nhap so luong"))
           sosp = sp.SanPham(masp,ten,gia,soluong)
           dsSanPham.append(sosp)
           
    elif userChoice == 3:
        #Hiển thị danh sách sản phẩm
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            for item in dsSanPham:
                item.display()
    elif userChoice == 4:
        #Hiển thị thông tin chi tiết của một sản phẩm (theo ID)
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            maso = input("Nhap ma")
            for item in dsSanPham:
                if(item.code == ma):
                    item.display()

    elif userChoice == 5:
        #Chỉnh sửa thông tin sản phẩm
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            ma = input("Cap nhat thông tin sản phẩm.")
            for item in dsSanPham:
                if(item.code == ma):
                    item.display()
                    menu ={
                        1:'Cập nhật tên',
                        2:'Cập nhật giá',
                        3:'Cập nhặt số lượng',
                        'Ordersrs':'Thoát'
                    }
                    def Xuat_menu():
                        for key in menu.keys(): 
                            print(key,'--',menu[key]) 
                    while (True): 
                        Xuat_menu() 
                        traloi='' 
                        try: 
                             traloi =int(input('Nhap cac tuy chon:')) 
                        except: 
                            print('Nhap sai dinh dang, nhap lai:') 
                            continue 
                        if traloi==1: 
                            ten = input("Input name: ")     
                            item.name =ten 
                            item.display() 
                        elif traloi ==2:
                            gia = float(input("nhap gia: "))
                            item.gia = gia
                            item.display()
                        elif traloi ==3:
                            soluong = int(input("Nhap so luong: "))
                            item.soluong = soluong
                            item.display()
                        else: 
                            print('Ket thuc chinh sua') 
                            break
    elif userChoice == 6:
        #Xóa một sản phẩm khỏi danh sách
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            ma = input("Nhap ma cap nhat")
            for item in dsSanPham:
                 if(item.code ==ma): 
                    item.display() 
                    tl = input('Ban co chac chan xoa san pham nay khong Y/N?') 
                    if tl =='Y': 
                            #del item 
                        dsSanPham.remove(item) 
        for item in dsSanPham: 
                    item.display() 
    elif userChoice == 7:
        #Tăng giá của một sản phẩm.
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            ma = input("Nhap ma cap nhat")
            for item in dsSanPham:
                if(item.code ==ma): 
                    item.display()
                    giatang = float(input("Nhap gia tang"))
                    item.gia = item.gia + giatang
                    item.display()
    elif userChoice == 8:
        #Giảm giá của một sản phẩm.
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            ma = input("Nhap ma cap nhat")
            for item in dsSanPham:
                if(item.code ==ma): 
                    item.display()
                    giagiam = float(input("Nhap gia giam"))
                    item.gia = item.gia + giagiam
                    item.display()
    elif userChoice == 9:
        #Tính tổng số lượng sản phẩm 1 thang trong kho và xuất ra màn hình.
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            tongsp = 0
            for item in dsSanPham:
                tongsp = tongsp + 1
                item.display()
            print('Tong so san pham la : ',tongsp)

    elif userChoice == 10:
        #Tính tổng giá trị hàng tồn kho của toàn bộ sản phẩm moi thang và xuất ra màn hình.
        tongdongia = 0.0
        for item in dsSanPham:
            tongdongia = tongdongia + item.gia
        print(f'Tong don gia la: {tongdongia}')
    elif userChoice == 11:
        #Tìm sản phẩm có giá cao nhất, hiển thị thông tin chi tiết.
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            for item in dsSanPham:
                giamax = item.gia
                break
            for item in dsSanPham:
                if(item.gia > giamax):
                    giamax = item.gia
            print('Gia cao nhat:',giamax)
    elif userChoice == 12:
        #Tìm sản phẩm có giá thấp nhất, hiển thị thông tin chi tiết.
        if dsSanPham.count == 0:
            print("Danh sach rong")
        else:
            for item in dsSanPham:
                giamin = item.gia
                break
            for item in dsSanPham:
                if(item.gia < giamin):
                    giamin = item.gia
            print('Gia thap nhat:',giamin)
    elif userChoice == 13:
        #Sắp xếp danh sách sản phẩm theo giá tăng dần
        def interchange_sort(dsSanPham):
            n = len(dsSanPham)
            for i in dsSanPham:
                for j in range(item +1,n,1):
                    if dsSanPham[i] > dsSanPham[j]:
                        dsSanPham[i],dsSanPham[j] = dsSanPham[j],dsSanPham[i]
            print('Danh sach san pham da sap xep la : ',dsSanPham)

    elif userChoice == 14:
        #Sắp xếp danh sách sản phẩm theo giá trị giảm dần.
        def interchange_sort(dsSanPham):
            n = len(dsSanPham)
            for i in dsSanPham:
                for j in range(item +1,n,1):
                    if dsSanPham[i] < dsSanPham[j]:
                        dsSanPham[i],dsSanPham[j] = dsSanPham[j],dsSanPham[i]
            print('Danh sach san pham da sap xep la : ',dsSanPham)
                
        #Vẽ biểu đồ so sánh giá trung bình giữa các sản phẩm.
        arrTen = []
        arrGia = []
        for item in dsSanPham:
            arrTen.append(item.ten)
            arrGia.append(item.gia)
        #Ve do thi
        plt.figure(figsize=(15,5)) 
 
        plt.title("So sánh giá sản phẩm và giá trung bình")
        plt.xlabel("Tên sản phẩm")
        plt.ylabel("Gia")
        plt.plot(arrTen,arrGia,"go")
        plt.legend()
        plt.show()
    elif userChoice == 16:
        # Hàm lưu danh sách sản phẩm vào file
        def luu_danh_sach_san_pham(dsSanPham, filename):
            with open(filename, 'w', encoding='utf-8') as f:
                for sp in dsSanPham:
            # Ghi từng sản phẩm vào file, các thuộc tính cách nhau bằng dấu '-'
                    print(f"{sp.ten}-{sp.gia}\n")

        # Lưu danh sách sản phẩm vào file dbproduct_output.db
        luu_danh_sach_san_pham(dsSanPham, 'dbproduct_output.db')
    else:
        print("Thoat")
        break
        #Ve do thi

    plt.figure(figsize=(15,5)) 
 
    plt.title("Gia trung binh giua cac san pham")
    plt.xlabel("So Luong")
    plt.ylabel("Gia")
    plt.plot(arrTen,arrGia,"go")        
    plt.show()