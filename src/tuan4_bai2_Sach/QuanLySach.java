package tuan4_bai2_Sach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySach {
	private ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    // Method to input a list of books
    public void nhapDanhSachSach(Scanner scanner) {
        try {
            System.out.print("Nhập số lượng sách: ");
            int soLuongSach = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < soLuongSach; i++) {
                System.out.println("Nhập thông tin sách thứ " + (i + 1));
                System.out.print("Sách giáo khoa (1) hay sách tham khảo (2): ");
                int loaiSach = Integer.parseInt(scanner.nextLine());

                Sach sach;
                if (loaiSach == 1) {
                    sach = new SachGiaoKhoa();
                } else {
                    sach = new SachThamKhao();
                }
                sach.nhapSach(scanner);
                danhSachSach.add(sach);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập danh sách sách: " + e.getMessage());
        }
    }

    // Method to output the list of books
    public void xuatDanhSachSach() {
        try {
            for (Sach sach : danhSachSach) {
                System.out.println(sach.toString());
//                System.out.println("Thành tiền: " + sach.thanhTien());
//                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất danh sách sách: " + e.getMessage());
        }
    }

    // Method to calculate the total value of textbooks (Sach Giao Khoa)
    public double tongThanhTienSachGiaoKhoa() {
        try {
            double tong = 0;
            for (Sach sach : danhSachSach) {
                if (sach instanceof SachGiaoKhoa) {
                    tong += sach.thanhTien();
                }
            }
            return tong;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính tổng thành tiền sách giáo khoa: " + e.getMessage());
            return 0;
        }
    }

    // Method to calculate the average price of reference books (Sach Tham Khao)
    public double trungBinhDonGiaSachThamKhao() {
        try {
            double tongDonGia = 0;
            int soLuongSachThamKhao = 0;
            for (Sach sach : danhSachSach) {
                if (sach instanceof SachThamKhao) {
                    tongDonGia += sach.getDonGia();
                    soLuongSachThamKhao++;
                }
            }
            return soLuongSachThamKhao > 0 ? tongDonGia / soLuongSachThamKhao : 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính trung bình đơn giá sách tham khảo: " + e.getMessage());
            return 0;
        }
    }

    // Method to output textbooks from a specific publisher
    public void xuatSachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        try {
            for (Sach sach : danhSachSach) {
                if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                    sach.xuatSach();
                    System.out.println("--------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất sách giáo khoa của nhà xuất bản " + nhaXuatBan + ": " + e.getMessage());
        }
    }

    // Method to add a book to the list
    public void themSach(Sach sach) {
        if (sach != null) {
            danhSachSach.add(sach);
        }
    }
    public void sapXepTheoMaSach() {
        Collections.sort(danhSachSach);
        System.out.println("Danh sách sách sau khi sắp xếp theo mã sách:");
        xuatDanhSachSach();
    }

    // Phương thức sắp xếp theo đơn giá
    public void sapXepTheoDonGia() {
        Collections.sort(danhSachSach, new Comparator<Sach>() {
            @Override
            public int compare(Sach s1, Sach s2) {
                return Double.compare(s1.getDonGia(), s2.getDonGia());
            }
        });
        System.out.println("Danh sách sách sau khi sắp xếp theo đơn giá:");
        xuatDanhSachSach();
    }
    public void sapXepTheoSoLuong() {
		Collections.sort(danhSachSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach s1, Sach s2) {
				return Integer.compare(s1.getSoLuong(), s2.getSoLuong());
			}
		});
		System.out.println("Danh sách sách sau khi sắp xếp theo số lượng:");
		xuatDanhSachSach();
    }

}
