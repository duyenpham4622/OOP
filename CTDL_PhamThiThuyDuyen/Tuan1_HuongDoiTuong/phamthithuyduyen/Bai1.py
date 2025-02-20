from DSLK import *
menu_options = {
    0:'In danh sách liên kết',
    1:'Đếm số lượng phần tử có trong danh sách',
    2:'Tổng giá trị của các số co trong danh sách',
    3:'Giá trị lớn nhất trong danh sách',
    4:'Giá trị nhỏ nhất trong danh sách',
    5:'Sắp xếp danh sách theo thứ tự tăng dấn',
    6:'Sắp xếp danh sách theo thứ tự giảm dấn',
    7:'Danh sách các phần tử có giá trị là chắn',
    8:'Tìm 1 phần tử có giá trị X trong danh sách',
    9:'Thêm một phần tử vào trong danh sách liên kết'
}
def print_menu():
    for key in menu_options.keys():
        print(key,'--',menu_options[key])

ds = DSLK()
ds.them(1)
ds.them(10)
ds.them(4)
ds.them(2)
ds.them(6)
ds.them(8)
while (True):
    print_menu()
    userChoise = ''
    try:
        userChoise = int (input('Hãy nhập vào lựa chọn của bạn: '))
    except:
        print('Không có chức năng cần tìm! ')
        continue
    if userChoise == 0:
        print('0.In danh sách liên kết')
        ds.in_ds()
    if userChoise == 1:
        print('1.Đếm số lượng phần tử có trong danh sách')
        print(ds.dem())
    if userChoise == 2:
        print('2.Tổng giá trị của các số co trong danh sách')
        print(ds.tong())
        