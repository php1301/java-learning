
public class HinhTru extends HinhTron {

	private double height;

	HinhTru() {
		super();
		height = 0;
	}

	HinhTru(double r, double height) {
		super(r); // khoi tao hinh tron
		this.height = height;
	}

	public double dienTichHinhTru() {
		double dtDay = super.dienTich(); // <=> dienTich();
		return dtDay * height;
	}

	public double chuViHinhTruTron() {
		return 2 * chuVi();
	}

}
