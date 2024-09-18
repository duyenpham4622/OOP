package tuan4_bai1_ChuyenXe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachChuyenXe {
	
	ArrayList<ChuyenXe> DS;
	public DanhSachChuyenXe() {
		DS = new ArrayList<ChuyenXe>();
	}

//-------------------------------begin method ----------------------------------
	public void them(ChuyenXe xe) throws Exception {
		if (DS.contains(xe) == false)// hiểu dc nhờ hascode equa của lớp chuyến xe
			DS.add(xe);
		else {
			throw new Exception("Mã chuyến xe đã trùng");
		}
	}

	public int timKiemViTri(String maCX) {
		ChuyenXe findxe = timKiem(maCX);
		if (findxe != null)
			return DS.indexOf(timKiem(maCX));
		return -1;
	}

	public ChuyenXe timKiem(String maCX) {
		for (ChuyenXe xe : DS) {
			if (xe.getMaChuyenXe().equalsIgnoreCase(maCX))
				return xe;
		}
		return null;
	}

	public void xoa(ChuyenXe xe) {
		DS.remove(xe);
	}

	public void sua(ChuyenXe xe) {
		int vt = timKiemViTri(xe.getMaChuyenXe());
		DS.set(vt, xe);
	}

	public double tinhDoanhThu() {
		double s = 0;
		for (ChuyenXe xe : DS)
			s += xe.getDoanhThu();
		return s;
	}
//------------------------------end method-------------------------------------

//-----------------------------sắp xếp theo tên tài xế--------------------------
	public void sortTheoTenTaiXe() {
		Collections.sort(DS, new Comparator<ChuyenXe>() {
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
			}
		});
	}

//-----------------------------sắp xếp theo doanh thu--------- -----------------
	public void sortTheoDoanhThu() {
		Collections.sort(DS, new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe xe1, ChuyenXe xe2) {
				Double doanhThuXe1 = (Double) xe1.getDoanhThu();
				Double doanhThuXe2 = (Double) xe2.getDoanhThu();
				return doanhThuXe1.compareTo(doanhThuXe2);
			}
		});
	}
	public void sortTheoDoanhThuVietlai()
	{
		Collections.sort(DS, new Comparator<ChuyenXe>() {
			@Override
			public int compare(ChuyenXe x1, ChuyenXe x2) {
				// TODO Auto-generated method stub
				Double doanhThuXe1=(Double) x1.getDoanhThu();
				Double doanhThuXe2=(Double) x2.getDoanhThu();
				
				return doanhThuXe1.compareTo(doanhThuXe2);
			}
		});
	}
	public void sortTheo2Fied() {
		Collections.sort(DS, new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe o1, ChuyenXe o2) {
				String x1 = o1.getHoTen();
				String x2 = o2.getHoTen();
				int Comp = x1.compareTo(x2);
				if (Comp != 0)
					return Comp;
				else 
				{
				Double dt1 = o1.getDoanhThu();
				Double dt2 = o2.getDoanhThu();
				return dt1.compareTo(dt2);
				}
			}
		});
	}

//--------------------------trả về danh sách xe nội thành ----------------------
	public ArrayList<NoiThanh> getDSXeNoiThanh() {
		ArrayList<NoiThanh> DSxeNoiThanh = new ArrayList<NoiThanh>();
		for (ChuyenXe xe : DS)
			if (xe instanceof NoiThanh)
				DSxeNoiThanh.add((NoiThanh) xe);

		return DSxeNoiThanh;
	}
	//-----------------------------trả về danh sách xe ngoại thành -----------------
	public ArrayList<ChuyenXe> getDSXeNgoaiThanhDung() {
		ArrayList<ChuyenXe> DSxeNgoaiThanh = new ArrayList<ChuyenXe>();
		for (ChuyenXe xe : DS)
			if (xe instanceof NgoaiThanh)
				DSxeNgoaiThanh.add( xe);

		return DSxeNgoaiThanh;
	}

//-------------------------------trả về danh sách chuyến xe --------------------
	public ArrayList<ChuyenXe> getDS() {
		return DS;
	}


}
