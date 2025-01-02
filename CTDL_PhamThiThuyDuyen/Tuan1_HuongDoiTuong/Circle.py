'''
Cài đặt lớp hình tròn theo thiết kế
Có 2 fields (thuộc tính): width, length
Có các phương thức: 
- tính diện tích (area)
- tính chu vi (perimeter)
- hiện thị cơ bản (display)
Phạm vi khai báo class Circle được tính từ phím tab sau class Circle
'''
import math
class Circle:
    def __init__(self,radius):
        self.radius = radius
        
def arae(self):
    result = math.pi * self.radius * self.radius
    return result
def perimeter(self):
    result = 2 * math.pi * self.radius
    return result
def display(self): 
    print(f'Bán kính: {self.radius},chuvi:  {self.perimeter():.2f}, diện tích: {self.arae():.2f}\n')