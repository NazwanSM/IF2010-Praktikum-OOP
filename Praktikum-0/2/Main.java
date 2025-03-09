import java.util.Scanner;
/**
 * Main.java
 * 
 * @author 18223066 Nazwan Siddqi Muttaqin
 */

public class Main {
    /**
     * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
     * 
     * @param cards
     * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
     */
    public static boolean isRoyal(String[] cards) {
        boolean royal = false;
        int benar = 0;
        char paket = cards[0].charAt(0); 
        for (int i = 0; i < cards.length; i++){
            if ((cards[i].charAt(1) == 'T' || cards[i].charAt(1) == 'J' || cards[i].charAt(1) == 'Q' || cards[i].charAt(1) == 'K' || cards[i].charAt(1) == 'A') && cards[i].charAt(0) == paket){
                benar += 1;
            }
        }

        if (benar == 5){
            royal = true;
        }
        return royal;
    }

    /**
     * Mengecek apabila kartu dapat membentuk Full House
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Full House, false sebaliknya
     */
    public static boolean isFullHouse(String[] cards) {
        boolean fullHouse = false;
        int c1 = 0;
        int c2 = 0;
        char angka1 = cards[0].charAt(1);
        char angka2 = cards[1].charAt(1);
        

        for (int i = 1; i < cards.length; i++){
            if (cards[i].charAt(1) != angka1){
                angka2 = cards[i].charAt(1);
                break;
            }
        }

        for (int i = 0; i < cards.length; i++){
            if (cards[i].charAt(1) == angka1){
                c1 += 1;
            }
            else if(cards[i].charAt(1) == angka2){
                c2 += 1;
            }
            else {
                break;
            }
        }

        if (c1 == 2 && c2 == 3) {
            fullHouse = true;
        } 
        else if (c1 == 3 && c2 == 2){
            fullHouse = true;
        }

        return fullHouse;
    }

    /**
     * Mengecek apabila kartu dapat membentuk Flush
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Flush, false sebaliknya
     */
    public static boolean isFlush(String[] cards) {
        boolean flush = false;
        int benar = 0;
        char paket = cards[0].charAt(0);

        for (int i = 0; i < cards.length; i++){
            if (cards[i].charAt(0) == paket){
                benar += 1;
            }
        } 
        if (benar == 5){
            flush = true;
        }
        return flush;
    }

    /**
     * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
     * - Royal Flush: 3
     * - Full House: 2
     * - Flush: 1
     * - High Card: 0
     * 
     * @param cards
     * @return rangking
     */
    public static int getSetRanking(String[] cards) {
        int rank = 0;
        if (isRoyal(cards)){
            rank = 3;
        }
        else if (isFullHouse(cards)){
            rank = 2;
        }
        else if (isFlush(cards)){
            rank = 1;
        }
        else {
            rank = 0;
        }

        return rank;
    }

    public static void main(String[] args) {
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];

        /* YOUR CODE HERE */
        Scanner scan = new Scanner(System.in);
        String inp;

        for (int i = 0; i < 5; i++){
            inp = scan.next();
            cardsTuanBil[i] = inp;
        }

        for (int i = 0; i < 5; i++){
            inp = scan.next();
            cardsTuanMask[i] = inp;
        }
        int scoreBil = getSetRanking(cardsTuanBil);
        int scoreMask = getSetRanking(cardsTuanMask);
        String pemenang;
        int rankPemenang = scoreBil;

        if(scoreBil > scoreMask){
            pemenang = "Tuan Bil";
            System.out.print(pemenang + "\n");
            rankPemenang = scoreBil;
        }
        else if (scoreBil < scoreMask){
            pemenang = "Tuan Mask";
            System.out.print(pemenang + "\n");
            rankPemenang = scoreMask;
        }
        else {
            System.out.print("Seri\n");
        }

        System.out.print(rankPemenang + "\n");
        scan.close();
    }
}