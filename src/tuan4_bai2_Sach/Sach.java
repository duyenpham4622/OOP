package tuan4_bai2_Sach;

import java.text.DecimalFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public abstract class Sach implements Comparable<Sach> {
	protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;
    abstract double thanhTien();  // Phương thức abstract

    public Sach() {
    }

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(int year, int month, int day) {
        this.ngayNhap = LocalDate.of(year, month, day);
    }
    public int compareTo(Sach other) {
        return this.maSach.compareTo(other.maSach);
    }

    public void nhapSach(Scanner scanner) {
        try {
            System.out.print("Nhập mã sách: ");
            maSach = scanner.nextLine();

            System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ngayNhap = LocalDate.parse(scanner.nextLine(), formatter);

            System.out.print("Nhập đơn giá: ");
            donGia = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập số lượng: ");
            soLuong = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập nhà xuất bản: ");
            nhaXuatBan = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập dữ liệu: " + e.getMessage());
        }
    }

    public void xuatSach() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("Mã sách: " + maSach);
            System.out.println("Ngày nhập: " + ngayNhap.format(formatter));
            System.out.println("Đơn giá: " + donGia);
            System.out.println("Số lượng: " + soLuong);
            System.out.println("Nhà xuất bản: " + nhaXuatBan);
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất dữ liệu: " + e.getMessage());
        }
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,##0.00VND");
        String formattedDonGia = df.format(donGia);
        return String.format("|%-10s|%-15s|%-15s|%-10d|%-20s|", maSach, ngayNhap.format(formatter), formattedDonGia,
                soLuong, nhaXuatBan);
    }
}

