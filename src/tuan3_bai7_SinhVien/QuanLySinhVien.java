package tuan3_bai7_SinhVien;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySinhVien {
	public static void nhapThongTin() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng sinh viên: ");
		int n = scanner.nextInt();
		scanner.nextLine(); // Đọc dòng mới sau khi nhập số

		SinhVien[] sinhViens = new SinhVien[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");

			System.out.print("Mã sinh viên: ");
			int maSinhVien = scanner.nextInt();
			scanner.nextLine(); // Đọc dòng mới sau khi nhập số

			System.out.print("Họ tên: ");
			String hoTen = scanner.nextLine();

			System.out.print("Địa chỉ: ");
			String diaChi = scanner.nextLine();

			System.out.print("Số điện thoại (10 chữ số): ");
			String soDienThoai = scanner.nextLine();

			sinhViens[i] = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai);
		}
		// Sắp xếp danh sách sinh viên theo mã sinh viên
		Arrays.sort(sinhViens, Comparator.comparingInt(SinhVien::getMaSinhVien));

		// Xuất danh sách sinh viên
		System.out.println("\nDanh sách sinh viên sau khi sắp xếp:");
		for (SinhVien sinhVien : sinhViens) {
			System.out.println(sinhVien);
			System.out.println();
		}

		scanner.close();
	}

	public static void main(String[] args) {

		nhapThongTin();
	}

}
