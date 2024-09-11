package tuan2_bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAccount {
	public static void menu() {
    	System.out.println("--- Quản lý tài khoản ngân hàng ---");
        System.out.println("1. Xem danh sách tài khoản");
        System.out.println("2. Thêm tài khoản");
        System.out.println("3. Xóa tài khoản");
        System.out.println("4. Sửa thông tin tài khoản");
        System.out.println("5. Tính lãi suất cho tài khoản");
        System.out.println("6. Thoát");
        System.out.print("Chọn thao tác: ");
    }
    public static void nhapThongTinTaiKhoan() {
    	Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        while (true) {
            
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nDanh sách tài khoản:");
                    if (accounts.isEmpty()) {
                        System.out.println("Không có tài khoản nào.");
                        System.out.println("---------------------------------------------------");
                    } else {
                        for (Account acc : accounts) {
                            System.out.println(acc);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Nhập số tài khoản: ");
                    long stk = scanner.nextLong();
                    scanner.nextLine(); 
                    System.out.print("Nhập tên tài khoản: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số dư ban đầu: ");
                    double balance = scanner.nextDouble();

                    Account newAccount = new Account(stk, name, balance);
                    accounts.add(newAccount);
                    System.out.println("Thêm tài khoản thành công.");
                    System.out.println("---------------------------------------------------");
                    break;

                case 3:
                    System.out.print("Nhập số tài khoản cần xóa: ");
                    long stkToDelete = scanner.nextLong();
                    boolean found = false;

                    for (Account acc : accounts) {
                        if (acc.getStk() == stkToDelete) {
                            accounts.remove(acc); 
                            found = true;
                            System.out.println("Xóa tài khoản thành công.");
                            System.out.println("---------------------------------------------------");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
                        System.out.println("---------------------------------------------------");
                    }
                    break;

                case 4:
                    System.out.print("Nhập số tài khoản cần sửa: ");
                    long stkToEdit = scanner.nextLong();
                    scanner.nextLine(); 
                    Account accountToEdit = null;

                    for (Account acc : accounts) {
                        if (acc.getStk() == stkToEdit) {
                            accountToEdit = acc;
                            break;
                        }
                    }

                    if (accountToEdit != null) {
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập số dư mới: ");
                        double newBalance = scanner.nextDouble();

                        accountToEdit.setName(newName);
                        accountToEdit.setBalance(newBalance);
                        System.out.println("Sửa thông tin tài khoản thành công.");
                        System.out.println("---------------------------------------------------");
                    } else {
                        // Nếu không tìm thấy tài khoản cần sửa
                        System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
                        System.out.println("---------------------------------------------------");
                    }
                    break;

                case 5:
                    System.out.print("Nhập số tài khoản cần đáo hạn: ");
                    long stkToMaturity = scanner.nextLong();
                    boolean foundMaturity = false;

                    for (Account acc : accounts) {
                        if (acc.getStk() == stkToMaturity) {
                            acc.maturity(); // Tính lãi suất cho tài khoản
                            foundMaturity = true;
                            System.out.println("Đáo hạn suất thành công.");
                            System.out.println("---------------------------------------------------");
                            break;
                        }
                    }
                    if (!foundMaturity) {
                        System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
                        System.out.println("---------------------------------------------------");
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    System.out.println("---------------------------------------------------");
                    scanner.close(); 
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    System.out.println("---------------------------------------------------");
            }
        }
    }

	public static void main(String[] args) {
		menu();
        nhapThongTinTaiKhoan();
		// TODO Auto-generated method stub

	}

}
