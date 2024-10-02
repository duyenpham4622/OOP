package tuan5_bai3_HangHoa;

import java.time.LocalDate;
import java.util.Scanner;

public class KiemThuHangHoa {
	public static void main(String[] args) {
		QLHangHoa danhSach = new QLHangHoa();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Thêm hàng hóa");
            System.out.println("2. Sửa hàng hóa");
            System.out.println("3. Xóa hàng hóa");
            System.out.println("4. In danh sách hàng hóa");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã hàng: ");
                    String maHang = scanner.nextLine();
                    System.out.print("Nhập tên hàng: ");
                    String tenHang = scanner.nextLine();
                    System.out.print("Nhập số lượng tồn: ");
                    int soLuongTon = scanner.nextInt();
                    System.out.print("Nhập đơn giá: ");
                    double donGia = scanner.nextDouble();
                    scanner.nextLine(); // Đọc newline

                    System.out.println("Chọn loại hàng hóa:");
                    System.out.println("1. Hàng thực phẩm");
                    System.out.println("2. Hàng điện máy");
                    System.out.println("3. Hàng sành sứ");
                    int loaiHang = scanner.nextInt();
                    scanner.nextLine(); // Đọc newline

                    switch (loaiHang) {
                        case 1: // Hàng thực phẩm
                            System.out.print("Nhập ngày sản xuất (YYYY-MM-DD): ");
                            LocalDate ngaySanXuat = LocalDate.parse(scanner.nextLine());
                            System.out.print("Nhập ngày hết hạn (YYYY-MM-DD): ");
                            LocalDate ngayHetHan = LocalDate.parse(scanner.nextLine());
                            System.out.print("Nhập nhà cung cấp: ");
                            String nhaCungCap = scanner.nextLine();
                            HangThucPham hangThucPham = new HangThucPham(maHang, tenHang, soLuongTon, donGia,
                                                                            ngaySanXuat, ngayHetHan, nhaCungCap);
                            if (danhSach.themHangHoa(hangThucPham)) {
                                System.out.println("Thêm hàng thực phẩm thành công.");
                            } else {
                                System.out.println("Mã hàng đã tồn tại.");
                            }
                            break;

                        case 2: // Hàng điện máy
                            System.out.print("Nhập thời gian bảo hành (tháng): ");
                            int thoiGianBaoHanh = scanner.nextInt();
                            System.out.print("Nhập công suất (KW): ");
                            double congSuat = scanner.nextDouble();
                            HangDienMay hangDienMay = new HangDienMay(maHang, tenHang, soLuongTon, donGia,
                                                                        thoiGianBaoHanh, congSuat);
                            if (danhSach.themHangHoa(hangDienMay)) {
                                System.out.println("Thêm hàng điện máy thành công.");
                            } else {
                                System.out.println("Mã hàng đã tồn tại.");
                            }
                            break;

                        case 3: // Hàng sành sứ
                            System.out.print("Nhập nhà sản xuất: ");
                            String nhaSanXuat = scanner.nextLine();
                            System.out.print("Nhập ngày nhập kho (YYYY-MM-DD): ");
                            LocalDate ngayNhapKho = LocalDate.parse(scanner.nextLine());
                            HangSanhSu hangSanhSu = new HangSanhSu(maHang, tenHang, soLuongTon, donGia,
                                                                     nhaSanXuat, ngayNhapKho);
                            if (danhSach.themHangHoa(hangSanhSu)) {
                                System.out.println("Thêm hàng sành sứ thành công.");
                            } else {
                                System.out.println("Mã hàng đã tồn tại.");
                            }
                            break;

                        default:
                            System.out.println("Loại hàng không hợp lệ.");
                    }
                    break;

                case 2:
                    System.out.println("Danh sách hàng hóa:");
                    danhSach.inDanhSach();
                    break;

                case 3:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Chọn chức năng không hợp lệ.");
            }
        }
    }
}
