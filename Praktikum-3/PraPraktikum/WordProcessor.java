import java.util.ArrayList;  

public class WordProcessor {
    // Atribut statik untuk menyimpan daftar kata
    private static ArrayList<String> words = new ArrayList<>();

    /**
     * Konstruktor
     * Inisialisasi daftar kata jika belum dibuat
     */
    public WordProcessor() {
        if (words == null) {
            words = new ArrayList<>();
        }
    }

    /**
     * Menambahkan kata ke dalam daftar kata
     * @param word
     */
    public static void addWord(String word) {
        words.add(word);
    }

    /**
     * Menghapus kata dari daftar kata
     * @param word
     */
    public static void removeWord(String word) {
        words.remove(word);
    }

    /**
     * Mencetak daftar kata dengan format:
     * 1. kata1
     * 2. kata2
     * ...
     */
    public static void printWords() {
        for (int i = 0; i < words.size(); i++) {
            System.out.println((i + 1) + ". " + words.get(i));
        }
    }

    /**
     * Mengembalikan kata terbalik pada index tertentu
     * Index dimulai dari 0
     * @param indeks
     * @return StringBuilder dengan kata terbalik
     */
    private static StringBuilder reverseWord(int indeks) {
        if (indeks < 0 || indeks >= words.size()) {
            return new StringBuilder(); // Mengembalikan string kosong jika indeks tidak valid
        }
        return new StringBuilder(words.get(indeks)).reverse();
    }
    
    /**
     * Mengembalikan apakah suatu kata pada index tertentu merupakan palindrome
     * Clue: gunakan method reverseWord
     * @param indeks
     * @return  true jika kata pada index tertentu merupakan palindrome
     *          false jika kata pada index tertentu bukan palindrome atau index tidak valid
     */
    public static boolean isPalindrome(int indeks) {
        if (indeks < 0 || indeks >= words.size()) {
            return false; // Indeks tidak valid
        }
        String original = words.get(indeks);
        String reversed = reverseWord(indeks).toString();
        return original.equals(reversed);
    }
}
