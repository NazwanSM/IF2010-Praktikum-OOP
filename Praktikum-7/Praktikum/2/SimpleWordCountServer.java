public class SimpleWordCountServer {
    private int nWorkers;

    /**
     * Constructor untuk simple word count server
     *
     * @param nWorkers jumlah maximum threads yang tersedia pada server a.k.a thread
     * pool
     */
    SimpleWordCountServer(int nWorkers) {
        this.nWorkers = nWorkers;
    }

    /**
     * Ikuti instruksi yang ada di deskripsi soal ya!
     * 1. processRequests akan membuat threads dan memetakan elemen-elemen requests
     * kepada threads tersebut
     * 2. setiap thread kemudian memanggil method countWords
     * 3. main thread (thread yang invoked method ini) akan menunggu semua thread
     * selesai
     * 4. terakhir main thread akan mengembalikan hasil penghitungan kata untuk
     * setiap elemen requests
     *
     * @param requests array kalimat yang dikirimkan client
     */
    public Integer[] processRequests(String[] requests) throws InterruptedException {
        int nRequests = requests.length;
        final Integer[] results = new Integer[nRequests];
        Thread[] threads = new Thread[this.nWorkers];

        // 1. Membuat dan memetakan pekerjaan untuk setiap thread
        for (int i = 0; i < this.nWorkers; i++) {
            final int workerId = i;
            
            // Menggunakan deklarasi in-line sesuai instruksi
            threads[workerId] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Setiap thread memeriksa semua request dan mengambil yang menjadi jatahnya
                    for (int j = 0; j < nRequests; j++) {
                        if (j % nWorkers == workerId) {
                            // 2. Memanggil method countWords
                            results[j] = countWords(requests[j]);
                        }
                    }
                }
            });
            threads[workerId].start(); // Jalankan thread
        }

        // 3. Main thread menunggu semua worker thread selesai
        for (int i = 0; i < this.nWorkers; i++) {
            threads[i].join();
        }

        // 4. Mengembalikan hasil
        return results;
    }

    /**
     * countWords adalah metode yang mengembalikkan jumlah kata dalam suatu kalimat
     * HINT : beberapa fungsi yang berguna :
     * - trim() : menghilangkan trailing / leading white space
     * - isWhiteSpace() : cek apakah suatu karakter merupakan white space (tab,
     * space atau newline)
     * - isEmpty() : cek apakah suatu string kosong ("") atau tidak
     * seluruh fungsi diatas dapat dipakai dengan namaVariabelString.namaFungsi()
     * misalnya :
     * String s1 = "tomoro"
     * s1.isEmpty() -> akan menghasilkan nilai false
     * - charAt(i) : memberikan karakter pada indeks i.
     * Cara pemakaiannya string.charAt(i) dengan i sebagai indeks.
     *
     * HINT 2 : Coba iterasi perkarakter di string kalian dan gunakan whitespace
     * sebagai patokan akhir kalimat :D
     *
     * @param request kalimat yang dikirimkan client
     */
    protected int countWords(String request) {
        if (request == null || request.isEmpty()) {
            return 0;
        }

        String trimmedRequest = request.trim();
        if (trimmedRequest.isEmpty()) {
            return 0;
        }

        int wordCount = 1;
        for (int i = 1; i < trimmedRequest.length(); i++) {
            // Cek jika karakter saat ini adalah spasi dan karakter sebelumnya bukan spasi
            if (Character.isWhitespace(trimmedRequest.charAt(i)) && !Character.isWhitespace(trimmedRequest.charAt(i-1))) {
                wordCount++;
            }
        }
        return wordCount;
    }
}