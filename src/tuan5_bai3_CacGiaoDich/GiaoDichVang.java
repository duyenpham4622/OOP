package tuan5_bai3_CacGiaoDich;

import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;
	public GiaoDichVang(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiVang) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.loaiVang = loaiVang;
    }

    @Override
    public double thanhTien() {
        return soLuong * donGia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loại Vàng: " + loaiVang + ", Thành Tiền: " + thanhTien();
    }

}
