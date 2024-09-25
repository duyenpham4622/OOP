package tuan4_bai2_Sach;

import java.time.LocalDate;
import java.util.Scanner;

public class SachThamKhao extends Sach {
	private double thue;

    // Default constructor
    public SachThamKhao() {
        super();
    }

    // Parameterized constructor
    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    // Input method for SachThamKhao
    @Override
    public void nhapSach(Scanner scanner) {
        try {
            super.nhapSach(scanner);  // Use the parent class method for common attributes
            System.out.print("Nhập thuế: ");
            thue = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập thuế: " + e.getMessage());
        }
    }

    // Output method for SachThamKhao
    @Override
    public void xuatSach() {
        try {
            super.xuatSach();  // Use the parent class method for common attributes
            System.out.println("Thuế: " + thue);
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất thông tin thuế: " + e.getMessage());
        }
    }

    // Method to calculate total price including tax
    @Override
    public double thanhTien() {
        try {
            return soLuong * donGia + thue;  // Total price is quantity * price + tax
        } catch (Exception e) {
            System.out.println("Lỗi khi tính thành tiền sách tham khảo: " + e.getMessage());
            return 0;
        }
    }

    // toString method for formatted output
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------------------------------------------------------\n");
        sb.append("| Mã sách      | Ngày nhập   | Đơn giá  | Số lượng | Nhà xuất bản  | Thuế      | Thành tiền  |\n");
        sb.append("|--------------|-------------|----------|----------|---------------|-----------|-------------|\n");

        sb.append(String.format(
            "| %-12s | %-11s | %-8.2f | %-8d | %-13s | %-9.2f | %-11.2f |\n",
            maSach,
            ngayNhap.toString(),  // Using LocalDate's toString() method for date formatting
            donGia,
            soLuong,
            nhaXuatBan,
            thue,
            thanhTien()  // Calls the thanhTien method to calculate the total price
        ));

        return sb.toString();
    }
}
