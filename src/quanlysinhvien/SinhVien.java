package quanlysinhvien;

import java.util.Scanner;
public class SinhVien {
    private String ID;
    private String name;
    private String birthday;
    private float point;
    
    public  void inputSV(){
     Scanner input = new Scanner(System.in);
     // dung input nhat cho bien cua tunf sinh vien mot
     System.out.println("moi ban nhap ID sv");
     ID = input.nextLine();
     
     System.out.println("moi ban nhap ten sv");
     name = input.nextLine();
     
     System.out.println("moi ban nhap ngay thang nam sinh cua sinh sinh vien");
     birthday = input.nextLine();
     
     System.out.println("moi ban nhap diem sinh vien");
     point = input.nextFloat();
     input.nextLine();
    }
    
   public void outputSV(){
    System.out.println("Ma so sinh vien: " + ID + 
                       ", Ten sinh vien: " + name + 
                       ", Ngay thang nam sinh: " + birthday + 
                       ", Diem: " + point);
    }
   
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

}
