
package sachtrinhthamtieuthuyet;

import java.util.ArrayList;

public class SachTrinhThamTieuthuyet {

    public static void main(String[] args) {
        
        ArrayList<Sach> arrSach = new ArrayList<Sach>();
        TieuThuyet s1 = new TieuThuyet();
        TieuThuyet s2 = new TieuThuyet();
        SachTrinhTham tt1= new SachTrinhTham();
        s1.nhapTieuThuyet();
        s2.nhapTieuThuyet();
        tt1.nhapSachTrinhTham();
        
        arrSach.add(s1);
        arrSach.add(tt1);
        arrSach.add(s2);
        double tong1=0,tong2=0;
        
        for(Sach i:arrSach) {
           if(i instanceof TieuThuyet)
               tong1+=i.thanhTien();
           else
                tong2+=i.thanhTien();
        }
        System.out.println("Tổng tiền sách Tiểu thuyết ="+tong1);
        System.out.println("Tổng tiền sách Trinh thám ="+tong2);
    }
    
}
