package mssv_tensv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachHangHoa {
	private ArrayList<HangHoa> listHH;

	public DanhSachHangHoa() {
		this.listHH = new ArrayList<HangHoa>();
	}

	//thêm một hàng hóa vào danh sách (thêm thành công nếu không bị trùng mã hàng).
	public boolean addHH(HangHoa hh) {
		if(listHH.contains(hh))
			return false;
		listHH.add(hh);
		return true;
	}
	
	//lấy thông tin toàn bộ danh sách các hàng hóa.
	public String getDSHH() {
		String ttHH = "";
		for (HangHoa hangHoa : listHH) {
			ttHH += "\n"+hangHoa;
		}
		return ttHH;
	}
	
	//lấy thông tin từng loại hàng hóa.
	public String getHangDienMay() {
		String ttHH = "";
		for (HangHoa hangHoa : listHH) {
			if(hangHoa instanceof HangDienMay)
				ttHH += "\n"+hangHoa;
		}
		return ttHH;
	}
	
	public String getHangThucPham() {
		String ttHH = "";
		for (HangHoa hangHoa : listHH) {
			if(hangHoa instanceof HangThucPham)
				ttHH += "\n"+hangHoa;
		}
		return ttHH;
	}
	
	public String getHangSanhSu() {
		String ttHH = "";
		for (HangHoa hangHoa : listHH) {
			if(hangHoa instanceof HangSanhSu)
				ttHH += "\n"+hangHoa;
		}
		return ttHH;
	}
	
	//tìm kiếm hàng hóa khi biết mã hàng
	public HangHoa timHangHoa(String maHH) {
		for(HangHoa hh: listHH)
			if(hh.getMaHang().equals(maHH))
				return hh;
		return null;
	}
	
	//sắp xếp hàng hóa theo tên hàng tăng dần
	public void sapXepTheoTen() {
		Collections.sort(listHH, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				return o1.tenHang.compareToIgnoreCase(o2.tenHang);
			}
		});
	}
	
	//sắp xếp hàng hóa theo số lượng tồn giảm dần
	public void sapXepTheoSLTon() {
		Collections.sort(this.listHH, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {

				return Integer.valueOf(o2.sLTon).compareTo(o1.sLTon);
			}

		});
	}

	
	//lấy thông tin các hàng thực phẩm khó bán.
	public String getTTDanhSach_HTP_Kho_Ban() {
		String ttHH = "";
		for (HangHoa hangHoa : listHH) {
			if((hangHoa instanceof HangThucPham) && hangHoa.mucDoBanBuon().equals("Kho ban"))
				ttHH += "\n"+hangHoa;
		}
		return ttHH;
	}
	
	//xóa hàng hóa khi biết mã hàng
	public boolean xoaHangHoa(String maHH) {
		for(HangHoa hh: listHH)
			if(hh.equals(maHH))
				return listHH.remove(hh);
			return false;
	}
	
	//sửa thông tin đơn giá của hàng hóa khi biết mã hàng
	public boolean suaDonGia(String maHH, double newPrice) throws Exception {
		HangHoa hh = timHangHoa(maHH);
		if(hh == null)
			return false;
		hh.setDonGia(newPrice);
		return true;
	}

	@Override
	public String toString() {
		String s = "Danh sach hang hoa:";
		for (HangHoa hh:listHH) {
			s += "\n"+ hh;
		}
		return s;
	}
	
}
