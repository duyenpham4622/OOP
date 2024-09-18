package tuan3_bai7_SinhVien;

public class SinhVien {
	private int maSinhVien;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    // Constructor mặc định
    public SinhVien() {
        this.maSinhVien = 0;
        this.hoTen = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }

    // Constructor có tham số
    public SinhVien(int maSinhVien, String hoTen, String diaChi, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = validateSoDienThoai(soDienThoai) ? soDienThoai : "";
    }

    // Getters và Setters
    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = validateSoDienThoai(soDienThoai) ? soDienThoai : "";
    }

    // Kiểm tra số điện thoại hợp lệ
    private boolean validateSoDienThoai(String soDienThoai) {
        return soDienThoai != null && soDienThoai.matches("\\d{10}");
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return String.format("Mã SV: %d\nHọ tên: %s\nĐịa chỉ: %s\nSố điện thoại: %s",
                maSinhVien, hoTen, diaChi, soDienThoai);
    }

}
