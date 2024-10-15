package mssv_tensv;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestMain {
	static Scanner sc = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void nhapCung(DanhSachHangHoa ds) throws Exception {
		ds.addHH(new HangThucPham("1", "1", 1, 1, "1", LocalDate.parse("10/10/2022",dtf), LocalDate.parse("10/10/2023",dtf)));
		ds.addHH(new HangDienMay("2", "2", 2, 2,2,2));
		ds.addHH(new HangSanhSu("3", "3", 3, 3,"3",LocalDate.parse("10/10/2022",dtf)));
	}
	public static int  nhapInt(String prompt) {
		System.out.println(prompt);
		int n = sc.nextInt();
		sc.nextLine();
		return n;
	}
	public static double nhapDouble(String prompt) {
		System.out.println(prompt);
		double n = sc.nextDouble();
		sc.nextLine();
		return n;
	}
	public static String nhapString(String prompt) {
		System.out.println(prompt);
		return sc.nextLine();
	}
	public static void main(String[] args) throws Exception {
		
		DanhSachHangHoa ds = new DanhSachHangHoa();
		
		
		int choice = 0;
		do {
			System.out.println("\n-----------MENU------------\n"
				+ "1.Nhap cung\n"
				+ "2.Them hang hoa\n"
				+ "3.In tat ca danh sach\n"
				+ "4.In danh sach hang thuc pham\n"
				+ "5.In danh sach hang diem may\n"
				+ "6.In danh sach hang sanh su\n"
				+ "7.Tim kim hang hoa\n"
				+ "8.Sap xep hang hoa theo ten\n"
				+ "9.Sap xep hang hoa theo so luong ton\n"
				+ "10.In cac hang thuc pham kho ban\n"
				+ "11.Xoa hang hoa\n"
				+ "12.Sua don gia hang hoa\n"
				+ "0.Thoat\n");
			
			choice = nhapInt("Vui long nhap lua chon: ");
			
			switch (choice) {
			case 1: 
				nhapCung(ds);
				break;
			case 2:
				int chon = 0;
				do {
					System.out.print("Nhap loai hang muon nhap\n"
						+ "1.Hang Thuc Pham\n"
						+ "2.Hang Diem May\n"
						+ "3.Hang Gom Su\n"
						+ "0.Thoat\n");
					chon = nhapInt("Nhap lua chon: ");
					if(chon == 0 ) break;
					String ma =nhapString("Nhap ma: ");
					String ten = nhapString("Nhap Ten hang: ");
					double gia = nhapDouble("Nhap gia:");
					int ton = nhapInt("Nhap ton:");
					switch (chon) {
						case 1:
							String tenNCC = nhapString("Nhap ten NCC: ");
							String ngaySX = nhapString("Nhap ngay/thang/nam san suat:");
							String ngayHH = nhapString("Nhap ngay/thang/nam het han:");
							HangHoa htp = new HangThucPham(ma, ten, gia, ton, tenNCC, LocalDate.parse(ngaySX,dtf),LocalDate.parse(ngayHH,dtf));
							if(ds.addHH(htp)) System.out.println("Them thanh cong");
							else System.out.println("Them khong thanh cong");
							break;
						case 2:
							int tgbh = nhapInt("Thoi gian bao hanh: ");
							double cs =nhapDouble("Nhap cong suat: ");
							HangHoa hdm = new HangDienMay(ma, ten, gia,ton,tgbh,cs);
							if(ds.addHH(hdm)) System.out.println("Them thanh cong");
							else System.out.println("Them khong thanh cong");
							break;
						case 3:
							String nsx = nhapString("Nhap Nha SX: ");
							String ngayNK = nhapString("Nhap Ngay/Thang/Nam nhap nho: ");
							HangHoa hss = new HangSanhSu(ma, ten, gia, ton, nsx,LocalDate.parse(ngayNK,dtf));
							if(ds.addHH(hss)) System.out.println("Them thanh cong");
							else System.out.println("Them khong thanh cong");
							break;
						default:
							break;
					}
				}while(chon !=0 );
				break;
			case 3:
				String tthh = ds.getDSHH();
				System.out.print(tthh);
				break;
			case 4:
				String tttp = ds.getHangThucPham();
				System.out.print(tttp);
				break;
			case 5:
				String ttdm = ds.getHangDienMay();
				System.out.print(ttdm);
				break;
			case 6:
				String ttss = ds.getHangSanhSu();
				System.out.print(ttss);
				break;
			case 7:
				String maHH = nhapString("Nhap ma hh can tim:");
				HangHoa hh = ds.timHangHoa(maHH);
				if(hh == null)
					System.out.print("Khong co hang hoa nay");
				else
					System.out.println(hh);
				break;
			case 8:
				ds.sapXepTheoTen();
				System.out.println(ds);
				break;
			case 9:
				ds.sapXepTheoSLTon();
				System.out.println(ds);
				break;
			case 10:
				String dskb = ds.getTTDanhSach_HTP_Kho_Ban();
				System.out.println(dskb);
				break;
			case 11:
				String ma = nhapString("Nhap ma HH can xoa: ");
				if(ds.xoaHangHoa(ma)) 
					System.out.println("Xoa thanh cong");
				else 
					System.out.println("Xoa khong thanh cong");
				break;
			case 12:
				String ma2  = nhapString("Nhap ma:");
				double giaMoi  = nhapDouble("Nhap gia moi:");
				ds.suaDonGia(ma2, giaMoi);
				break;
			default:
				break;
			}
		}while(choice != 0);
		sc.close();
	}
}
	

	
