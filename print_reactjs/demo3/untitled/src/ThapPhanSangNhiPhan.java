public class ThapPhanSangNhiPhan {
    public void chuyenDoiNhiPhan(int num){
        int nhiPhan[] = new int[8];
        int index = 0;
        while(num > 0){
            nhiPhan[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(nhiPhan[i]);
        }
    }
    public static void main(String a[]) {
        ThapPhanSangNhiPhan obj =new ThapPhanSangNhiPhan();
        System.out.println("Thập phân sang nhị phân: ");
        obj.chuyenDoiNhiPhan(100);
    }
}
