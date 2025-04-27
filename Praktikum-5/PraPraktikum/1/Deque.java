/**
 * Deque.java
 * Nama: Nazwan SM
 * NIM: 18223066
 */

/**
 * Kelas Deque merupakan implementasi struktur data double-ended queue
 * menggunakan double linked list.
 * Mendukung operasi penambahan dan penghapusan elemen di kedua ujung.
 */
public class Deque<E> {

    /**
     * Kelas Node merepresentasikan satu elemen dalam Deque.
     * Menyimpan data serta reference ke node berikutnya dan sebelumnya.
     */
    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Menunjuk ke elemen pertama
    private Node tail; // Menunjuk ke elemen terakhir
    private int size;  // Menyimpan jumlah elemen dalam deque

    /**
     * Konstruktor untuk menginisialisasi deque kosong.
     */
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Mengecek apakah deque kosong.
     * @return true jika kosong, false jika tidak
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Mengembalikan jumlah elemen dalam deque.
     * @return jumlah elemen
     */
    public int getSize() {
        return size;
    }

    /**
     * Menambahkan elemen ke depan deque.
     * @param element elemen yang ingin ditambahkan
     */
    public void addFirst(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Menambahkan elemen ke belakang deque.
     * @param element elemen yang ingin ditambahkan
     */
    public void addLast(E element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Menghapus dan mengembalikan elemen dari depan deque.
     * Jika deque kosong, print "Deque kosong. Tidak bisa menghapus elemen".
     * @return elemen yang dihapus, atau null jika kosong
     */
    public E removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque kosong. Tidak bisa menghapus elemen.");
            return null;
        }
        E data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    /**
     * Menghapus dan mengembalikan elemen dari belakang deque.
     * Jika deque kosong, print "Deque kosong. Tidak bisa menghapus elemen".
     * @return elemen yang dihapus, atau null jika kosong
     */
    public E removeLast() {
        if (isEmpty()) {
            System.out.println("Deque kosong. Tidak bisa menghapus elemen.");
            return null;
        }
        E data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    /**
     * Mengambil elemen pertama tanpa menghapusnya.
     * @return elemen pertama, atau null jika kosong
     */
    public E getHead() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    /**
     * Mengambil elemen terakhir tanpa menghapusnya.
     * @return elemen terakhir, atau null jika kosong
     */
    public E getTail() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    /**
     * Menampilkan isi deque dalam format [elemen1, elemen2, ...]
     */
    public void display() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}