package tuan5_bai3_CacGiaoDich;

import java.time.LocalDate;
import java.util.Objects;

public abstract class GiaoDich {
	protected String maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected int soLuong;
    
    public abstract double thanhTien();

    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

	public String getMaGiaoDich() {
		return maGiaoDich;
	}

	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	public LocalDate getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maGiaoDich);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		return Objects.equals(maGiaoDich, other.maGiaoDich);
	}
	public String toString() {
        return String.format("%-20s %-15s %-10s %-10s", 
                "Mã Giao Dịch: " + maGiaoDich, 
                "Ngày Giao Dịch: " + ngayGiaoDich, 
                "Đơn Giá: " + donGia, 
                "Số Lượng: " + soLuong);
    }
	
    
    

}
