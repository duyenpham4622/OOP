package tuan2_bai3_Vehicle;

import java.util.Scanner;

public class TestVehicle {
	public static void menu() {
		System.out.println("\n--- Quản lý đăng ký xe ---");
		System.out.println("1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3");
		System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
		System.out.println("3. Thoát");
		System.out.print("Chọn thao tác: ");
	}
	public static void nhapThongTinXe() {
		Scanner scanner = new Scanner(System.in);

		Vehicle xe1 = null, xe2 = null, xe3 = null;

		while (true) {
			

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("\n--- Nhập thông tin và tạo các đối tượng xe1, xe2, xe3 ---");
				System.out.print("Nhập tên chủ xe1: ");
				String owner1 = scanner.nextLine();
				System.out.print("Nhập trị giá xe1: ");
				double value1 = scanner.nextDouble();
				System.out.print("Nhập dung tích xy lanh xe1: ");
				int engineCapacity1 = scanner.nextInt();
				xe1 = new Vehicle(owner1, value1, engineCapacity1);

				scanner.nextLine();
				System.out.print("Nhập tên chủ xe2: ");
				String owner2 = scanner.nextLine();
				System.out.print("Nhập trị giá xe2: ");
				double value2 = scanner.nextDouble();
				System.out.print("Nhập dung tích xy lanh xe2: ");
				int engineCapacity2 = scanner.nextInt();
				xe2 = new Vehicle(owner2, value2, engineCapacity2);

				scanner.nextLine();
				System.out.print("Nhập tên chủ xe3: ");
				String owner3 = scanner.nextLine();
				System.out.print("Nhập trị giá xe3: ");
				double value3 = scanner.nextDouble();
				System.out.print("Nhập dung tích xy lanh xe3(cc): ");
				int engineCapacity3 = scanner.nextInt();
				xe3 = new Vehicle(owner3, value3, engineCapacity3);

				System.out.println("Đã tạo xong các đối tượng xe.");
				break;

			case 2:
				System.out.println("\n--- Bảng kê khai tiền thuế trước bạ ---");
				System.out.println(Vehicle.getHeader());
				if (xe1 != null)
					System.out.println(xe1);
				if (xe2 != null)
					System.out.println(xe2);
				if (xe3 != null)
					System.out.println(xe3);
				break;

			case 3:
				System.out.println("Thoát chương trình.");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		}
	}

	public static void main(String[] args) {
		menu();
		nhapThongTinXe();
		// TODO Auto-generated method stub

	}

}
