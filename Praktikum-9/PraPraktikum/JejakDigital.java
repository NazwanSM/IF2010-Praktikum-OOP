import java.util.*;

public class JejakDigital<A> {
    private static class ItemJejakDigital<T> {
        private final int id;
        private final T activity;

        public ItemJejakDigital(int id, T activity) {
            this.id = id;
            this.activity = activity;
        }

        public int id() { // Getter untuk ID
            return id;
        }

        public T activity() { // Getter untuk activity
            return activity;
        }
    }

    private final int maxSize;
    private LinkedList<ItemJejakDigital<A>> listActivities; // List untuk menyimpan Item
    private int nextId = 0; // counter untuk ID aktivitas berikutnya

    /**
     * Konstruktor untuk JejakDigital
     * @param maxSize jumlah maksimal jejak digital yang bisa disimpan di suatu feed (list)
     * TC input maxSize dipastikan selalu angka positif, jadi tidak perlu handle untuk yang nonpositif.
     */
    public JejakDigital(int maxSize) {
        this.maxSize = maxSize;
        listActivities = new LinkedList<>();
    }

    /**
     * Nambahin jejak (aktivitas) baru ke feed.
     * Jejak baru ini bakal dapet ID unik yang terus nambah,
     * dan jadi yang paling baru (ditaruh di paling depan list).
     * Kalo nambahin ini bikin feed kepenuhan (lebih dari maxSize),
     * jejak digital yang paling lama (di paling belakang list) bakal dihapus.
     * @param dataJejakDigital aktivitas yang mau ditambahin ke feed
     */
    public void addActivity(A dataJejakDigital) {
        ItemJejakDigital<A> newItem = new ItemJejakDigital<>(nextId, dataJejakDigital);

        nextId++;

        listActivities.addFirst(newItem);

        if (listActivities.size() > maxSize) {
            listActivities.removeLast();
        }
    }

    /**
     * Ngasih list string yang udah diformat jadi "[ID] - Aktivitas" (pake []-nya yah),
     * diurutin dari jejak PALING BARU ke PALING LAMA.
     * Cocok buat ditampilin langsung ke user. (usernya adalah grader olympia)
     *
     * @return List of String yang udah rapi dan siap tampil.
     */
    public List<String> recentToOldestJejakDigital() {
        List<String> recentToOldest = new ArrayList<>();
        String activities;
        for (ItemJejakDigital<A> item : listActivities){
            activities = "[" + item.id() + "] - " + item.activity();
            recentToOldest.add(activities);
        }

        return recentToOldest;
    }

    /**
     * Ngasih list string yang udah diformat jadi "[ID] - Aktivitas" (pake []-nya yah),
     * diurutin dari jejak PALING LAMA ke PALING BARU.
     * Cocok buat ditampilin langsung ke user. (usernya adalah grader olympia)
     *
     * @return List of String yang udah rapi dan siap tampil.
     */
    public List<String> oldestToRecentJejakDigital() {
        List<String> oldestToRecent = new ArrayList<>();
        String  activities;
        Iterator<ItemJejakDigital<A>> descendingIterator = listActivities.descendingIterator();

        while (descendingIterator.hasNext()) {
            ItemJejakDigital<A> item = descendingIterator.next();
            activities = "[" + item.id() + "] - " + item.activity();
            oldestToRecent.add(activities);
        }
        return oldestToRecent;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return listActivities.size();
    }

    public List<A> getActivities() {
        List<A> activities = new ArrayList<>();
        for (ItemJejakDigital<A> item : listActivities) {
            activities.add(item.activity());
        }
        return activities;
    }
}