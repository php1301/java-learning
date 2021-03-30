import java.util.Scanner;

public class PhanSo {
	private int tuSo;
	private int mauSo;

	public PhanSo() {

	}

	public PhanSo(int tuSo, int mauSo) {
		this.tuSo = tuSo;
		this.mauSo = mauSo;
	}

	public void nhap() {
		Scanner input = new Scanner(System.in);
		int tu = input.nextInt();
		int mau = input.nextInt();
		this.tuSo = tu;
		this.mauSo = mau;
//		input.close();
	}

	public void xuat() {
		if (tuSo != mauSo)
			System.out.println("Phan so la: " + tuSo + "/" + mauSo);
		else {
			System.out.println("Phan so la 1");
		}
	}

	public int getMauSo() {
		return mauSo;
	}

	public void setMauSo(int mauSo) {
		this.mauSo = mauSo;
	}

	public PhanSo tong(PhanSo p) {
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
		PhanSo res = new PhanSo(resTu, resMau);
		return res;
	}

	public PhanSo nhan(PhanSo p) {

		PhanSo product = new PhanSo();
		product.tuSo = this.tuSo * p.tuSo;
		product.mauSo = this.mauSo * p.mauSo;
		return product;
	}

	public PhanSo rutGon() {
		int a = tuSo;
		int b = mauSo;
		while (a != b) {
			if (a > b) {
				a = a - b;

			} else {
				b = b - a;
			}
		}
		this.tuSo /= a;
		this.mauSo /= b;
		return new PhanSo(tuSo, mauSo);
	}
}
