package mssv_tensv;

public class HangDienMay extends HangHoa {
	private int tgBaoHanh;
	private double congSuat;

	public HangDienMay(String maHang, String tenHang, double donGia, int sLTon, int tgBaoHanh, double congSuat) throws Exception {
		super(maHang, tenHang, donGia, sLTon);
		setTgBaoHanh(tgBaoHanh);
		setCongSuat(congSuat);
	}

	public int getTgBaoHanh() {
		return tgBaoHanh;
	}

	public void setTgBaoHanh(int tgBaoHanh) throws Exception {
			if (tgBaoHanh < 0)
				throw new Exception("Thoi gian bao hanh < 0");
			else
				this.tgBaoHanh = tgBaoHanh;

	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) throws Exception {
		if (congSuat < 0)
			throw new Exception("Cong suat < 0");
		else
			this.congSuat = congSuat;
	}
	
	@Override
	public String mucDoBanBuon() {
		String str = "Khong danh gia";
		if(sLTon < 3) str = "Ban duoc";
		return str;
	}
	
	@Override
	public double VAT() {
		// TODO Auto-generated method stub
		return (0.1)*this.donGia;
	}
	
	@Override
	public String toString() {
		String s1 = "";
		s1+=String.format("%-10d|%-10.2f|%-10s|%-20s|",getTgBaoHanh(),getCongSuat(),mucDoBanBuon(),super.nF.format(VAT()));
		return super.toString()+s1;
	}

}
