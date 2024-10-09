package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class QuanLyCD {
	private ArrayList<CD> dsCD;
	private int soLuongCD;

    public QuanLyCD() {
        dsCD = new ArrayList<>();
    }
 // Thêm CD vào danh sách
    public boolean themCD(CD cd) {
    	if(dsCD.contains(cd))//trùng mã
    		return false;
    	else
    	{
    		dsCD.add(cd);
    		return true;
    		
    	}
        
    }
 // Xóa CD khỏi danh sách
    public boolean xoaCD(String maCD) {
    	CD cd = timCD(maCD);
    	if(cd != null) {
    		dsCD.remove(cd);
    		return true;
    	}
		return false;
    }
 // Sửa thông tin CD
    public boolean suaCD(String maCD,CD CDmoi) {
    	CD CDcu = timCD(maCD);
    	if(CDcu != null) {
    		int index = dsCD.indexOf(CDmoi);
    		dsCD.set(index, CDmoi);
    		return true;
    	}
    	return false;
    }
 // Sắp xếp theo ca sỹ
    public void sapxeptheoCaSy() {
    	dsCD.sort(Comparator.comparing(CD::getCaSy));
    	}
    
    public void sapXepGiamDanTheoGia() {
    	dsCD.sort((cd1, cd2) -> Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh()));
        }

    public void sapXepTangDanTheoTuaCD() {
    	dsCD.sort(Comparator.comparing(CD::getTuaCD));
    }
    
	private CD timCD(String maCD) {
		// TODO Auto-generated method stub
		return null;
	}
	// Tìm CD theo mã
    private CD timCD(int maCD) {
        for (CD cd : dsCD) {
            if (cd.getMaCD() == maCD) {
                return cd;
            }
        }
        return null; // Không tìm thấy
    }
 // Xuất danh sách CD
    public void xuatDanhSach() {
        for (CD cd : dsCD) {
            System.out.println(cd);
        }
    }

    // Lấy số lượng CD
    public int laySoLuongCD() {
        return dsCD.size();
    }
	
}
