package tuan5_bai3_HangHoa;

import java.time.LocalDate;
import java.util.Date;

public class HangThucPham extends HangHoa {
	private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;
    
    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, 
    		LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
		super(maHang, tenHang, soLuongTon, donGia);
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
		this.nhaCungCap = nhaCungCap;
		
		if (ngayHetHan.isBefore(ngaySanXuat)) {
            throw new IllegalArgumentException("Ngày hết hạn phải sau hoặc bằng ngày sản xuất");
        	}
		}
    	
		
		@Override
		public double tinhVAT() {
	        return getDonGia() * getSoLuongTon() * 0.05;
		}
		
		@Override
		public String danhGiaBanBuon() {
		// Logic đánh giá hàng thực phẩm
		return "Không đánh giá";
		}


		public LocalDate getNgaySanXuat() {
			return ngaySanXuat;
		}


		public void setNgaySanXuat(LocalDate ngaySanXuat) {
			this.ngaySanXuat = ngaySanXuat;
		}


		public LocalDate getNgayHetHan() {
			return ngayHetHan;
		}


		public void setNgayHetHan(LocalDate ngayHetHan) {
			this.ngayHetHan = ngayHetHan;
		}


		public String getNhaCungCap() {
			return nhaCungCap;
		}


		public void setNhaCungCap(String nhaCungCap) {
			this.nhaCungCap = nhaCungCap;
		}
		@Override
	    public String toString() {
	        return super.toString() + String.format("\nNgày sản xuất: %s\nNgày hết hạn: %s\nNhà cung cấp: %s",
	                                                  ngaySanXuat, ngayHetHan, nhaCungCap);
	    }

}
