# Repositori Praktikum IF2010 - Pemrograman Berorientasi Objek

Repositori ini berisi kumpulan source code, pra-praktikum, dan kuis untuk mata kuliah IF2010 - Pemrograman Berorientasi Objek (OOP) di Institut Teknologi Bandung.

### Identitas
- **Nama:** Nazwan Siddqi Muttaqin
- **NIM:** 18223066
- **Program Studi:** Sistem dan Teknologi Informasi, Institut Teknologi Bandung

## Deskripsi Repositori

Tujuan dari repositori ini adalah untuk mendokumentasikan dan mengarsipkan seluruh tugas pemrograman yang telah diselesaikan selama satu semester. Setiap modul praktikum mencakup topik-topik fundamental hingga lanjutan dalam paradigma pemrograman berorientasi objek menggunakan bahasa Java.

## Struktur Repositori

Di dalam setiap folder `Praktikum-X`, umumnya terdapat:
- **`PraPraktikum/`**: Berisi soal-soal dan kode sumber untuk tugas pra-praktikum.
- **`Praktikum/` atau `PascaPraktikum/`**: Berisi soal-soal dan kode sumber untuk tugas praktikum utama atau pasca-praktikum.
- **`Latihan/`**: (Jika ada) Berisi kode latihan tambahan.
- **`*.java`**: File kode sumber solusi.
- **`*.pdf`**: File PDF yang berisi deskripsi soal dan laporan penilaian (umpan balik).
- **`*.zip`**: Berkas yang dikumpulkan untuk penilaian.

## Rangkuman Modul Praktikum

Berikut adalah ringkasan topik dan materi yang dibahas dalam setiap modul:

| Modul | Topik Utama | Deskripsi Singkat |
| :--- | :--- | :--- |
| **Praktikum 0** | **Pengenalan Java** | Pengenalan konsep dasar Java, termasuk I/O, variabel, dan struktur kontrol. Soal yang dibahas antara lain "Hello World", permainan kartu "Balala", dan kalkulasi skor sederhana. |
| **Praktikum 1** | **Class, Object, dan Inheritance** | Implementasi konsep dasar OOP seperti Class, Object, Atribut, Method, dan Inheritance. Proyek mencakup studi kasus seperti "Cimol Bojot", "Jualan Handphone di BEC", dan implementasi Adapter Pattern pada kasus "Kabur Aja Dulu". |
| **Praktikum 2** | **Interface dan Polymorphism** | Penerapan konsep Interface dan Polymorphism untuk mencapai abstraksi dan fleksibilitas kode. Studi kasus meliputi "Monster Hunter Wilds", penanganan *legacy code* dengan format XML dan JSON, dan manajemen perangkat komputer. |
| **Praktikum 3** | **Wrapper Class dan String** | Penggunaan kelas pembungkus (wrapper class) untuk tipe data primitif dan manipulasi String. Soal yang dikerjakan adalah "Magic Calculator", "MaskPII" untuk menyamarkan data sensitif, dan "WordProcessor". |
| **Praktikum 4 (Kuis 1)** | **Pola Desain: Command & Observer** | Implementasi pola desain (Design Patterns). Materi mencakup Command Pattern pada kasus "Tung Tung Tung Sahur" dan Observer Pattern pada simulasi "Social Media". Terdapat pula soal pewarisan lanjutan pada kasus "Peak Zero". |
| **Praktikum 5** | **Generics** | Penerapan Generics untuk menciptakan komponen yang tipe-aman dan dapat digunakan kembali. Implementasi meliputi struktur data seperti "Deque", "KeyValuePairGeneric", dan "HashMap". |
| **Praktikum 6** | **Exception Handling** | Pengelolaan dan penanganan error menggunakan `try-catch-finally` dan `custom exception`. Studi kasus meliputi validasi "HTTP Request", simulasi robot dengan perintah terbatas, dan aplikasi dompet digital "OwO". |
| **Praktikum 7**| **Concurrency** | Pengenalan dan implementasi pemrograman konkuren menggunakan Threads. Tugas meliputi pembuatan "Delayed Output", kalkulasi jumlah array secara paralel, dan simulasi kas guild dengan transaksi konkuren. |
| **Praktikum 8** | **Nested Class dan Collections** | Penggunaan `nested class` dan Java Collections Framework (`Map`, `List`, `Set`, `Stack`). Implementasi mencakup aplikasi media sosial "Techbrosgram", simulasi toko "ART PRINT" menggunakan Stack, dan manajemen "Konvoi Persil". |
| **Praktikum 9 (Kuis 2)** | **Aplikasi Collections Lanjutan** | Penerapan lanjutan dari Java Collections. Proyek yang dikerjakan adalah "JejakDigital" (menggunakan `LinkedList`), pemutar media "Spotipai" (menggunakan `Queue` dan `List`), dan "mpv" (menggunakan `Map` dan `Set`). |

## Teknologi yang Digunakan
- **Bahasa:** Java (versi 8, sesuai spesifikasi pada soal-soal praktikum)
- **Tools:** Standard Java Development Kit (JDK)
- **Library:** Java Standard Library (java.util, java.io, java.util.concurrent, dll.)

## Cara Menjalankan Kode
Sebagian besar program dapat dijalankan langsung dari command line. Pastikan Anda telah menginstal JDK.

1.  **Navigasi ke Direktori Soal**
    ```bash
    cd Praktikum-X/nama_folder_soal
    ```

2.  **Kompilasi File Java**
    Untuk mengkompilasi semua file `.java` di direktori saat ini:
    ```bash
    javac *.java
    ```

3.  **Eksekusi Program**
    Jalankan file yang berisi `main method`:
    ```bash
    java NamaFileMain
    ```
    Sesuaikan `NamaFileMain` dengan nama kelas utama pada soal.

---
**Catatan:** Repositori ini dibuat untuk tujuan dokumentasi dan arsip akademis. Solusi yang ada merefleksikan pemahaman pada saat pengerjaan dan mungkin bukan merupakan solusi yang paling optimal. Spesifikasi soal dapat berbeda dari tahun ke tahun.
