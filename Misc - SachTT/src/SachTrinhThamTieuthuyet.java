
package sachtrinhthamtieuthuyet;

import java.util.ArrayList;

public class SachTrinhThamTieuthuyet {

    public static void main(String[] args) {
        
        ArrayList<Sach> arrSach = new ArrayList<Sach>();
        TieuThuyet s1 = new TieuThuyet();
        TieuThuyet s2 = new TieuThuyet();
        SachTrinhTham tt1= new SachTrinhTham();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<5 ;i++) {
        	int option = sc.nextInt();
        	if(option == 1) {
        		TieuThuyet tt = new TieuThuyet();
        		tt.nhapTieuThuyet();
        		arrSach.add(tt);
        	}
        	if(option == 2) {
        		SachTrinhTham stt = new SachTrinhTham();
        		stt.nhapSachTrinhTham();
        		arrSach.add(stt);
        	}
        }
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
