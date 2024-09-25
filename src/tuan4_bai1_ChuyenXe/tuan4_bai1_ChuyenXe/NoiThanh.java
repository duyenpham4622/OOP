package tuan4_bai1_ChuyenXe;

import java.text.DecimalFormat;

public class NoiThanh extends ChuyenXe {
	
	private int soTuyen;
	private double soKm;

	// ------------------- contructor đầy đủ tham số ----------------------------
	public NoiThanh(String maChuyenXe, String hoTen, int soXe, double doanhThu, int soTuyen, double soKm) {
		super(maChuyenXe,hoTen,soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKm = soKm;
	}

	// -------------------- contructor mặc định ---------------------------------
	public NoiThanh() {
		
	}

	// -------------------- begin setget----------------------------------------
	public int getSoTuyen() {
		return soTuyen;
	}

	public void setSoTuyen(int soTuyen) {
		this.soTuyen = soTuyen;
	}

	public double getSoKm() {
		return soKm;
	}

	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}

	// ------------------------- end --------------------------------------------
	@Override
	public String toString() {
		DecimalFormat kmFormat = new DecimalFormat("#,##0.00km");
		String kmkString = kmFormat.format(soKm);
		return super.toString() + "\n Số tuyến: " + getSoTuyen() + "\n Số km đi được: " + kmkString;
	}


}
