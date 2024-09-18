package tuan4_bai2_Sach;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Sach {
	protected String maSach;
    protected Date ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public abstract double tinhThanhTien();

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public double getDonGia() {
        return donGia;
    }
    public Date getngayNhap() {
    	return this.ngayNhap;
    }
    public void setngayNhap(int year, int month, int day) {
    	ngayNhap = new Date(year - 1900,month - 1, day);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public String getMaSach() {
        return maSach;
    }
    @Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String dongiaString = df.format(donGia);
		String str1 = simpleDateFormat.format(ngayNhap);
		return String.format("|%-10s|%-15s|%-15s|%-10d|%-20s|", maSach, str1, dongiaString, soLuong, nhaXuatBan);
	}
}

