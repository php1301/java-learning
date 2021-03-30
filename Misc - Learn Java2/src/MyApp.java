import java.util.ArrayList;
import java.util.Scanner;

public class MyApp {
	private static PhanSo p1;
	private static PhanSo p2;
	private static ArrayList<SinhVien> dssv;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		dssv = new ArrayList<SinhVien>();
//		p1 = new PhanSo(4, 4);
//		PhanSo p1tg = p1.rutGon();
//		p1tg.xuat();
		System.out.println("Nhap so si so sinh vien: ");
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			SinhVien sv = new SinhVien();
			SinhVien svToAdd = sv.nhap();
			dssv.add(svToAdd);
		}

		System.out.println(dssv.toString());

		System.out.println("Nhap ten sinh vien muon tim: ");
		String ten = input.next();

		for (SinhVien sv : dssv) {
			if (ten == sv.getTen()) {
				System.out.println("Sinh vien " + ten + " o vi tri thu" + dssv.indexOf(sv));
			}
		}
		int indexMax = 0;
		double max = 0;
		for (SinhVien sv : dssv) {
			if (sv.getDtb() > max) {
				max = sv.getDtb();
				indexMax = dssv.indexOf(sv);
			}
		}

		System.out.println("Sinh vien co diem trung binh cao nhat la " + dssv.get(indexMax).toString());
//		System.out.println();
//		p1 = new PhanSo();
//		p1.nhap();
//		p2 = new PhanSo();
//		PhanSo tong = new PhanSo();
//		PhanSo tich = new PhanSo();
//		p2.nhap();
//
//		p1.xuat();
//		p2.xuat();
//
//		tong = p1.tong(p2);
//		tong.xuat();
//		tich = p1.nhan(p2);
//		tich.xuat();

//		HinhTron ht1 = new HinhTron(2.3);
//		double cv = ht1.chuVi();
//		double dt = ht1.dienTich();
//		System.out.println(cv + " " + dt);

//		HinhTru htru1 = new HinhTru(4, 6);
//		double cv = htru1.chuVi();
//		double dt = htru1.dienTichHinhTru();
//		System.out.println(cv + " " + dt);

//		SinhVien sv = new SinhVien();
//		sv.nhap();
//		sv.xuatSV();

	}

}
