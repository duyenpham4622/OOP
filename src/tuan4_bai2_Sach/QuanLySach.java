package tuan4_bai2_Sach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySach {
	private List<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public double tongThanhTienSachGiaoKhoa() {
        double tong = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa) {
                tong += sach.tinhThanhTien();
            }
        }
        return tong;
    }

    public double trungBinhCongDonGiaSachThamKhao() {
        double tongDonGia = 0;
        int count = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachThamKhao) {
                tongDonGia += sach.donGia;
                count++;
            }
        }
        return count > 0 ? tongDonGia / count : 0;
    }

    public void xuatSachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        System.out.println("Sách giáo khoa của nhà xuất bản " + nhaXuatBan + ":");
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                System.out.println(sach);
            }
        }
    }

    public void xuatDanhSachSach() {
        for (Sach sach : danhSachSach) {
            System.out.println(sach);
        }
    }

	public void nhapDanhSachSach(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
	

}
