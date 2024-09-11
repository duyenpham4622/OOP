package tuan1_bai1;

public class HinhChuNhat {
	private double chieuDai;
	private double chieuRong;
	private double dienTich;
	public HinhChuNhat(double chieuDai, double chieuRong) {
		if (chieuDai>0) {
			this.chieuDai = chieuDai;
		} else {
			System.out.println("loi");
		}
		if (chieuRong<=0) {
			System.out.println("loi");
		} else {
			this.chieuRong=chieuRong;
		}
	}
	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(double chieuDai) {
		if (chieuDai>0) {
			this.chieuDai = chieuDai;
		} else {
			System.out.println("loi");
		}
	}
	public double getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(double chieuRong) {
		if (chieuRong<=0) {
			System.out.println("loi");
		} else {
			this.chieuRong=chieuRong;
		}
	}
	public double getChuVi() {
		return (getChieuDai()+getChieuRong())*2;
	}
	public double getDienTich() {
		return getChieuDai()*getChieuRong();
	}
//	static String tieuDe() {
//		return String.format("%10d %-10d %-12d %-12d", "chieuDai", "chieuRong", "chuvi", "dientich");
//	}
	@Override
	public String toString() {
	    return String.format("%10s %10s %-12s %-12s", 
	                         "chieudai"+ chieuDai, 
	                         "chieurong"+ chieuRong, 
	                         "chu vi"+ getChuVi(), 
	                         "dientich"+ getDienTich());
	}


}
