package tuan4_bai2_Sach;

import java.time.LocalDate;
import java.util.Scanner;

public class KiemThuSach {
	// Function to provide some hardcoded input (for testing purposes)
    static void nhapCung() {
        LocalDate ngayNhap = LocalDate.of(2021, 9, 10); 
        SachGiaoKhoa sach1 = new SachGiaoKhoa("A123", ngayNhap, 10000, 5, "NXB1", "moi");
        SachThamKhao sach2 = new SachThamKhao("B123", ngayNhap, 20000, 3, "NXB2", 0.1);
        System.out.printf(sach1.toString());
        System.out.printf(sach2.toString());
    }

    // Function to display the menu options
    static void menu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Nhập danh sách sách");
        System.out.println("2. Xuất danh sách sách");
        System.out.println("3. Tính tổng thành tiền sách giáo khoa");
        System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
        System.out.println("5. Xuất các sách giáo khoa của nhà xuất bản X");
        System.out.println("6. Nhập cùng");
        System.out.println("7. Sắp xếp sách theo mã sách");
        System.out.println("8. Sắp xếp sách theo đơn giá");
        System.out.println("9. Sắp xếp sách theo số lượng");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    static void nhapSach() {
        Scanner scanner = new Scanner(System.in);
        QuanLySach thuVien = new QuanLySach();
        boolean running = true;

        while (running) {
            try {
                menu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        thuVien.nhapDanhSachSach(scanner);
                        break;
                    case 2:
                        thuVien.xuatDanhSachSach();
                        break;
                    case 3:
                        System.out.println("Tổng thành tiền sách giáo khoa: " + thuVien.tongThanhTienSachGiaoKhoa());
                        break;
                    case 4:
                        System.out.println("Trung bình cộng đơn giá sách tham khảo: " + thuVien.trungBinhDonGiaSachThamKhao());
                        break;
                    case 5:
                        System.out.print("Nhập nhà xuất bản cần tìm sách giáo khoa: ");
                        String nhaXuatBan = scanner.nextLine();
                        thuVien.xuatSachGiaoKhoaNhaXuatBan(nhaXuatBan);
                        break;
                    case 6:
                        nhapCung();
                        break;
                    case 7:
                        thuVien.sapXepTheoMaSach();
                        break;
                    case 8:
                        thuVien.sapXepTheoDonGia();
                        break;
                    case 9:
                    	thuVien.sapXepTheoSoLuong();
                    	break;
                    case 0:
                        running = false;
                        System.out.println("Kết thúc chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // Entry point of the program
    public static void main(String[] args) {
        nhapSach();
    }
	

}
