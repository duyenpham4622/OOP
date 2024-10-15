package mssv_tensv;

import java.time.LocalDate;
import java.time.Period;

public class HangSanhSu extends HangHoa {
	private String nhaSX;
	private LocalDate ngayNhapKho;

	public HangSanhSu(String maHang, String tenHang, double donGia, int sLTon, String nhaSX,LocalDate ngayNhapKho) throws Exception {
		super(maHang, tenHang, donGia, sLTon);
		this.nhaSX = nhaSX;
		this.ngayNhapKho = ngayNhapKho;
	}


	public String getNhaSX() {
		return nhaSX;
	}

	public void setNhaSX(String nhaSX) {
		this.nhaSX = nhaSX;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if (ngayNhapKho.isAfter(LocalDate.now())) 
			this.ngayNhapKho = LocalDate.now();
		else 
			this.ngayNhapKho = ngayNhapKho;
	}

	@Override
	public String mucDoBanBuon() {
		Period age = Period.between(ngayNhapKho, LocalDate.now());
		int days = age.getDays();
		String str = "Khong danh gia";
		if(sLTon > 50 && days > 10) {
			str = "Ban cham";
		}
		return str;
	}
	
	@Override
	public double VAT() {
		// TODO Auto-generated method stub
		return (0.1) * this.donGia;
	}

	@Override
	public String toString() {
		String s = "";
		s+=String.format("%-10s|%-10s|%-10s|%-20s|",getNhaSX(),super.formatDate(getNgayNhapKho()),mucDoBanBuon(),super.nF.format(VAT()));
		return super.toString()+s;
	}

}
