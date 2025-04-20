public class Tester {
    public static void main(String[] args) {
        Channel TuanBinatang = new Channel("TuanBinatang");
        Channel SapiqBasudara = new Channel("SapiqBasudara");
        Blogger NajipCerita = new Blogger("NajipCerita");
        Blogger DanvilleNews = new Blogger("DanvilleNews");


        User user1 = new User("User1");
        user1.subscribeTo(TuanBinatang);
        user1.subscribeTo(DanvilleNews);

        User user2 = new User("User2");
        user2.subscribeTo(TuanBinatang);
        user2.subscribeTo(SapiqBasudara);
        user2.subscribeTo(DanvilleNews);

        User user3 = new User("User3");
        user3.subscribeTo(NajipCerita);
        user3.subscribeTo(DanvilleNews);
        
        User user4 = new User("User4");
        user4.subscribeTo(DanvilleNews);

        User user5 = new User("User5");
        user5.subscribeTo(TuanBinatang);
        user5.subscribeTo(SapiqBasudara);
        user5.subscribeTo(NajipCerita);
        user5.subscribeTo(DanvilleNews);

        // Tes lihat subscriber
        Subscriber[] subscriberDanvilleNews = DanvilleNews.getSubscribers();
        for (int i=0; i<DanvilleNews.getSubscriberCount(); i++) {
            System.out.println(subscriberDanvilleNews[i].getName());
        }

        // Tes posting
        DanvilleNews.post(new Blog("Purry ingin bercocok tanam!", "WOWWWWW!!!"));
        TuanBinatang.post(new Video("1000 singa Vs 1000 kura-kura siapa yang akan menang?!", "videogacor.mp4", 283));
        // Tes posting gagal
        TuanBinatang.post(new Blog("Damn salah konten...", "harusnya ga masuk"));

        // Tes cek notif
        String[] notificaitonUser1 = user1.getNotifications();
        for (int i=0; i<user1.getNotificationCount(); i++) {
            System.out.println(notificaitonUser1[i]);
        }

        String[] notificaitonUser4 = user4.getNotifications();
        for (int i=0; i<user4.getNotificationCount(); i++) {
            System.out.println(notificaitonUser4[i]);
        }
        /* OUTPUT YANG DIHARAPKAN 
        
        User1
        User2
        User3
        User4
        User5
        Blog DanvilleNews telah mengunggah blog baru dengan judul Purry ingin bercocok tanam!
        Channel TuanBinatang telah mengunggah video baru dengan judul 1000 singa Vs 1000 kura-kura siapa yang akan menang?!
        Blog DanvilleNews telah mengunggah blog baru dengan judul Purry ingin bercocok tanam! 
        
        */

        /** Silahkan tambah test case kalian lainnya :D */
    }
}