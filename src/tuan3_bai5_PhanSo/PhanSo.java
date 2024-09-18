package tuan3_bai5_PhanSo;

import java.math.BigInteger;
import java.util.Scanner;

public class PhanSo {
	private int tuSo;
    private int mauSo;

    // Constructor
    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        reduce(); // Tối giản phân số ngay khi khởi tạo
    }

    private void reduce() {
        int gcd = gcd(tuSo, mauSo);
        tuSo /= gcd;
        mauSo /= gcd;
        if (mauSo < 0) { // Đảm bảo mẫu số luôn dương
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    // Hàm tìm ước số chung lớn nhất32q	ưA36
    private int gcd(int a, int b) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigB = BigInteger.valueOf(b);
        return bigA.gcd(bigB).intValue();
    }

    // Nghịch đảo phân số
    public PhanSo reciprocal() {
        if (tuSo == 0) {
            throw new ArithmeticException("Phân số có tử số bằng 0 không thể nghịch đảo.");
        }
        return new PhanSo(mauSo, tuSo);
    }

    // Cộng hai phân số
    public PhanSo add(PhanSo other) {
        int newTuSo = this.tuSo * other.mauSo + other.tuSo * this.mauSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new PhanSo(newTuSo, newMauSo);
    }

    // Trừ hai phân số
    public PhanSo subtract(PhanSo other) {
        int newTuSo = this.tuSo * other.mauSo - other.tuSo * this.mauSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new PhanSo(newTuSo, newMauSo);
    }

    // Nhân hai phân số
    public PhanSo multiply(PhanSo other) {
        int newTuSo = this.tuSo * other.tuSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new PhanSo(newTuSo, newMauSo);
    }

    // Chia hai phân số
    public PhanSo divide(PhanSo other) {
        if (other.tuSo == 0) {
            throw new ArithmeticException("Chia cho phân số có tử số bằng 0.");
        }
        return this.multiply(other.reciprocal());
    }

    // So sánh hai phân số
    public boolean equals(PhanSo other) {
        double tolerance = 0.0001;
        double diff = Math.abs(this.toDouble() - other.toDouble());
        return diff < tolerance;
    }

    // Chuyển phân số thành số thực để so sánh
    private double toDouble() {
        return (double) this.tuSo / this.mauSo;
    }

    // Phương thức để hiển thị phân số
    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    // Hàm main để nhập dữ liệu từ bàn phím và thực hiện các phép toán
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập phân số đầu tiên
        System.out.print("Nhập tử số của phân số đầu tiên: ");
        int tuSo1 = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số đầu tiên: ");
        int mauSo1 = scanner.nextInt();
        PhanSo ps1 = new PhanSo(tuSo1, mauSo1);

        // Nhập phân số thứ hai
        System.out.print("Nhập tử số của phân số thứ hai: ");
        int tuSo2 = scanner.nextInt();
        System.out.print("Nhập mẫu số của phân số thứ hai: ");
        int mauSo2 = scanner.nextInt();
        PhanSo ps2 = new PhanSo(tuSo2, mauSo2);

        // Thực hiện phép toán
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

}
