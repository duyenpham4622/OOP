package mssv_tensv;

import java.time.LocalDate;



public class HangThucPham extends HangHoa {
	private String nhaCC;
	private LocalDate ngaySX;
	private LocalDate ngayHH;

	public HangThucPham(String maHang, String tenHang, double donGia, int sLTon, String nhaCC, LocalDate nSX,
			LocalDate ngayHH) throws Exception {
		super(maHang, tenHang, donGia, sLTon);
		setNhaCC(nhaCC);	
		setNgaySX(nSX);
		setNgayHH(ngayHH);
	}

	public String getNhaCC() {
		return nhaCC;
	}

	public void setNhaCC(String nhaCC) throws Exception {
			this.nhaCC = nhaCC;
	}

	public LocalDate getNSX() {
		return ngaySX;
	}

	public LocalDate getHSD() {
		return ngayHH;
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		if(ngaySX.isAfter(LocalDate.now()))
			this.ngaySX = LocalDate.now();
		else
			this.ngaySX = ngaySX;
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) {
		if(ngayHH.isBefore(ngaySX))
			this.ngayHH = ngaySX;
		else
			this.ngayHH = ngayHH;
	}

	

	@Override
	public String mucDoBanBuon() {
		String str = "Khong danh gia";
		if (this.sLTon > 0 && ngayHH.isAfter(LocalDate.now()))
			str = "Kho ban";
		return str;
	}

	@Override
	public double VAT() {
		// TODO Auto-generated method stub
		return (0.05) * this.donGia;
	}

	@Override
	public String toString() {
		String s = "";
		s += String.format("%-10s|%-10s|%-10s|%-20s|%-10s|", getNhaCC(),formatDate(ngaySX), formatDate(ngayHH),mucDoBanBuon(),super.nF.format(VAT()));
		return super.toString() + s;
	}

}
