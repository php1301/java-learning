
public class HinhTron {
	final static double piNum = 3.1416;
	private double banKinh;

	HinhTron() {
		banKinh = 0;
	}
	

	HinhTron(double banKinh) {
		this.banKinh = banKinh;
	}

	public double chuVi() {
		return banKinh * piNum;
	}

	public double dienTich() {
		return Math.pow(banKinh, 2) * piNum;
	}
	
	public void print() {
		System.out.println("Hinh tron co ban kinh la: " + banKinh);
	}
}
