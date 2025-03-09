import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        String namaMenu1 = scan.next();
        int harga1 = scan.nextInt();
        int stok1 = scan.nextInt();
        CimolBojot cimolBojot1 = new CimolBojot(namaMenu1, harga1, stok1);

        String namaMenu2 = scan.next();
        int harga2 = scan.nextInt();
        int stok2 = scan.nextInt();
        CimolBojot cimolBojot2 = new CimolBojot(namaMenu2, harga2, stok2);

        String namaMenu3 = scan.next();
        int harga3 = scan.nextInt();
        int stok3 = scan.nextInt();
        CimolBojot cimolBojot3 = new CimolBojot(namaMenu3, harga3, stok3);
        
        int kas = scan.nextInt();
        Toko toko = new Toko(kas);
        toko.addCimolBojot(cimolBojot1);
        toko.addCimolBojot(cimolBojot2);
        toko.addCimolBojot(cimolBojot3);

        String namaMenu = scan.next();
        int quantity = scan.nextInt();
        System.out.print(toko.sellCimolBojot(namaMenu, quantity) + "\n");
        System.out.print("Kas kasir sekarang: " + toko.getKas() + "\n");

        scan.close();
    }
}