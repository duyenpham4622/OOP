package tuan4_bai2_Sach;

import java.util.Date;

public class SachThamKhao extends Sach {
	private double thue; // Thuế của sách tham khảo
	

    // Constructor để khởi tạo các thuộc tính của SachThamKhao
    public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan); // Gọi constructor của lớp cha
        this.thue = thue;
    }

    // Phương thức để tính thành tiền dựa trên đơn giá, số lượng và thuế
    @Override
    public double tinhThanhTien() {
    	try {
            return soLuong * donGia + thue;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính thành tiền sách tham khảo: " + e.getMessage());
            return 0;
        }
    }

    // Getter cho thuộc tính thue
    public double getThue() {
        return thue;
    }

    // Setter cho thuộc tính thue
    public void setThue(double thue) {
        this.thue = thue;
    }

    // Phương thức để in thông tin của sách tham khảo
    @Override
    public String toString() {
        return "SachThamKhao [thue=" + thue + "]";
    }

}
