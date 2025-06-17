import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue; 

public class Spotipai {
    private List<Song> daftarLagu; // pustaka lagu yang tersedia
    private Queue<Song> queue;     // Antrian lagu
    private Song nowPlaying;       // Lagu yang sedang diputar

    public Spotipai() {
        this.daftarLagu = new ArrayList<>();
        this.queue = new LinkedList<>();
        this.nowPlaying = null;
    }

    public static class Song {
        private String title;
        private String artist;
        private int duration; // in seconds

        public Song(String title, String artist, int duration) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public int getDuration() {
            return duration;
        }

        @Override
        public String toString() { 
            return String.format("'%s' oleh %s (%d detik)", title, artist, duration);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Song)) return false;
            Song song = (Song) o;
            return duration == song.duration &&
                Objects.equals(title, song.title) &&
                Objects.equals(artist, song.artist);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, artist, duration);
        }
    }

    /**
     * Menambahkan lagu ke dalam library.
     * Jika lagu yang ditambahkan tidak valid (null), cetak "Masukan tidak valid."
     * Tambahkan lagu ke daftarLagu, lalu cetak pesan "Ditambahkan ke pustaka: [lagu]"
     */
    public void addSongToLibrary(Song song) {
        if (song == null) {
            System.out.println("Masukan tidak valid.");
            return;
        }
        daftarLagu.add(song);
        System.out.println("Ditambahkan ke pustaka: " + song);
    }

    /**
     * Memainkan atau mengantri lagu.
     * Jika input tidak valid (null), cetak "Masukan tidak valid."
     * Jika lagu tidak ada di daftar lagu, cetak "[lagu] tidak ditemukan di pustaka. Tolong tambahkan dulu ke pustaka."
     * Jika berhasil, tambahkan lagu ke queue dan cetak "Ditambahkan ke antrian: [lagu]".
     * Putar lagu selanjutnya jika tidak ada lagu yang sedang dimainkan.
     */
    public void playOrQueueSong(Song song) {
        if (song == null) {
            System.out.println("Masukan tidak valid.");
            return;
        }
        if (!daftarLagu.contains(song)) {
            System.out.println(song + " tidak ditemukan di pustaka. Tolong tambahkan dulu ke pustaka.");
            return;
        }
        queue.add(song);
        System.out.println("Ditambahkan ke antrian: " + song);
        
        if (nowPlaying == null) {
            playNext();
        }
    }

    /**
     * Memainkan lagu selanjutnya dari antrian.
     * Mainkan lagu dari antrian jika ada, lalu cetak "Sekarang memutar: [lagu]".
     * JIka antrian ada, dan sedang ada lagu yang sedang dimainkan, cetak "Selesai memutar: [lagu]. Antrian kosong. Pemutaran dihentikan.",
     * jika antrian kosong dan tidak ada lagu yang sedang dimainkan, cetak "Antrian kosong. Tidak ada yang diputar."
     * 
     */
    public void playNext() {
        if (queue.isEmpty()) {
            if (nowPlaying == null) {
                System.out.println("Antrian kosong. Tidak ada yang diputar.");
            } else {
                System.out.println("Selesai memutar: " + nowPlaying + ". Antrian kosong. Pemutaran dihentikan.");
                nowPlaying = null;
            }
            return;
        }

        nowPlaying = queue.poll();
        System.out.println("Sekarang memutar: " + nowPlaying);
    }

    /**
     * Menunjukkan isi antrian lagu.
     * Jika antrian kosong, cetak "Antrian kosong."
     * Jika ada lagu dalam antrian, cetak daftar lagu dan pisahkan antara satu lagu dengan yang lainnya pada baris berbeda. tulis dengan format:
     * 1. [lagu]
     * 2. [lagu]
     * dst.
     * 
     */
    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }

        int index = 1;
        for (Song song : queue) {
            System.out.println(index + ". " + song);
            index++;
        }
    }

    /**
     * Hapus lagu tertentu dari antrian.
     * Jika input tidak valid (null), cetak "Masukan tidak valid."
     * Jika lagu tidak ada di antrian, cetak "[lagu] tidak ditemukan di antrian."
     * Jika berhasil, hapus lagu dari antrian dan cetak "Menghapus [lagu] dari antrian".
     */
    public void removeFromQueue(Song song) {
        if (song == null) {
            System.out.println("Masukan tidak valid.");
            return;
        }
        else if (!queue.contains(song)) {
            System.out.println(song + " tidak ditemukan di antrian.");
            return;
        }
        queue.remove(song);
        System.out.println("Menghapus " + song + " dari antrian.");
    }

    /**
     * Memberhentikan lagu yang sedang dimainkan.
     * Jika ada lagu yang sedang dimainkan, cetak "Berhenti memutar: [lagu]".
     * Jika tidak ada lagu yang sedang dimainkan, cetak "Tidak ada lagu yang sedang diputar."
     */
    public void stopSong() {
        if (nowPlaying == null) {
            System.out.println("Tidak ada lagu yang sedang diputar.");
            return;
        }
        System.out.println("Berhenti memutar: " + nowPlaying);
        nowPlaying = null;
    }

    /**
     * Menunjukkan lagu yang sedang diputar.
     * Jika ada lagu yang sedang diputar, cetak "Sedang memutar: [lagu]".
     * Jika tidak ada lagu yang sedang diputar, cetak "Tidak ada lagu yang sedang diputar."
     */
    public void showNowPlaying() {
        if (nowPlaying == null) {
            System.out.println("Tidak ada lagu yang sedang diputar.");
        } else {
            System.out.println("Sedang memutar: " + nowPlaying);
        }
    }

    /**
     * Menampilkan semua lagu yang ada di pustaka.
     * Jika kosong, cetak "Tidak ada lagu di dalam pustaka."
     * Jika ada, cetak daftar lagu dengan format:
     * "- [lagu]"
     * "- [lagu]"
     * dst.
     */
    public void showAllSongsInLibrary() {
        if (daftarLagu.isEmpty()) {
            System.out.println("Tidak ada lagu di dalam pustaka.");
            return;
        }

        for (Song song : daftarLagu) {
            System.out.println("- " + song);
        }
    }

    /**
     * Hapus sebuah lagu dari pustaka. Asumsikan bahwa pustaka lagu bersifat unik.
     * Jika input tidak valid (null), cetak "Masukan tidak valid."
     * Jika lagu tidak ada di pustaka, cetak "[lagu] tidak ditemukan di pustaka."
     * Jika berhasil, hapus lagu dari pustaka dan cetak "Menghapus [lagu] dari pustaka."
     * Jika lagu yang dihapus adalah lagu yang sedang diputar, hentikan pemutaran lagu tersebut dan cetak "[lagu] sedang diputar. Dihentikan."
     */
    public void removeSongFromLibrary(Song song) {
        if (song == null) {
            System.out.println("Masukan tidak valid.");
            return;
        }
        if (!daftarLagu.contains(song)) {
            System.out.println(song + " tidak ditemukan di pustaka.");
            return;
        }
        daftarLagu.remove(song);
        System.out.println("Menghapus " + song + " dari pustaka.");

        if (nowPlaying != null && nowPlaying.equals(song)) {
            stopSong();
            System.out.println(song + " sedang diputar. Dihentikan.");
        }
    }
}