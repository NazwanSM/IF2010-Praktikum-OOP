public class Password {
    private String password;
    private final String SPECIAL_CHARS = "!@#$%^&*(),./";

    /**
     * Constructor untuk Password
     * @param password string password
     */
    public Password(String password) {
        this.password = password;
    }

    /**
     * Memeriksa apakah password memiliki minimal satu huruf kapital
     * @return true jika valid, false jika tidak
     */
    private boolean hasUpperCase() {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Memeriksa apakah password memiliki minimal satu angka
     * @return true jika valid, false jika tidak
     */
    private boolean hasNumber() {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Memeriksa apakah password memiliki minimal satu karakter khusus sebagai berikut: !@#$%^&*(),./
     * @return true jika valid, false jika tidak
     */
    private boolean hasSpecialChar() {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARS.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validasi password dengan aturan yang telah ditentukan.
     */
    public boolean validate() throws InvalidLengthException, InvalidPasswordException {
        if (this.password.length() < 12) {
            throw new InvalidLengthException("Password harus memiliki panjang minimal 12 karakter");
        }
        if (!this.hasUpperCase()) {
            throw new InvalidPasswordException("Password harus mengandung minimal satu huruf kapital");
        }
        if (!this.hasNumber()) {
            throw new InvalidPasswordException("Password harus mengandung minimal satu angka");
        }
        if (!this.hasSpecialChar()) {
            throw new InvalidPasswordException("Password harus mengandung minimal satu karakter khusus");
        }
        return true;
    }
}

/**
 * Exception untuk password yang tidak valid
 */
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

/**
 * Exception untuk panjang password yang tidak valid
 */
class InvalidLengthException extends Exception {
    public InvalidLengthException(String message) {
        super(message);
    }
}