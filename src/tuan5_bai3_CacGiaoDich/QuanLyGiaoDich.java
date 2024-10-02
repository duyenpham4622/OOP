package tuan5_bai3_CacGiaoDich;

import java.util.ArrayList;

public class QuanLyGiaoDich {
	
	private ArrayList<GiaoDich> danhSachGiaoDich;
    public QuanLyGiaoDich() {
        danhSachGiaoDich = new ArrayList<>();
    }

    public void themGiaoDich(GiaoDich giaoDich) {
        danhSachGiaoDich.add(giaoDich);
    }
    public void inDanhSach() {
        System.out.printf("%-20s %-20s %-15s %-15s %-15s%n", 
                          "Mã Giao Dịch", "Ngày Giao Dịch", "Đơn Giá", "Số Lượng", "Thành Tiền");
        
        for (GiaoDich gd : danhSachGiaoDich) {
            System.out.printf("%-20s %-20s %-15s %-15s %-15s%n", 
                              gd.getMaGiaoDich(), 
                              gd.getNgayGiaoDich(), 
                              gd.getDonGia(), 
                              gd.getSoLuong(), 
                              gd.thanhTien());
        }
    }

    public int tongSoLuongGiaoDichVang() {
        int tong = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd instanceof GiaoDichVang) {
                tong += gd.getSoLuong();
            }
        }
        return tong;
    }

    public int tongSoLuongGiaoDichTienTe() {
        int tong = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd instanceof GiaoDichTienTe) {
                tong += gd.getSoLuong();
            }
        }
        return tong;
    }

    public double tinhTrungBinhThanhTienTienTe() {
        double tongThanhTien = 0;
        int count = 0;
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd instanceof GiaoDichTienTe) {
                tongThanhTien += gd.thanhTien();
                count++;
            }
        }
        return count > 0 ? tongThanhTien / count : 0;
    }

    public void inGiaoDichDonGiaLonHon1Ty() {
        for (GiaoDich gd : danhSachGiaoDich) {
            if (gd.thanhTien() > 1_000_000_000) {
                System.out.println("Mã giao dịch: " + gd.getMaGiaoDich() + 
                                   ", Thành tiền: " + gd.thanhTien());
            }
        }
    }
}
