package tuan4_bai2_Sach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThuVien {
	private List<Sach> danhSachSach = new ArrayList<>();

    public void themSach(Sach sach) {
        danhSachSach.add(sach);
    }

    public double tinhTongThanhTienSachGiaoKhoa() {
        double tong = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa) {
                tong += sach.tinhThanhTien();
            }
        }
        return tong;
    }

    public double tinhTrungBinhDonGiaSachThamKhao() {
        double tongDonGia = 0;
        int soLuongSachThamKhao = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachThamKhao) {
                tongDonGia += sach.getDonGia();
                soLuongSachThamKhao++;
            }
        }
        return soLuongSachThamKhao == 0 ? 0 : tongDonGia / soLuongSachThamKhao;
    }

    public void xuatSachGiaoKhoaTheoNhaXuatBan(String nhaXuatBan) {
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                SachGiaoKhoa sachGiaoKhoa = (SachGiaoKhoa) sach;
                System.out.println("Mã sách: " + sachGiaoKhoa.getMaSach() +
                                   ", Ngày nhập: " + sachGiaoKhoa.ngayNhap +
                                   ", Đơn giá: " + sachGiaoKhoa.getDonGia() +
                                   ", Số lượng: " + sachGiaoKhoa.getSoLuong() +
                                   ", Tình trạng: " + sachGiaoKhoa.getTinhTrang());
            }
        }
    }

    public static void main(String[] args) {
        ThuVien thuVien = new ThuVien();
        thuVien.themSach(new SachGiaoKhoa("G001", "01/01/2024", 100, 10, "NXB A", "mới"));
        thuVien.themSach(new SachGiaoKhoa("G002", "15/01/2024", 80, 5, "NXB A", "cũ"));
        thuVien.themSach(new SachThamKhao("T001", "20/01/2024", 200, 2, "NXB B", 50));
        thuVien.themSach(new SachThamKhao("T002", "25/01/2024", 150, 3, "NXB C", 30));

        System.out.println("Tổng thành tiền sách giáo khoa: " + thuVien.tinhTongThanhTienSachGiaoKhoa());
        System.out.println("Trung bình đơn giá sách tham khảo: " + thuVien.tinhTrungBinhDonGiaSachThamKhao());
        System.out.println("Sách giáo khoa của NXB A:");
        thuVien.xuatSachGiaoKhoaTheoNhaXuatBan("NXB A");
    }

}
