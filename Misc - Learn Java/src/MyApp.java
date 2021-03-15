import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
//		bienLuanPtBac1(0, 2);
//		int n = input.nextInt();
//		int[] a = new int[n];
//		int[] b = new int[n + 1];
//		nhapMang(a, n);
//		xuatMangNew(a, n);
//		maxValue(a, n);
//		sortArray(a);
//		b = chen(a, 3);
//		xuatMangNew(b, n + 1);
		int x, y = 0;
		System.out.println("Nhap so hang so cot");
		x = input.nextInt();
		y = input.nextInt();
		int[][] c = new int[x][y];
		nhapMang2Chieu(c, x, y);
		sortMang2Chieu(c, x, y);
		xuatMang2Chieu(c, x, y);
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
			System.out.println("Phan tu thu " + (i + 1) + " " + numbers[i]);
			tong += numbers[i];
		}
		System.out.println("Tong cac phan tu trong mang la: " + tong);
	}

	static boolean timPhanTu(int[] numbers, int x) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == x)
				return true;
		}
		return false;
	}

	static void mang1Chieu() {
		System.out.println("Nhap mang");
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String[] addElement = line.split(" ");
		int[] numbers = new int[addElement.length];
		for (int i = 0; i < numbers.length; i++)
			numbers[i] = Integer.parseInt(addElement[i]);
		xuatMang(numbers);
		System.out.println("Nhap phan tu can tim");
		int pt = input.nextInt();
		if (timPhanTu(numbers, pt)) {
			System.out.println("Phan tu " + pt + " co ton tai trong mang");
		} else {
			System.out.println("Khong ton tai phan tu " + pt + " trong mang");
		}
	}

	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	static void nhapMang(int[] a, int n) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			a[i] = input.nextInt();
		}
	}

	static void xuatMangNew(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + " ");
		}
	}

	static void bienLuanPtBac1(int b, float c) {
		if (b != 0) {
			System.out.println("Phuong trinh co mot nghiem duy nhat x = -c/b: " + (-c / b));
		}
		if (b == 0) {
			if (c == 0) {
				System.out.println("Phuong trinh co nghiem dung voi moi x");
			} else {
				System.out.println("Phuong trinh vo nghiem");
			}
		}
	}

	static int maxValue(int[] a, int n) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		System.out.println("So lon nhat trong mang la: " + max);
		return max;
	}

	static void sortArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(a[i], a[j]);
				}
			}
		}
	}

	static int[] chen(int[] a, int x) {
		int max = maxValue(a, x);
		int flag = 0;
		int[] temp = new int[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			if (x < max) {
				if (x < a[i]) {
					temp[i] = x;
					flag = 1;
				} else {
					temp[i] = a[i];
				}
			}
		}
		if (flag == 1) {
			temp[a.length] = max;
		} else {
			temp[a.length] = x;
		}
		return temp;
	}

	static int count(int[] a, int x) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				count++;
			}
		}
		return count;
	}

	static int[] xoaPhanTu(int[] a, int x) {
		int count = count(a, x);
		int[] temp = new int[a.length - count];
		for (int i = 0, j = 0; i < a.length; i++) {
			if (a[i] != x) {
				temp[j++] = a[i];
			}
		}
		return temp;
	}

	public static void nhapMang2Chieu(int[][] a, int x, int y) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.println("Nhap a[" + i + "][" + j + "] ");
				a[i][j] = input.nextInt();
			}
		}
	}

	public static void xuatMang2Chieu(int[][] a, int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.println("a[" + i + "][" + j + "] " + a[i][j]);
			}
		}
	}

	public static int maxMang2Chieu(int[][] a, int x, int y) {
		int max = a[0][0];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
				}
			}
		}
		System.out.println("Gia tri lon nhat: " + max);
		return max;
	}

	public static int minMang2Chieu(int[][] a, int x, int y) {
		int min = a[0][0];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (a[i][j] < min) {
					min = a[i][j];
				}
			}
		}
		System.out.println("Gia tri nho nhat: " + min);
		return min;
	}

	public static int tongDuongCheoChinh(int[][] a, int x, int y) {
		int sum = 0;
		for (int i = 0; i < x; i++) {
			sum += a[i][i];
		}
		return sum;
	}

	public static int tongDuongCheoPhu(int[][] a, int x, int y) {
		int sum = 0;
		for (int i = 0; i < x; i++) {
			sum += a[i][x - 1 - i];
		}
		return sum;
	}

	public static void sortMang2Chieu(int[][] a, int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x - j - 1; k++) {
					if (a[i][k] > a[i][k + 1]) {
						int temp = a[i][k];
						a[i][k] = a[i][k + 1];
						a[i][k + 1] = temp;
					}
				}
			}
		}
	}
}
