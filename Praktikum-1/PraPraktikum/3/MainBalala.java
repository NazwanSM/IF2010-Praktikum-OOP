import java.util.Scanner;

public class MainBalala {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] suit = new String[5];
        String[] rank = new String[5];
        int[] multiplier = new int[5];

        for (int i = 0; i < 5; i++) {
            suit[i] = scan.next();
            rank[i] = scan.next();
            multiplier[i] = scan.nextInt();
        }

        Kartu kartu1 = new Kartu(suit[0], rank[0], multiplier[0]);
        Kartu kartu2 = new Kartu(suit[1], rank[1], multiplier[1]);
        Kartu kartu3 = new Kartu(suit[2], rank[2], multiplier[2]);
        Kartu kartu4 = new Kartu(suit[3], rank[3], multiplier[3]);
        Kartu kartu5 = new Kartu(suit[4], rank[4], multiplier[4]);
        
        int jokerType = scan.nextInt();
        int targetValue = scan.nextInt();
        Blind blind = new Blind(kartu1, kartu2, kartu3, kartu4, kartu5, jokerType, targetValue);

        for (int i = 1; i <= 5; i++) {
            Kartu kartu = blind.getKartu(i);
            if (i == 1) {
                System.out.print("Kartu pertama punya suit " + kartu.getSuit() + " dengan rank " + kartu.getRank() + " dan multiplier " + kartu.getMultiplier() + "\n");
            } else if (i == 2) {
                System.out.print("Kartu kedua punya suit " + kartu.getSuit() + " dengan rank " + kartu.getRank() + " dan multiplier " + kartu.getMultiplier() + "\n");
            } else if (i == 3) {
                System.out.print("Kartu ketiga punya suit " + kartu.getSuit() + " dengan rank " + kartu.getRank() + " dan multiplier " + kartu.getMultiplier() + "\n");
            } else if (i == 4) {
                System.out.print("Kartu keempat punya suit " + kartu.getSuit() + " dengan rank " + kartu.getRank() + " dan multiplier " + kartu.getMultiplier() + "\n");
            } else {
                System.out.print("Kartu kelima punya suit " + kartu.getSuit() + " dengan rank " + kartu.getRank() + " dan multiplier " + kartu.getMultiplier() + "\n");
            }
        }

        System.out.print("Skor akhir : " + blind.calculateTotalScore() + "\n");
        if (blind.isWin()) {
            System.out.print("MENANG!\n");
        } else {
            System.out.print("KALAH!\n");
        }

        scan.close();
    }
}