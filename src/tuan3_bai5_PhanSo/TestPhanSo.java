package tuan3_bai5_PhanSo;

import java.util.Scanner;

public class TestPhanSo {
	public static void nhapPhanSo() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tử số của phân số đầu tiên: ");
        int tuSo1 = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số đầu tiên: ");
        int mauSo1 = scanner.nextInt();
        PhanSo ps1 = new PhanSo(tuSo1, mauSo1);

        System.out.print("Nhập tử số của phân số thứ hai: ");
        int tuSo2 = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số thứ hai: ");
        int mauSo2 = scanner.nextInt();
        PhanSo ps2 = new PhanSo(tuSo2, mauSo2);
        System.out.println("Phân số đầu tiên: " + ps1);
        System.out.println("Phân số thứ hai: " + ps2);

        System.out.println("Cộng: " + ps1.add(ps2));
        System.out.println("Trừ: " + ps1.subtract(ps2));
        System.out.println("Nhân: " + ps1.multiply(ps2));
        System.out.println("Chia: " + ps1.divide(ps2));
        System.out.println("Nghịch đảo phân số đầu tiên: " + ps1.reciprocal());
        System.out.println("Nghịch đảo phân số thứ hai: " + ps2.reciprocal());
        System.out.println("So sánh: " + ps1.equals(ps2));

          scanner.close();
	}

	public static void main(String[] args) {
		nhapPhanSo();
		// TODO Auto-generated method stub

	}

}
