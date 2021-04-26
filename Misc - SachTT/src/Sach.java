package sachtrinhthamtieuthuyet;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private double donGia; 
    private int soLuong;
    public Sach()
    {
        this.maSach= "";
        this.tenSach = "";
        this.donGia=0.0;
        this.soLuong =0;        
    }
    public void nhapSach()
    {
        //String tam;
        Scanner sc= new Scanner(System.in);
        System.out.print("Ma sách");
        this.maSach = sc.nextLine();
        System.out.print("Tên sách");
        this.tenSach = sc.nextLine();
        //tam=sc.nextLine();
        System.out.print("đơn giá:");
        this.donGia = sc.nextDouble();
        System.out.print("Số lượng:");
        this.soLuong = sc.nextInt();
    }
    public double thanhTien()
    {
        return this.soLuong * this.donGia;     
    }
    
}
