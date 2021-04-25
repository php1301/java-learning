
package sachtrinhthamtieuthuyet;

import java.util.Scanner;

public class SachTrinhTham extends Sach{
    private double thue;
    public SachTrinhTham()
    {
        super();
        this.thue=0;
    }
    public void nhapSachTrinhTham()
    {
        super.nhapSach();
        Scanner  sc = new Scanner(System.in);
        System.out.print("Nhap thuế:");
        this.thue=sc.nextDouble();
    }
    public double thanhTien()
    {
        return super.thanhTien()+this.thue;
    }
}
