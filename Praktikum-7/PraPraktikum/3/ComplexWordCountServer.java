import java.util.ArrayList;

public class ComplexWordCountServer {

    private int nWorkers;

    // masukkan arraylist of string dipastikan berupa alfabet lowercase saja
    private ArrayList<String> array;

    // hasil pada method countSpecialString akan disimpan pada res
    int[] res = new int[26];

    ComplexWordCountServer(int nWorkers, ArrayList<String> array) {
        this.nWorkers = nWorkers;
        this.array = array;
    }

    public void countSpecialString() throws InterruptedException {
        // calculateSum akan membuat thread untuk setiap string
        // setiap thread kemudian akan memanggil metode characterCountHelper
        // lalu hasil dari Array Mapping yang dikembalikan oleh metode characterCountHelper akan digunakan
        // untuk ditambahkan ke attribut res

        if (array == null || array.isEmpty() || nWorkers <= 0) {
            return;
        }

        int jumlahThreadAktual = Math.min(nWorkers, array.size());
        Thread[] threads = new Thread[jumlahThreadAktual];
        Object lock = new Object();
        
        for (int i = 0; i < jumlahThreadAktual; i++) {
            final int threadIndex = i;
            
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = threadIndex; j < array.size(); j += jumlahThreadAktual) {
                        int[] charCount = characterCountHelper(array.get(j));
                        
                        synchronized (lock) {
                            for (int k = 0; k < 26; k++) {
                                res[k] += charCount[k];
                            }
                        }
                    }
                }
            });
            
            threads[i] = thread;
            thread.start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected int[] characterCountHelper(String str) {
        // Menghitung berapa banyak occurence dari suatu karakter pada suatu string
        // lalu dipetakan pada suatu array of integer

        // HINT : untuk memetakan suatu karakter ke array of integer, anda bisa melakukan arr[c-'a']
        // sehingga apabila variable c merupakan karakter 'a', value dari c-'a' menjadi 0, begitupun
        // dengan karakter alfabet lainnya

        int[] charCount = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charCount[c - 'a']++;
            }
        }
        
        return charCount;
    }

    public String toString() {
        // menampilkan berapa banyak kata spesial "one", "two" dan "three"
        // format keluaran dari fungsi ini adalah "one : {one_occurence}, two : {two_occurence}, three : {three_occurence}"
        // lalu diakhiri dengan newline
    int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        
        int[] charCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            charCounts[i] = res[i];
        }
        
        while (charCounts['o' - 'a'] >= 1 && charCounts['n' - 'a'] >= 1 && charCounts['e' - 'a'] >= 1) {
            oneCount++;
            charCounts['o' - 'a']--;
            charCounts['n' - 'a']--;
            charCounts['e' - 'a']--;
        }
        
        while (charCounts['t' - 'a'] >= 1 && charCounts['w' - 'a'] >= 1 && charCounts['o' - 'a'] >= 1) {
            twoCount++;
            charCounts['t' - 'a']--;
            charCounts['w' - 'a']--;
            charCounts['o' - 'a']--;
        }
        
        while (charCounts['t' - 'a'] >= 1 && charCounts['h' - 'a'] >= 1 && charCounts['r' - 'a'] >= 1 && 
            charCounts['e' - 'a'] >= 2) {
            threeCount++;
            charCounts['t' - 'a']--;
            charCounts['h' - 'a']--;
            charCounts['r' - 'a']--;
            charCounts['e' - 'a'] -= 2; 
        }
        
        return "one : " + oneCount + ", two : " + twoCount + ", three : " + threeCount + "\n";
    }
}