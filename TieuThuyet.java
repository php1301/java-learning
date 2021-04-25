
package sachtrinhthamtieuthuyet;

import java.util.Scanner;

public class TieuThuyet extends Sach{
    private int tinhTrang; // =1 mới,=0 cũ
    public TieuThuyet()
    {
        super();
        this.tinhTrang =0;
    }
    public void nhapTieuThuyet()
    {
        super.nhapSach();
        Scanner sc = new Scanner(System.in);
        System.out.print("Tình trạng:");
        this.tinhTrang = sc.nextInt();
    }
    public double thanhTien()
    {
        if(this.tinhTrang == 0)
            return super.thanhTien()*0.2;
        else 
            return super.thanhTien();
    }
}
