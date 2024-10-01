package tuan4_bai1_ChuyenXe;

import java.util.Scanner;

public class KiemThuChuyenXe {
	static DanhSachChuyenXe DS = new DanhSachChuyenXe();

	static void Menu() {
		System.out.println("\t****************************************");
		System.out.println("\t**   Chương trình quản lí chuyến xe   **");
		System.out.println("\t* 1. Nhập cứng                         *");
		System.out.println("\t* 2. Thêm 1 chuyến xe                  *");
		System.out.println("\t* 3. Xóa                               *");
		System.out.println("\t* 4. Sửa                               *");
		System.out.println("\t* 5. Xuất doanh thu                    *");
		System.out.println("\t* 6. Xuất                              *");
		System.out.println("\t* 7. Sắp xếp theo doanh thu            *");
		System.out.println("\t* 8. Sắp xếp theo tên tài xế           *");
		System.out.println("\t* 9. Xuất danh sách xe ngoại thành     *");
		System.out.println("\t* 10.Xuất danh sách xe nội thành       *");
		System.out.println("\t* 11.Sắp xếp theo 2 thuộc  tính        *");
		System.out.println("\t* 12. Thoát                            *");
		System.out.println("\t****************************************");
	}

	static void menuSuaNT() {
		System.out.println("\t****************************************");
		System.out.println("\t**       Mời nhập thông tin cần sửa    **");
		System.out.println("\t* 1. Họ và tên tài xế                   *");
		System.out.println("\t* 2. Số xe                              *");
		System.out.println("\t* 3. Số tuyến                           *");
		System.out.println("\t* 4. Số km đi được                      *");
		System.out.println("\t* 5. Doanh thu                          *");
		System.out.println("\t* 6. Về menu chính                      *");
		System.out.println("\t*****************************************");
	}

	static void menuSuaNgT() {
		System.out.println("\t****************************************");
		System.out.println("\t**       Mời nhập thông tin cần sửa    **");
		System.out.println("\t* 1. Họ và tên tài xế                   *");
		System.out.println("\t* 2. Số xe                              *");
		System.out.println("\t* 3. Nơi đến                            *");
		System.out.println("\t* 4. Số ngày đi được                    *");
		System.out.println("\t* 5. Doanh thu                          *");
		System.out.println("\t* 6. Về menu chính                      *");
		System.out.println("\t*****************************************");
	}

	static void nhapCung() throws Exception {
		try {
			ChuyenXe nt = new NoiThanh("CX001", "Trần Văn Linh", 1, 3000000, 3, 12.3);
			ChuyenXe ngt = new NgoaiThanh("CX002", "Lê Văn Bình", 2, 2000000, "Long Thành", 12);
			ChuyenXe nt1 = new NoiThanh("CX003", "Võ Tấn Đạt", 1, 1600000, 3, 12.3);
			ChuyenXe ngt1 = new NgoaiThanh("CX004", "Võ An Vy", 2, 8000000, "An Nhơn", 12);
			DS.them(nt);
			DS.them(ngt);
			DS.them(nt1);
			DS.them(ngt1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	static ChuyenXe cXe; // khai báo toàn cục
	
	static ChuyenXe ThemMotXe() {
		try {
			String maChuyenXe, hoTen;
			int soXe;
			double doanhThu;
			
			System.out.println("Nhập mã chuyến xe: ");
			maChuyenXe = new Scanner(System.in).nextLine();
			int vt = DS.timKiemViTri(maChuyenXe);
			if (vt == -1) {  // không trùng
				System.out.println("Nhập tên tài xế: ");
				hoTen = new Scanner(System.in).nextLine();
				System.out.println("Nhập doanh thu: ");
				doanhThu = new Scanner(System.in).nextDouble();
				System.out.println("Nhập số xe: ");
				soXe = new Scanner(System.in).nextInt();
				
				
				System.out.println("Nhập xe nội thành [1] hoặc khác để nhập xe ngoại thành: ");
				
				int chon = new Scanner(System.in).nextInt(); // để nhập 1 hay khác 
				
				if (chon != 1) {
					String noiDen;
					int soNgayDiDuoc;
					System.out.println("Nhập nơi đến: ");
					noiDen = new Scanner(System.in).nextLine();
					System.out.println("Nhập số ngày đi được: ");
					soNgayDiDuoc = new Scanner(System.in).nextInt();
					
					cXe = new NgoaiThanh(maChuyenXe, hoTen, soXe, doanhThu, noiDen, soNgayDiDuoc);
					
					// throw new Exception("Đã thêm thành công một xe ngoại thành");
				} else {
					int soTuyen;
					double soKm;
					System.out.println("Nhập số tuyết: ");
					soTuyen = new Scanner(System.in).nextInt();
					System.out.println("Nhập số km đi được: ");
					soKm = new Scanner(System.in).nextDouble();
					cXe = new NoiThanh(maChuyenXe, hoTen, soXe, doanhThu, soTuyen, soKm);

					// throw new Exception("Đã thêm thành công một xe nội thành");
				}

			} else { // ngược của cái if tìm mã xe 

				System.out.println("Mã chuyến xe đã trùng");
				return null;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cXe;

	}

	static void xuat(DanhSachChuyenXe DS) {
		for (ChuyenXe xe : DS.getDS()) {
			System.out.println(xe);
		}
	}

	static void xoa(DanhSachChuyenXe DS) {
		try {
			System.out.println("Nhập mã chuyến xe cần xóa: ");
			String MaChuyenXe = new Scanner(System.in).nextLine();
			ChuyenXe xex = DS.timKiem(MaChuyenXe);
			if (xex != null) {
				System.out.println("Bạn có xác nhận xóa xe này không [y/n]: ");
				String acp = new Scanner(System.in).nextLine();
				if (acp.equalsIgnoreCase("y")) {
					DS.xoa(xex);
					throw new Exception("Đã xóa thành công");
				} else {
					throw new Exception("Bạn đã giữ lại chuyến xe này");
				}
			} else
				throw new Exception("Không tồn tại xe này");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	static void sua(DanhSachChuyenXe DS) throws Exception {
		try {
			int chon = -1; int count = 0;
			System.out.println("Nhập mã chuyến xe cần sửa: ");
			String MaChuyenXe = new Scanner(System.in).nextLine();
			ChuyenXe xe = DS.timKiem(MaChuyenXe);
			
			if (xe == null)
				throw new Exception("Mã chuyến xe này không tồn tại");
			else {
				if (xe instanceof NoiThanh) {
					NoiThanh xes = (NoiThanh) xe;
					System.out.println("Thông tin xe trước khi sửa: \n" + xes);
					do {
						menuSuaNT();
						System.out.println("Nhập lựa chọn");
						chon = new Scanner(System.in).nextInt();
						count++;
						switch (chon) {
						case 1:
							System.out.println("Nhập tên tài xế: ");
							xes.setHoTen(new Scanner(System.in).nextLine());
							break;
						case 2:
							System.out.println("Nhập số xe: ");
							xes.setSoXe(new Scanner(System.in).nextInt());
							break;
						case 3:
							System.out.println("Nhập số tuyến: ");
							xes.setSoTuyen(new Scanner(System.in).nextInt());
							break;
						case 4:
							System.out.println("Nhập số km đi được: ");
							xes.setSoKm(new Scanner(System.in).nextDouble());
							break;
						case 5:
							System.out.println("Nhập doanh thu: ");
							xes.setDoanhThu(new Scanner(System.in).nextDouble());
							break;
						default:
							if(count > 1)
								DS.sua(xes);
							System.out.println("Về menu chính");
							break;
						}
					} while (chon < 6);

				} else {
					NgoaiThanh xes = (NgoaiThanh) xe;
					System.out.println("Thông tin xe trước khi sửa: \n" + xes);
					do {
						menuSuaNgT();
						System.out.println("Nhập lựa chọn");
						chon = new Scanner(System.in).nextInt();
						count++;
						switch (chon) {
						case 1:
							System.out.println("Nhập tên tài xế: ");
							xes.setHoTen(new Scanner(System.in).nextLine());
							break;
						case 2:
							System.out.println("Nhập số xe: ");
							xes.setSoXe(new Scanner(System.in).nextInt());
							break;
						case 3:
							System.out.println("Nhập nơi đến: ");
							xes.setNoiDen(new Scanner(System.in).nextLine());
							break;
						case 4:
							System.out.println("Nhập số ngày đi được: ");
							xes.setSoNgayDiDuoc(new Scanner(System.in).nextInt());
							break;
						case 5:
							System.out.println("Nhập doanh thu: ");
							xes.setDoanhThu(new Scanner(System.in).nextDouble());
							break;
						default:
							if(count > 1)
								DS.sua(xes);
							System.out.println("Về menu chính");
							break;
						}

					} while (chon < 6);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	static void getDSXeNgoaiThanh() {
		System.out.println("Danh sách xe ngoại thành: ");
		for (ChuyenXe xeNgoai : DS.getDSXeNgoaiThanhDung())
			System.out.println(xeNgoai);
	}

	static void getDSXeNoiThanh() {
		System.out.println("Danh sách xe nội thành: ");
		for (NoiThanh xeNoi : DS.getDSXeNoiThanh())
			System.out.println(xeNoi);

	}

	static void sortTheo2Fied() {
		DS.sortTheo2Fied();
		System.out.println("Đã xắp xếp thành công");
	}

	public static void main(String[] args) throws Exception {
		int chon = -1;
		do {
			Menu();
			System.out.println("Nhập lựa chọn: ");

			chon = new Scanner(System.in).nextInt();
			switch (chon) {
			case 1:
				nhapCung();
				break;
			case 2:
				ChuyenXe xe = ThemMotXe();
				if (xe != null) {
					DS.them(xe);
					System.out.println("Thêm thành công");
				}

				else
					System.out.println("Thêm không thành công");
				break;
			case 3:
				xoa(DS);
				break;
			case 4:
				sua(DS);
				break;
			case 5:
				System.out.println("Doanh thu la: " + DS.tinhDoanhThu());
				break;
			case 6:
				xuat(DS);
				break;
			case 7:
				DS.sortTheoDoanhThu();
				System.out.println("Đã sắp xếp thành công");
				break;
			case 8:
				DS.sortTheoTenTaiXe();
				System.out.println("Đã sắp xếp thành công");
				break;
			case 9:
				getDSXeNgoaiThanh();
				break;
			case 10:
				getDSXeNoiThanh();
				break;
			case 11:
				sortTheo2Fied();
				break;

			default:
				System.out.println("Cảm ơn bạn đã sử dụng chương trình");
			}
		} while (chon < 12);
	}


}
