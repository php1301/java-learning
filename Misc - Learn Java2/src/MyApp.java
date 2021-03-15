
public class MyApp {
	private static PhanSo p1;
	private static PhanSo p2;

	public static void main(String[] args) {

		System.out.println();
		p1 = new PhanSo();
		p1.nhap();
		p2 = new PhanSo();
		p2.nhap();

		p1.xuat();
		p2.xuat();

		p1.tong(p2);
	}

}
