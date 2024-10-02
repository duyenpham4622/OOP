package tuan5_bai3_HangHoa;

import java.util.Objects;

public abstract class HangHoa {
	protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;
    
    public abstract double tinhVAT();
    public abstract String danhGiaBanBuon();

    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
    	if (maHang == null || maHang.isEmpty()) throw new IllegalArgumentException("Mã hàng không được để trống");
        if (tenHang == null || tenHang.isEmpty()) throw new IllegalArgumentException("Tên hàng không được để rỗng");
        if (soLuongTon < 0) throw new IllegalArgumentException("Số lượng tồn không hợp lệ");
        if (donGia <= 0) throw new IllegalArgumentException("Đơn giá không hợp lệ");
        
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoa other = (HangHoa) obj;
		return Objects.equals(maHang, other.maHang);
	}
	@Override
	public String toString() {
        return String.format("Mã hàng: %s\nTên hàng: %s\nSố lượng tồn: %d\nĐơn giá: %.2f VNĐ",
                             maHang, tenHang, soLuongTon, donGia);
    }
    
}
