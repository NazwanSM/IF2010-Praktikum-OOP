/**
 * Hexaesar
 * 
 * Implementasikan algoritma Hexaesar sesuai dengan deskripsi pada soal.
 */ 
public class Hexaesar {
    /**
     * Fungsi untuk mengenkripsi plaintext berupa string hexadesimal dengan kunci tertentu.
     * 
     * Contoh:
     * plaintext = "12a"
     * key = 1
     * keluaran = "23b"
     */
    public static String encrypt(String plaintext, int key) {
        StringBuilder result = new StringBuilder();
        String hexStr = plaintext.toLowerCase();
        
        for (int i = 0; i < hexStr.length(); i++) {
            char c = hexStr.charAt(i);
            int value = Character.digit(c, 16);
            // Shift the value by key positions
            value = (value + key) % 16;
            // Convert back to hex character
            result.append(Integer.toHexString(value));
        }
        
        return result.toString();
    }

    /**
     * Fungsi untuk mendekripsi ciphertext berupa string hexadesimal dengan kunci tertentu.
     * 
     * Contoh:
     * ciphertext = "23b"
     * key = 1
     * keluaran = "12a"
     */
    public static String decrypt(String encrypted, int key) {
        StringBuilder result = new StringBuilder();
        String hexStr = encrypted.toLowerCase();
        
        for (int i = 0; i < hexStr.length(); i++) {
            char c = hexStr.charAt(i);
            int value = Character.digit(c, 16);
            // Shift the value back by key positions
            value = (value - key) % 16;
            if (value < 0) value += 16;
            // Convert back to hex character
            result.append(Integer.toHexString(value));
        }
        
        return result.toString();
    }

    /**
     * Fungsi untuk mengenkripsi plaintext berupa bilangan bulat dengan kunci tertentu.
     * 
     * Contoh:
     * plaintext = 10
     * key = 1
     * keluaran = 11
     */
    public static int encrypt(int plaintext, int key) {
        String hexStr = Integer.toHexString(plaintext);
        String encryptedHex = encrypt(hexStr, key);
        return Integer.parseInt(encryptedHex, 16);
    }

    /**
     * Fungsi untuk mendekripsi ciphertext berupa bilangan bulat dengan kunci tertentu.
     * 
     * Contoh:
     * ciphertext = 11
     * key = 1
     * keluaran = 10
     */
    public static int decrypt(int encrypted, int key) {
        String hexStr = Integer.toHexString(encrypted);
        String decryptedHex = decrypt(hexStr, key);
        return Integer.parseInt(decryptedHex, 16);
    }
}
