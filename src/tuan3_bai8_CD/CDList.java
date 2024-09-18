package tuan3_bai8_CD;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
	private CD[] danhSachCD;
	private int soLuongCD;

	// Constructor
	public CDList(int size) {
		danhSachCD = new CD[size];
		soLuongCD = 0;
	}

	// Thêm CD vào danh sách
	public boolean themCD(CD cd) {
	    if (soLuongCD >= danhSachCD.length) {
	        // Mở rộng mảng khi đầy
	        CD[] danhSachCDMoi = new CD[danhSachCD.length * 2]; // Tăng gấp đôi kích thước
	        for (int i = 0; i < danhSachCD.length; i++) {
	            danhSachCDMoi[i] = danhSachCD[i];
	        }
	        danhSachCD = danhSachCDMoi; // Gán mảng mới vào danh sách CD
	    }
	    
	    // Kiểm tra mã CD trùng
	    for (int i = 0; i < soLuongCD; i++) {
	        if (danhSachCD[i].getMaCD() == cd.getMaCD()) {
	            return false; // CD đã tồn tại
	        }
	    }
	    
	    // Thêm CD vào danh sách
	    danhSachCD[soLuongCD++] = cd;
	    return true;
	}


	
	public int getSoLuongCD() {
		return soLuongCD;
	}


	public double tongGiaThanh() {
		double tong = 0;
		for (int i = 0; i < soLuongCD; i++) {
			tong += danhSachCD[i].getGiaThanh();
		}
		return tong;
	}

	
	public void sapXepTheoGiaThanh() {
		Arrays.sort(danhSachCD, 0, soLuongCD, new Comparator<CD>() {
			public int compare(CD cd1, CD cd2) {
				return Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh());
			}
		});
	}


	public void sapXepTheoTuaCD() {
		Arrays.sort(danhSachCD, 0, soLuongCD, new Comparator<CD>() {
			public int compare(CD cd1, CD cd2) {
				return cd1.getTuaCD().compareTo(cd2.getTuaCD());
			}
		});
	}

	
	public void xuatDanhSach() {
		for (int i = 0; i < soLuongCD; i++) {
			System.out.println(danhSachCD[i]);
		}
	}

}
