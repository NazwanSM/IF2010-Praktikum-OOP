public class MaskPII {
    private String maskEmail(String email) {
        // Ubah semua karakter menjadi huruf kecil
        email = email.toLowerCase();
        
        // Pisahkan name dan domain
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];
        
        // Lakukan masking
        String maskedName = name.charAt(0) + "*****" + name.charAt(name.length() - 1);
        
        return maskedName + "@" + domain;
    }

    private String maskPhoneNumber(String phoneNumber) {
        // Hapus semua karakter non-digit tanpa replaceAll
        String digits = "";
        for (char c : phoneNumber.toCharArray()) {
            if (Character.isDigit(c)) {
                digits += c;
            }
        }
        
        // Tentukan panjang country code
        int localNumberLength = 10;
        int countryCodeLength = digits.length() - localNumberLength;
        
        // Ambil 4 digit terakhir dari local number
        String lastFourDigits = digits.substring(digits.length() - 4);
        
        // Format masking
        String maskedLocal = "***-***-" + lastFourDigits;
        if (countryCodeLength == 0) {
            return maskedLocal;
        } else {
            String maskedCountry = "+";
            for (int i = 0; i < countryCodeLength; i++) {
                maskedCountry += "*";
            }
            return maskedCountry + "-" + maskedLocal;
        }
    }

    public String maskPII(String pii) {
        // Jika mengandung '@', maka itu adalah email
        if (pii.contains("@")) {
            return maskEmail(pii);
        } else {
            return maskPhoneNumber(pii);
        }
    }
}
