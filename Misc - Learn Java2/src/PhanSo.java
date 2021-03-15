import java.util.Scanner;

public class PhanSo {
	private int tuSo;
	private int mauSo;

	public PhanSo() {
	}

	public void nhap() {
		Scanner input = new Scanner(System.in);
		int tu = input.nextInt();
		int mau = input.nextInt();
		this.tuSo = tu;
		this.mauSo = mau;
		input.close();
	}

	public void xuat() {
		System.out.println("Phan so la: " + tuSo + "/" + mauSo);
	}

	public int getMauSo() {
		return mauSo;
	}

	public void setMauSo(int mauSo) {
		this.mauSo = mauSo;
	}

	public void tong(PhanSo p) {
		int resTu = 0;
		int resMau = 0;
		if (this.mauSo == p.mauSo) {
			resTu = tuSo + p.tuSo;
			resMau = mauSo;
		} else {
			resTu = tuSo * p.mauSo + p.tuSo * mauSo;
			resMau = mauSo * p.mauSo;
		}
		System.out.println("Tong la: " + resTu + "/" + resMau);
	}

}
