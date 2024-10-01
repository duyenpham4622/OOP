package tuan5_bai3_HangHoa;

import java.time.LocalDate;

public class HangSanhSu extends HangHoa {
	private String nhaSanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia,
            String nhaSanXuat, LocalDate ngayNhapKho) {
		super(maHang, tenHang, soLuongTon, donGia);
		this.nhaSanXuat = nhaSanXuat;
		this.ngayNhapKho = ngayNhapKho;
    }

    public double tinhVAT() {
        return getDonGia() * getSoLuongTon() * 0.10;
    }

    public String danhGiaBanBuon() {
        if (getSoLuongTon() > 50 && LocalDate.now().minusDays(10).isAfter(ngayNhapKho)) {
            return "Bán chậm";
        }
        return "Không đánh giá";
    }

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}
    

}
