package tuan1_bai2;

import java.util.Scanner;

public class TestQLSV {
	public static void main(String[] args) {
		QLSV q1 = new QLSV(200, "long", 10, 8);
		QLSV q2 = new QLSV(201,"nam", 10, 7);
		System.out.println(q1);
		System.out.println(q2);
		
		Scanner sc = new Scanner(System.in);
		QLSV q3 = new QLSV();
		System.out.println("Nhapj mssv");
		int c = sc.nextInt();
		q3.setMssv(c);
		System.out.println("nhap ho ten");
		String d = sc.next();
		q3.setHoTen(d);
		System.out.println("diem th");
		float a = sc.nextFloat();
		q3.setDiemLT(a);
		float b = sc.nextFloat();
		q3.setDiemTH(b);
		System.out.println("diem lt");
		System.out.println(q3);
	}

}
