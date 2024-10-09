package test;

import java.util.Scanner;

public class testCD {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dsCD danhSachCD = new dsCD(100);

        while (true) {
            System.out.println("1. Thêm CD");
            System.out.println("2. Sửa CD");
            System.out.println("3. Xóa CD");
            System.out.println("4. Tìm kiếm CD");
            System.out.println("5. Tính số lượng CD");
            System.out.println("6. Tính tổng giá thành");
            System.out.println("7. Sắp xếp giảm dần theo giá thành");
            System.out.println("8. Sắp xếp tăng dần theo tựa CD");
            System.out.println("9. Xuất toàn bộ danh sách");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");
            int chucNang = scanner.nextInt();
            scanner.nextLine();

            switch (chucNang) {
                case 1:
                    System.out.print("Nhập mã CD: ");
                    int maCD = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tựa CD: ");
                    String tieuCD = scanner.nextLine();
                    System.out.print("Nhập ca sỹ: ");
                    String caSy = scanner.nextLine();
                    System.out.print("Nhập số bài hát: ");
                    int soBaiHat = scanner.nextInt();
                    System.out.print("Nhập giá thành: ");
                    double giaThanh = scanner.nextDouble();
                    CD cd = new CD(maCD, tieuCD, caSy, soBaiHat, giaThanh);
                    danhSachCD.themCD(cd);
                    break;

                case 2:
                    System.out.print("Nhập mã CD cần sửa: ");
                    int maCDSua = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tựa CD mới: ");
                    String tieuCDMoi = scanner.nextLine();
                    System.out.print("Nhập ca sỹ mới: ");
                    String caSyMoi = scanner.nextLine();
                    System.out.print("Nhập số bài hát mới: ");
                    int soBaiHatMoi = scanner.nextInt();
                    System.out.print("Nhập giá thành mới: ");
                    double giaThanhMoi = scanner.nextDouble();
                    CD cdMoi = new CD(maCDSua, tieuCDMoi, caSyMoi, soBaiHatMoi, giaThanhMoi);
                    danhSachCD.suaCD(maCDSua, cdMoi);
                    break;

                case 3:
                    System.out.print("Nhập mã CD cần xóa: ");
                    int maCDXoa = scanner.nextInt();
                    danhSachCD.xoaCD(maCDXoa);
                    break;

                case 4:
                    System.out.print("Nhập mã CD cần tìm: ");
                    int maCDTim = scanner.nextInt();
                    CD cdTim = danhSachCD.timKiemCD(maCDTim);
                    if (cdTim != null) {
                        System.out.println(cdTim);
                    }
                    break;

                case 5:
                    System.out.println("Số lượng CD: " + danhSachCD.laySoLuong());
                    break;

                case 6:
                    System.out.println("Tổng giá thành: " + danhSachCD.tinhTongGiaThanh());
                    break;

                case 7:
                    danhSachCD.sapXepGiamDanTheoGia();
                    System.out.println("Đã sắp xếp giảm dần theo giá thành.");
                    break;

                case 8:
                    danhSachCD.sapXepTangDanTheoTieuCD();
                    System.out.println("Đã sắp xếp tăng dần theo tựa CD.");
                    break;

                case 9:
                    danhSachCD.xuatDanhSach();
                    break;

                case 10:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Chức năng không hợp lệ.");
                    break;
            }
        }
    }

}
