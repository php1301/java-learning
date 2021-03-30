import java.util.ArrayList;
import java.util.Scanner;

public class SinhVien {

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public double getDtb() {
		return dtb;
	}

	public void setDtb(double dtb) {
		this.dtb = dtb;
	}

	private String maSo;
	private String ten;
	private double dtb;

	SinhVien() {
		maSo = "000000";
		ten = "";
		dtb = 0;
	}

	SinhVien(String maSo, String ten, double dtb) {
		this.maSo = maSo;
		this.ten = ten;
		this.dtb = dtb;
	}

	public SinhVien nhap() {
		Scanner input = new Scanner(System.in);
		String maSo = input.next();
		String ten = input.next();
		double dtb = input.nextDouble();
//		this.maSo = maSo;
//		this.ten = ten;
//		this.dtb = dtb;
		SinhVien svNew = new SinhVien(maSo, ten, dtb);
		return svNew;
	}

	public void xuatSV() {
		System.out.println("Sinh vien " + ten + " co ma so sinh vien " + maSo + " co diem trung binh la " + dtb);
	}

	public String toString() {
		String message = "Sinh vien " + ten + " co ma so sinh vien " + maSo + " co diem trung binh la " + dtb;
		return message;
	}
}
