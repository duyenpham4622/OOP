package tuan3.bai5;

public class Phanso {
	private int tuSo;
    private int mauSo;

    // Constructor
    public Phanso(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0.");
        }
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        reduce();
    }

    // Phương thức tối giản phân số
    private void reduce() {
        int ucln = gcd(Math.abs(tuSo), Math.abs(mauSo));
        tuSo /= ucln;
        mauSo /= ucln;
    }

    // Phương thức tìm ước chung lớn nhất
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Phương thức trả về nghịch đảo của phân số
    public Phanso reciprocal() {
        if (tuSo == 0) {
            throw new ArithmeticException("Không thể tìm nghịch đảo của phân số có tử số bằng 0.");
        }
        return new Phanso(mauSo, tuSo);
    }

    // Phương thức cộng hai phân số
    public Phanso add(Phanso other) {
        int newTuSo = this.tuSo * other.mauSo + other.tuSo * this.mauSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new Phanso(newTuSo, newMauSo);
    }

    // Phương thức trừ hai phân số
    public Phanso subtract(Phanso other) {
        int newTuSo = this.tuSo * other.mauSo - other.tuSo * this.mauSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new Phanso(newTuSo, newMauSo);
    }

    // Phương thức nhân hai phân số
    public Phanso multiply(Phanso other) {
        int newTuSo = this.tuSo * other.tuSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new Phanso(newTuSo, newMauSo);
    }

    // Phương thức chia hai phân số
    public Phanso divide(Phanso other) {
        if (other.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0.");
        }
        int newTuSo = this.tuSo * other.mauSo;
        int newMauSo = this.mauSo * other.tuSo;
        return new Phanso(newTuSo, newMauSo);
    }

    // Phương thức so sánh hai phân số với độ sai số cho phép
    public boolean compare(Phanso other, double tolerance) {
        double thisValue = (double) this.tuSo / this.mauSo;
        double otherValue = (double) other.tuSo / other.mauSo;
        return Math.abs(thisValue - otherValue) < tolerance;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    // Phương thức main để kiểm tra lớp
    public static void main(String[] args) {
        Phanso ps1 = new Phanso(1, 2);
        Phanso ps2 = new Phanso(2, 3);

        System.out.println("Phân số 1: " + ps1);
        System.out.println("Phân số 2: " + ps2);

        System.out.println("Nghịch đảo của phân số 1: " + ps1.reciprocal());
        System.out.println("Cộng: " + ps1.add(ps2));
        System.out.println("Trừ: " + ps1.subtract(ps2));
        System.out.println("Nhân: " + ps1.multiply(ps2));
        System.out.println("Chia: " + ps1.divide(ps2));
        System.out.println("So sánh: " + ps1.compare(ps2, 0.0001));
    }

}
