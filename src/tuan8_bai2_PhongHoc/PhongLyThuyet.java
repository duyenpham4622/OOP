package tuan8_bai2_PhongHoc;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

    public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

	@Override
	public boolean datChuan() {
		// TODO Auto-generated method stub
		return (soBongDen >= dienTich / 10) && (coMayChieu);
	}

	public boolean isCoMayChieu() {
		return coMayChieu;
	}

	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}
	@Override
	public String toString() {
	    return super.toString() + String.format(" | %-10s |", (coMayChieu ? "Có" : "Không"));
	}

}
