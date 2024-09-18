package tuan3_bai6_HangThucPham;

import java.util.Scanner;

public class TestHangThucPham {
	public static void nhapThongTinHangThucPham() {
		Scanner scanner = new Scanner(System.in);

        // Nhập thông tin hàng hóa
        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng mới sau khi nhập số

        System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
        String ngaySanXuat = scanner.nextLine();

        System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
        String ngayHetHan = scanner.nextLine();

        // Tạo đối tượng HangThucPham
        HangThucPham hangThucPham = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);

        // Hiển thị thông tin hàng hóa
        System.out.println("\nThông tin hàng hóa:");
        System.out.println(hangThucPham);

        // Kiểm tra hết hạn
        System.out.println("Hàng hóa đã hết hạn chưa? " + (hangThucPham.isExpired() ? "Có" : "Không"));

        scanner.close();
	}
    public static void main(String[] args) {
        nhapThongTinHangThucPham();
    }

}
