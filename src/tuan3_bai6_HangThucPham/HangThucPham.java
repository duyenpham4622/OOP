package tuan3_bai6_HangThucPham;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
	private static final String DEFAULT_MA_HANG = "UNKNOWN";
    private static final String DEFAULT_TEN_HANG = "UNKNOWN";
    private static final double DEFAULT_DON_GIA = 0.0;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, String ngaySanXuat, String ngayHetHan) {
        this.maHang = validateMaHang(maHang) ? maHang : DEFAULT_MA_HANG;
        this.tenHang = validateTenHang(tenHang) ? tenHang : DEFAULT_TEN_HANG;
        this.donGia = validateDonGia(donGia) ? donGia : DEFAULT_DON_GIA;
        this.ngaySanXuat = parseDate(ngaySanXuat);
        this.ngayHetHan = parseDate(ngayHetHan);
        if (!isValidNgayHetHan(this.ngaySanXuat, this.ngayHetHan)) {
            this.ngayHetHan = this.ngaySanXuat; // Gán ngày hết hạn mặc định là ngày sản xuất
        }
    }

    // Constructor với tham số mã hàng
    public HangThucPham(String maHang) {
        this(maHang, DEFAULT_TEN_HANG, DEFAULT_DON_GIA, DATE_FORMAT.format(new Date()), DATE_FORMAT.format(new Date()));
    }

    // Setters
    public void setMaHang(String maHang) {
        this.maHang = validateMaHang(maHang) ? maHang : DEFAULT_MA_HANG;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = validateTenHang(tenHang) ? tenHang : DEFAULT_TEN_HANG;
    }

    public void setDonGia(double donGia) {
        this.donGia = validateDonGia(donGia) ? donGia : DEFAULT_DON_GIA;
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        Date parsedDate = parseDate(ngaySanXuat);
        if (parsedDate != null) {
            this.ngaySanXuat = parsedDate;
            if (this.ngayHetHan != null && !isValidNgayHetHan(this.ngaySanXuat, this.ngayHetHan)) {
                this.ngayHetHan = this.ngaySanXuat;
            }
        }
    }

    public void setNgayHetHan(String ngayHetHan) {
        Date parsedDate = parseDate(ngayHetHan);
        if (parsedDate != null && isValidNgayHetHan(this.ngaySanXuat, parsedDate)) {
            this.ngayHetHan = parsedDate;
        } else {
            this.ngayHetHan = this.ngaySanXuat;
        }
    }

    // Getters
    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getNgaySanXuat() {
        return DATE_FORMAT.format(ngaySanXuat);
    }

    public String getNgayHetHan() {
        return DATE_FORMAT.format(ngayHetHan);
    }

    // Kiểm tra hết hạn
    public boolean isExpired() {
        return ngayHetHan.before(new Date());
    }

    // Phương thức toString
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return String.format("Mã hàng: %s\nTên hàng: %s\nĐơn giá: %s VNĐ\nNgày sản xuất: %s\nNgày hết hạn: %s\n",
                maHang, tenHang, df.format(donGia), getNgaySanXuat(), getNgayHetHan());
    }

    // Phương thức hỗ trợ kiểm tra dữ liệu hợp lệ
    private boolean validateMaHang(String maHang) {
        return maHang != null && !maHang.trim().isEmpty();
    }

    private boolean validateTenHang(String tenHang) {
        return tenHang != null && !tenHang.trim().isEmpty();
    }

    private boolean validateDonGia(double donGia) {
        return donGia > 0;
    }

    private boolean isValidNgayHetHan(Date ngaySanXuat, Date ngayHetHan) {
        return ngayHetHan != null && ngaySanXuat != null && ngayHetHan.after(ngaySanXuat);
    }

    private Date parseDate(String dateString) {
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

}
