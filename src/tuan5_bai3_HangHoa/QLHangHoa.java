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