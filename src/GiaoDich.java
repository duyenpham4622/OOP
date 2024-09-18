package tuan5_bai3_giaodich;

import java.util.Scanner;

public class GiaoDich {
	protected int MaGD,SoLuong;
	protected String NgayGD;
	protected double DonGia,ThanhTien;
	
	Scanner in = new Scanner(System.in);
	
//constructor mặc đinh//
	protected GiaoDich()
	{
		this.MaGD = 0;
		this.DonGia = 0;
		this.SoLuong = 0;
		this.ThanhTien = 0;
		this.NgayGD ="";
	}
	protected GiaoDich(int MaGD,int SoLuong,String NgayGD,double DonGia,double ThanhTien)
	{
		this.MaGD = MaGD;
		this.DonGia = DonGia;
		this.NgayGD = NgayGD;
		this.SoLuong = SoLuong;
		this.ThanhTien = ThanhTien;
	}
	
	

}
