package tuan8_bai2_PhongHoc;

import java.util.Scanner;

public class KiemthuPhongHoc {
	
	
		

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        QuanLyPhongHoc quanLy = new QuanLyPhongHoc();
		
		PhongLyThuyet phongLyThuyet = new PhongLyThuyet("LT01", "Nhà A", 60, 7, true);
        PhongMayTinh phongMayTinh = new PhongMayTinh("MT01", "Nhà B", 30, 4, 20);
        PhongThiNghiem phongThiNghiem = new PhongThiNghiem("TN01", "Nhà C", 50, 5, "Hóa", 30, true);
        
        System.out.println(quanLy);
		System.out.println(String.format("| %-10s | %-8s | %-10s | %-12s | %-10s | %-12s | %-10s | %-10s |", "Mã phòng", "Dãy nhà", "Diện tích", "Số bóng đèn", "Máy chiếu", "Số máy tính", "Chuyên ngành", "Sức chứa"));
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Thêm phòng học");
            System.out.println("2. Tìm phòng học");
            System.out.println("3. In danh sách phòng học");
            System.out.println("4. In danh sách phòng đạt chuẩn");
            System.out.println("5. Tổng số phòng học");
            System.out.println("6. In phòng máy tính có 60 máy");
            System.out.println("7. Xóa phòng học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới
            
            switch (choice) {
                case 1:
                    // Thêm phòng học
                    System.out.print("Nhập mã phòng: ");
                    String maPhong = scanner.nextLine();
                    System.out.print("Nhập dãy nhà: ");
                    String dayNha = scanner.nextLine();
                    System.out.print("Nhập diện tích: ");
                    double dienTich = scanner.nextDouble();
                    System.out.print("Nhập số bóng đèn: ");
                    int soBongDen = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng mới
                    
                    System.out.print("Chọn loại phòng (1 - Lý thuyết, 2 - Máy tính, 3 - Thí nghiệm): ");
                    int loaiPhong = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng mới
                    
                    if (loaiPhong == 1) {
                        System.out.print("Có máy chiếu không? (true/false): ");
                        boolean coMayChieu = scanner.nextBoolean();
                        PhongLyThuyet phongLyThuyet1 = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                        if (quanLy.themPhongHoc(phongLyThuyet1)) {
                            System.out.println("Thêm phòng lý thuyết thành công!");
                        } else {
                            System.out.println("Mã phòng đã tồn tại!");
                        }
                    } else if (loaiPhong == 2) {
                        System.out.print("Nhập số máy tính: ");
                        int soMayTinh = scanner.nextInt();
                        PhongMayTinh phongMayTinh1 = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                        if (quanLy.themPhongHoc(phongMayTinh1)) {
                            System.out.println("Thêm phòng máy tính thành công!");
                        } else {
                            System.out.println("Mã phòng đã tồn tại!");
                        }
                    } else if (loaiPhong == 3) {
                        System.out.print("Nhập chuyên ngành: ");
                        String chuyenNganh = scanner.nextLine();
                        System.out.print("Nhập sức chứa: ");
                        int sucChua = scanner.nextInt();
                        System.out.print("Có bồn rửa không? (true/false): ");
                        boolean coBonRua = scanner.nextBoolean();
                        PhongThiNghiem phongThiNghiem1 = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
                        if (quanLy.themPhongHoc(phongThiNghiem1)) {
                            System.out.println("Thêm phòng thí nghiệm thành công!");
                        } else {
                            System.out.println("Mã phòng đã tồn tại!");
                        }
                    }
                    break;
                case 2:
                    // Tìm phòng học
                    System.out.print("Nhập mã phòng: ");
                    maPhong = scanner.nextLine();
                    PhongHoc phongTim = quanLy.timPhong(maPhong);
                    if (phongTim != null) {
                        System.out.println("Tìm thấy phòng: " + phongTim.getMaPhong());
                    } else {
                        System.out.println("Không tìm thấy phòng!");
                    }
                    break;
                case 3:
                    // In danh sách phòng học
                    quanLy.inDanhSach();
                    break;
                case 4:
                    // In danh sách phòng đạt chuẩn
                    quanLy.inPhongDatChuan();
                    break;
                case 5:
                    // Tổng số phòng học
                    System.out.println("Tổng số phòng học: " + quanLy.tongSoPhong());
                    break;
                case 6:
                    // In phòng máy tính có 60 máy
                    quanLy.inPhongMay60();
                    break;
                case 7:
                    // Xóa phòng học
                    System.out.print("Nhập mã phòng cần xóa: ");
                    maPhong = scanner.nextLine();
                    System.out.print("Bạn có chắc chắn xóa không? (true/false): ");
                    boolean xacNhan = scanner.nextBoolean();
                    if (xacNhan) {
                        if (quanLy.xoaPhong(maPhong)) {
                            System.out.println("Xóa phòng thành công!");
                        } else {
                            System.out.println("Không tìm thấy phòng để xóa!");
                        }
                    } else {
                        System.out.println("Hủy bỏ xóa phòng.");
                    }
                    break;
                case 0:
                    // Thoát
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Chọn chức năng không hợp lệ!");
            }
        }
    }

}
