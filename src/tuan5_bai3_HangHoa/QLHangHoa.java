package tuan5_bai3_HangHoa;

import java.util.ArrayList;

public class QLHangHoa {
	private ArrayList<HangHoa> danhSach;

    public QLHangHoa() {
        this.danhSach = new ArrayList<>();
    }

    public boolean themHangHoa(HangHoa hangHoa) {
    	if(danhSach.contains(hangHoa))//trùng mã
    		return false;
    	else
    	{
    		danhSach.add(hangHoa);
    		return true;
    		
    	}
        
    }
    public boolean xoaHangHoa(String maHang) {
        HangHoa hangHoa = timHangHoa(maHang);
        if (hangHoa != null) {
            danhSach.remove(hangHoa);
            return true; // Xóa thành công
        }
        return false; // Không tìm thấy hàng hóa
    }
    private HangHoa timHangHoa(String maHang) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean suaHangHoa(String maHang, HangHoa hangHoaMoi) {
        HangHoa hangHoaCu = timHangHoa(maHang);
        if (hangHoaCu != null) {
            int index = danhSach.indexOf(hangHoaCu);
            danhSach.set(index, hangHoaMoi);
            return true; // Sửa thành công
        }
        return false; // Không tìm thấy hàng hóa
    }

    public void inDanhSach() {
        System.out.printf("%-15s %-20s %-15s %-15s %-15s%n", 
                          "Mã Hàng", "Tên Hàng", "Số Lượng Tồn", "Đơn Giá", "Đánh Giá");

        for (HangHoa hh : danhSach) {
            System.out.printf("%-15s %-20s %-15d %-15.2f %-15s%n", 
                              hh.getMaHang(), 
                              hh.getTenHang(), 
                              hh.getSoLuongTon(), 
                              hh.getDonGia(), 
                              hh.danhGiaBanBuon());
        }
    }
}