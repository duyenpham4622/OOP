package tuan4_bai2_Sach;

import java.util.Date;

public class SachGiaoKhoa extends Sach {
	private String tinhTrang; // Tình trạng sách (mới, cũ)

    // Constructor để khởi tạo các thuộc tính của SachGiaoKhoa
    public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan); // Gọi constructor của lớp cha
        this.tinhTrang = tinhTrang;
    }

    // Phương thức để tính thành tiền dựa trên tình trạng sách
    @Override
    public double tinhThanhTien() {
    	try {
    		if (tinhTrang.equalsIgnoreCase("moi")) {
            return donGia * soLuong; 
    		} else  {
            return donGia * soLuong * 0.5; atch
        } 
    	}
        catch (Exception e) {
            System.out.println("Lỗi khi tính thành tiền: " + e.getMessage());
            return 0;
        }
        
    }

    // Getter cho thuộc tính tinhTrang
    public String getTinhTrang() {
        return tinhTrang;
    }

    // Setter cho thuộc tính tinhTrang
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    // Phương thức để in thông tin của sách giáo khoa
    @Override
    public String toString() {
        return "Mã sách: " + maSach +
               ", Ngày nhập: " + ngayNhap +
               ", Đơn giá: " + donGia +
               ", Số lượng: " + soLuong +
               ", Nhà xuất bản: " + nhaXuatBan +
               ", Tình trạng: " + tinhTrang +
               ", Thành tiền: " + tinhThanhTien();
    }

}
