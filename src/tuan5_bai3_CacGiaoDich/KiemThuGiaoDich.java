package tuan5_bai3_CacGiaoDich;

import java.time.LocalDate;
import java.util.Scanner;

public class KiemThuGiaoDich {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuanLyGiaoDich danhSachGiaoDich = new QuanLyGiaoDich();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Thêm giao dịch vàng");
            System.out.println("2. Thêm giao dịch tiền tệ");
            System.out.println("3. In danh sách giao dịch");
            System.out.println("4. Tính tổng số lượng giao dịch vàng");
            System.out.println("5. Tính tổng số lượng giao dịch tiền tệ");
            System.out.println("6. Tính trung bình thành tiền của giao dịch tiền tệ");
            System.out.println("7. Xuất ra các giao dịch có đơn giá > 1 tỷ");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã giao dịch: ");
                    String maGiaoDichVang = scanner.nextLine();
                    System.out.print("Nhập ngày giao dịch (YYYY-MM-DD): ");
                    LocalDate ngayGiaoDichVang = LocalDate.parse(scanner.nextLine());
                    System.out.print("Nhập đơn giá: ");
                    double donGiaVang = scanner.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int soLuongVang = scanner.nextInt();
                    scanner.nextLine(); // Đọc newline
                    System.out.print("Nhập loại vàng: ");
                    String loaiVang = scanner.nextLine();

                    GiaoDichVang giaoDichVang = new GiaoDichVang(maGiaoDichVang, ngayGiaoDichVang, donGiaVang, soLuongVang, loaiVang);
                    danhSachGiaoDich.themGiaoDich(giaoDichVang);
                    System.out.println("Thêm giao dịch vàng thành công.");
                    break;

                case 2:
                    System.out.print("Nhập mã giao dịch: ");
                    String maGiaoDichTienTe = scanner.nextLine();
                    System.out.print("Nhập ngày giao dịch (YYYY-MM-DD): ");
                    LocalDate ngayGiaoDichTienTe = LocalDate.parse(scanner.nextLine());
                    System.out.print("Nhập đơn giá: ");
                    double donGiaTienTe = scanner.nextDouble();
                    System.out.print("Nhập số lượng: ");
                    int soLuongTienTe = scanner.nextInt();
                    System.out.print("Nhập tỉ giá: ");
                    double tiGia = scanner.nextDouble();
                    scanner.nextLine(); // Đọc newline
                    System.out.print("Nhập loại tiền tệ (VN/USD/Euro): ");
                    String loaiTienTe = scanner.nextLine();

                    GiaoDichTienTe giaoDichTienTe = new GiaoDichTienTe(maGiaoDichTienTe, ngayGiaoDichTienTe, donGiaTienTe, soLuongTienTe, tiGia, loaiTienTe);
                    danhSachGiaoDich.themGiaoDich(giaoDichTienTe);
                    System.out.println("Thêm giao dịch tiền tệ thành công.");
                    break;

                case 3:
                	danhSachGiaoDich.inDanhSach();
                    break;

                case 4:
                    System.out.println("Tổng số lượng giao dịch vàng: " + danhSachGiaoDich.tongSoLuongGiaoDichVang());
                    break;

                case 5:
                    System.out.println("Tổng số lượng giao dịch tiền tệ: " + danhSachGiaoDich.tongSoLuongGiaoDichTienTe());
                    break;

                case 6:
                    System.out.println("Trung bình thành tiền của giao dịch tiền tệ: " + danhSachGiaoDich.tinhTrungBinhThanhTienTienTe());
                    break;

                case 7:
                	danhSachGiaoDich.inGiaoDichDonGiaLonHon1Ty();
                    break;

                case 8:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
            }
        }
    }
}
