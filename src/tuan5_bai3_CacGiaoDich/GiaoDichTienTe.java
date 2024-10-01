package tuan5_bai3_CacGiaoDich;

import java.time.LocalDate;

public class GiaoDichTienTe extends GiaoDich {
	private double tiGia;
    private String loaiTienTe; // VN, USD, Euro

    public GiaoDichTienTe(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, double tiGia, String loaiTienTe) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong);
        this.tiGia = tiGia;
        this.loaiTienTe = loaiTienTe;
    }

    @Override
    public double thanhTien() {
        if (loaiTienTe.equals("USD") || loaiTienTe.equals("Euro")) {
            return soLuong * donGia * tiGia;
        } else { // VN
            return soLuong * donGia;
        }
    }
    public String getLoaiTienTe() {
        return loaiTienTe;
    }

    public double getTiGia() {
        return tiGia;
    }
    

	@Override
    public String toString() {
        return super.toString() + ", Loại Tiền Tệ: " + loaiTienTe + ", Thành Tiền: " + thanhTien();
    }

}
