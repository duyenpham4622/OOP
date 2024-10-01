package tuan5_bai3_HangHoa;

public class HangDienMay extends HangHoa {
	private int thoiGianBaoHanh;
    private double congSuat;

    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia,
                       int thoiGianBaoHanh, double congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuat = congSuat;
        if (thoiGianBaoHanh < 0) throw new IllegalArgumentException("Thời gian bảo hành không hợp lệ");
        if (congSuat <= 0) throw new IllegalArgumentException("Công suất không hợp lệ");
    }

    @Override
    public double tinhVAT() {
        return getDonGia() * getSoLuongTon() * 0.10;
    }

    @Override
    public String danhGiaBanBuon() {
        if (getSoLuongTon() < 3) {
            return "Bán được";
        }
        return "Không đánh giá";
    }

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public double getCongSuat() {
		return congSuat;
	}
}
