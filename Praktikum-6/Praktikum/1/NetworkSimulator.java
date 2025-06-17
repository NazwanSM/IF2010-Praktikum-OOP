import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class NetworkSimulator {
    /**
     * Fungsi untuk mencari node berdasarkan ID (helper function).
     * Sudah diimplementasikan asisten, tidak perlu diubah, tetapi tidak wajib digunakan.
     * * @param nodes daftar node yang terhubung dalam jaringan
     * @param id ID node yang dicari
     * @return Node yang ditemukan, atau null jika tidak ditemukan
     */
    private static Node findNode(List<Node> nodes, String id) {
        for (Node node : nodes) {
            if (node.id.equals(id)) {
                return node;
            }
        }
        return null;
    }
    
    /**
     * Fungsi untuk memproses satu paket dan melakukan validasi terhadap aturan jaringan.
     * ... (deskripsi lengkap ada di soal)
     */
    public static void validatePacket(List<Node> nodes, Map<String, Set<Integer>> transmissionLog, Packet packet) throws NetworkException {
        Node sourceNode = findNode(nodes, packet.from);
        Node destNode = findNode(nodes, packet.to);

        // Validasi: Node sumber atau tujuan tidak ada
        if (sourceNode == null || destNode == null) {
            throw new NetworkException();
        }

        // Validasi: Loopback (sumber = tujuan)
        if (packet.from.equals(packet.to)) {
            throw new LoopbackException(String.format("Loopback: Node %s tidak boleh mengirim ke dirinya sendiri.", packet.from));
        }

        // Validasi: Time desync
        if (packet.timestamp <= destNode.lastReceived) {
            throw new TimeDesyncException(String.format("Time desync: Node %s sudah menerima hingga waktu %d, tetapi kemudian menerima dari %s dengan waktu %d", destNode.id, destNode.lastReceived, sourceNode.id, packet.timestamp));
        }

        // Validasi: Collision
        if (transmissionLog.containsKey(packet.to) && transmissionLog.get(packet.to).contains(packet.timestamp)) {
            throw new CollisionException(String.format("Collision: Ada lebih dari satu paket ke node %s pada waktu %d", packet.to, packet.timestamp));
        }

        // Jika semua validasi lolos, update state
        destNode.lastReceived = packet.timestamp;

        // Update transmissionLog
        // Jika node tujuan belum ada di log, buat entri baru
        if (!transmissionLog.containsKey(packet.to)) {
            transmissionLog.put(packet.to, new HashSet<>());
        }
        // Tambahkan timestamp ke log node tujuan
        transmissionLog.get(packet.to).add(packet.timestamp);
    }
}

/**
 * Superclass untuk semua exception terkait jaringan.
 */
class NetworkException extends Exception {
    public NetworkException() {
        super();
    }

    public NetworkException(String message) {
        super(message);
    }
}

/**
 * Exception untuk kasus di mana node mencoba mengirim ke dirinya sendiri.
 * ... (deskripsi lengkap ada di soal)
 */
class LoopbackException extends NetworkException {
    public LoopbackException(String message) {
        super(message);
    }
}


/**
 * Exception untuk kasus node menerima timestamp lebih kecil/sama dari yang sebelumnya.
 * ... (deskripsi lengkap ada di soal)
 */
class TimeDesyncException extends NetworkException {
    public TimeDesyncException(String message) {
        super(message);
    }
}

/**
 * Exception untuk kasus dua pengiriman ke node yang sama di waktu yang sama.
 * ... (deskripsi lengkap ada di soal)
 */
class CollisionException extends NetworkException {
    public CollisionException(String message) {
        super(message);
    }
}