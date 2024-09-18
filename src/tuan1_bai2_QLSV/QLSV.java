package tuan1_bai2_QLSV;

public class QLSV {
	private int mssv;
	private String hoTen;
	private float diemLT,diemTH;
	public QLSV(int mssv, String hoTen, float diemLT, float diemTH) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	public QLSV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}
	public float getDiemTB() {
		return (getDiemLT()+getDiemTH())/2;
	}
	
	@Override
	public String toString() {
		 return String.format("MSSV: %-3d | Họ Tên: %-10s | Diem LT: %-1.2f | Diem TH: %-1.2f | Diem TB: %-2.1f",
                 mssv, hoTen, diemLT, diemTH, getDiemTB());
	}

}
