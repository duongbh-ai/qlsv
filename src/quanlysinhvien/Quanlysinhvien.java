package quanlysinhvien;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Quanlysinhvien {
    
    
    
    ArrayList<SinhVien> arrSV = new ArrayList<>();


    public void SapxepSinhVien(ArrayList<SinhVien> arrSV) {
        for (int i = 0; i < arrSV.size() - 1; i++) {
            for (int j = i + 1; j < arrSV.size(); j++) {
              
                if (arrSV.get(i).getPoint() > arrSV.get(j).getPoint()) {
          
                    SinhVien temp = arrSV.get(i);
                    arrSV.set(i, arrSV.get(j));
                    arrSV.set(j, temp);
                }
            }
        }
        System.out.println("Danh sách sinh viên sau khi sắp xếp theo điểm:");
        for (SinhVien sv : arrSV) {
            sv.outputSV();
            System.out.println("Xếp hạng: " + getRank(sv.getPoint()));
        }
    }


    public String getRank(float point) {
        if (point < 5.0) {
            return "Fail";
        } else if (point < 6.5) {
            return "Medium";
        } else if (point < 7.5) {
            return "Good";
        } else if (point < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }
    
    public void showListSV(ArrayList<SinhVien> arr){
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).outputSV();
        }
    }
    
    public void inputListSV(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("Moi ban nhap thong tin cho Sv thu"+(i + 1));
            SinhVien sv = new SinhVien();
            sv.inputSV();
            arrSV.add(sv);
        }
        
    }
    
    public void searchSV(ArrayList<SinhVien> arr,String name){
        int j=0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().lastIndexOf(name)>=0) {
                arr.get(i).outputSV();
                j=1;
            }
        }
        if(j==0){
            System.out.println("khong tim thay sinh vien");       
        }
    }
public void Sua(String ID) {
    
    for (SinhVien sv : arrSV) {
        if (sv.getID().equals(ID)) {
          
            System.out.println("Nhập lại thông tin cho sinh viên có ID: " + ID);
            sv.inputSV();  
            System.out.println("Đã cập nhật thông tin sinh viên thành công!");
            return;
        }
    }
    
    System.out.println("Không tìm thấy sinh viên với ID: " + ID);
}
public void Xoa(String ID) {
 
    for (int i = 0; i < arrSV.size(); i++) {
        if (arrSV.get(i).getID().equals(ID)) {

            arrSV.get(i).outputSV();

           
            Scanner input = new Scanner(System.in);
            System.out.println("Bạn có chắc chắn muốn xóa sinh viên này? (y/n)");
            String confirm = input.nextLine();

            if (confirm.equalsIgnoreCase("y")) {
                arrSV.remove(i);  // Xóa sinh viên khỏi danh sách
                System.out.println("Đã xóa sinh viên có ID: " + ID);
            } else {
                System.out.println("Hủy xóa.");
            }
            return;  
        }
    }

    System.out.println("Không tìm thấy sinh viên với ID: " + ID);
}




public static void main(String[] args) {
    quanlysinhvien.Quanlysinhvien qlsv = new Quanlysinhvien();
    Scanner input = new Scanner(System.in);
    int luachon, i = 0;
    while (i == 0) {
        SinhVien sv = new SinhVien();
        System.out.println("MENU");
        System.out.println("Lua chon");
        System.out.println("1. Nhap danh sach sinh vien");
        System.out.println("2. Hien thi thong tin sinh vien");
        System.out.println("3. Sap xep sinh vien");
        System.out.println("4. Tim kiem sinh vien");
        System.out.println("5. Sua thong tin sinh vien");
        System.out.println("6. Xoa sinh vien");
        System.out.println("7. Thoat");
        
try {
                System.out.print("Nhap lua chon cua ban: ");
                luachon = input.nextInt();
                input.nextLine();                  
                if (luachon < 1 || luachon > 7) {
                    System.out.println("Thong tin nhap vao khong hop le ! Vui long chon cac so tu 1 den 7 de su dung cac chuc nang");
                    continue;  
                }
            } catch (InputMismatchException e) {
                System.out.println("Thong tin nhap vao khong hop le! Vui long nhap mot so nguyen tu 1 den 7.");
                input.nextLine();  
                continue;  
            }


        luachon = input.nextInt();
        switch (luachon) {
            case 1:
                input.nextLine(); 
                System.out.println("Ban hay nhap so sinh vien co trong danh sach");
                int n = input.nextInt();
                qlsv.inputListSV(n);
                break;
            case 2:
                input.nextLine(); 
                qlsv.showListSV(qlsv.arrSV);
                break;
            case 3:
                input.nextLine(); 
                qlsv.SapxepSinhVien(qlsv.arrSV);
                break;
            case 4:
                input.nextLine();  
                System.out.println("Moi ban nhap ten sinh vien can tim");
                String a = input.nextLine();
                qlsv.searchSV(qlsv.arrSV, a);
                break;
            case 5:
                input.nextLine();  
                System.out.println("Nhap ID sinh vien can sua:");
                String id = input.nextLine();
                qlsv.Sua(id);
                break;
            case 6:
                input.nextLine();  
                System.out.println("Nhap ID sinh vien can xoa:");
                String idToDelete = input.nextLine();
                qlsv.Xoa(idToDelete);
                break;
            case 7:
                i = 1;
                System.out.println("Xin chao!");
                break;
            default:
                System.out.println("Thong tin nhap vao khong hop le ! vui long chon cac so tu 1 den 7 de su dung cac chuc nang");
                break;
        }
    }
}

}
