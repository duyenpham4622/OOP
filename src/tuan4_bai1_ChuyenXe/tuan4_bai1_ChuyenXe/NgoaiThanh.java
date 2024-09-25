package tuan4_bai1_ChuyenXe;

public class NgoaiThanh extends ChuyenXe {
	
	private String noiDen;
	private int soNgayDiDuoc;

	// ------------------ contructor đầy đủ tham số-----------------------------------------

	public NgoaiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
		//super gọi contructor của lớp cha
		super(maChuyenXe, hoTen, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	// ------------------ contructor mặc định -----------------------------
	public NgoaiThanh() {
		super();
	}
	// -------------------- begin setget -----------------------------------------
	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}

	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	// --------------------------end ---------------------------------------------
	@Override
	public String toString() {
		return super.toString() + "\n Nơi đến: " + getNoiDen() + "\n Ngày đi được: " + getSoNgayDiDuoc();
	}


}
