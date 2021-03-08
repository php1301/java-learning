import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.InputStreamReader;

public class MyApp {
	private static DecimalFormat df = new DecimalFormat("0.0");
	final static double piNum = 3.1416;

	public static void main(String[] args) throws IOException {
//		Phuong thuc static chi goi duoc phuong thuc static
		Scanner input = new Scanner(System.in);

//		System.out.println("Nhap chieu dai va chieu rong");
//		float dai = input.nextFloat();
//		float rong = input.nextFloat();
//		System.out.println("Chu vi la: " + df.format((dai + rong) * 2));
//		System.out.println("Dien tich la: " + df.format(dai * rong));
//		dienTichChuViHinhTron();
//		dienTichChuViHinhChuNhatBuffer();
//		mang1Chieu();
		bienLuanPtBac1(0, 2);
		input.close();
	}

	static void dienTichChuViHinhTron() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ban kinh");
		float banKinh = input.nextFloat();
		String chuVi = df.format(banKinh * piNum);
		String dienTich = df.format(Math.pow(banKinh, 2) / 2);
		System.out.println("Chu vi la: " + chuVi);
		System.out.println("Dien tich la: " + dienTich);
	}

	static void dienTichChuViHinhChuNhatBuffer() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		float a, b;
		str = br.readLine();
		a = Float.parseFloat(str);
		str = br.readLine();
		b = Float.parseFloat(str);
		String chuVi = df.format((a + b) * 2);
		String dienTich = df.format(a * b);
		System.out.println("Chu vi Buffer Reader la: " + chuVi);
		System.out.println("Dien tich Buffer Reader la: " + dienTich);
	}

	static void xuatMang(int[] numbers) {
		int tong = 0;
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Phan tu thu " + (i+1) +" " + numbers[i]);
			tong+=numbers[i];
		}
		System.out.println("Tong cac phan tu trong mang la: " + tong);
	}
	static boolean timPhanTu(int[] numbers, int x) {
		for (int i = 0; i < numbers.length; i++) {
				if(numbers[i] == x) return true;
		}
		return false;
	}
	static void mang1Chieu() {
		System.out.println("Nhap mang");
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String[] addElement = line.split(" ");
		int[] numbers = new int[addElement.length];
		for (int i=0; i<numbers.length;i++)
		    numbers[i] = Integer.parseInt(addElement[i]);
		xuatMang(numbers);
		System.out.println("Nhap phan tu can tim");
		int pt = input.nextInt();
		if(timPhanTu(numbers, pt)) {
			System.out.println("Phan tu "+ pt + " co ton tai trong mang");
		}
		else {
			System.out.println("Khong ton tai phan tu "+ pt + " trong mang");
		}
		
	}
	static void bienLuanPtBac1(int b, float c) {
		if(b!=0) {
			System.out.println("Phuong trinh co mot nghiem duy nhat x = -c/b: " + (-c/b));
		}
		if(b==0) {
			if(c==0) {
				System.out.println("Phuong trinh co nghiem dung voi moi x");
			}
			else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}
	}
}
