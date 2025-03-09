/**
 * Blind.java
 * Sebuah kelas yang memodelkan satu stage dalam permainan Balala
 * 
 * @author 18223066 Nazwan
 */


public class Blind {
    // Deklarasi atribut
    private Kartu kartu1, kartu2, kartu3, kartu4, kartu5;
    private int targetValue;
    private int jokerType;

    /**
     * Konstruktor
     * 
     * @param kartu1-kartu5
     * @param jokerType,    tipe joker yang dimiliki
     * @param targetValue,  total nilai yang harus dicapai pada blind ini
     */
    public Blind(Kartu kartu1, Kartu kartu2, Kartu kartu3, Kartu kartu4, Kartu kartu5, int jokerType, int targetValue) {
        this.kartu1 = kartu1;
        this.kartu2 = kartu2;
        this.kartu3 = kartu3;
        this.kartu4 = kartu4;
        this.kartu5 = kartu5;
        this.jokerType = jokerType;
        this.targetValue = targetValue;
    }

    /**
     * Getter
     * 
     * @param n
     * @return kartu ke-n, bila angka tidak valid kembalikan kartu ke-5
     */
    public Kartu getKartu(int n) {
        if (n == 1) {
            return kartu1;
        } else if (n == 2) {
            return kartu2;
        } else if (n == 3) {
            return kartu3;
        } else if (n == 4) {
            return kartu4;
        } else {
            return kartu5;
        }
    }

    /**
     * Getter
     * 
     * @return jokerType
     */
    public int getJokerType() {
        return jokerType;
    }

    /**
     * Mengembalikan nilai multiplier dari tipe joker
     * Joker 1 -> 10x
     * Joker 2 -> 5x
     * Joker 3 -> 3x
     * Selainnya tidak ada multiplier
     * 
     * @return multiplier
     */
    public int getJokerMultiplier() {
        if (jokerType == 1) {
            return 10;
        } else if (jokerType == 2) {
            return 5;
        } else if (jokerType == 3) {
            return 3;
        } else {
            return 1;
        }
    }

    /**
     * Mengembalikan total nilai kartu yang dimiliki, termasuk penkalian multiplier
     * pada akhir penjumlahan
     * 
     * @return totalScore
     */
    public int calculateTotalScore() {
        int totalScore = 0;
        totalScore += kartu1.getKartuValue();
        totalScore += kartu2.getKartuValue();
        totalScore += kartu3.getKartuValue();
        totalScore += kartu4.getKartuValue();
        totalScore += kartu5.getKartuValue();
        totalScore *= getJokerMultiplier();
        return totalScore;
    }

    /**
     * Mengembalikan true bila skor total melebihi atau sama dengan target
     * 
     * @return isWin
     */
    public boolean isWin() {
        return calculateTotalScore() >= targetValue;
    }
}