import java.util.ArrayList;

public abstract class Bahasa {
    protected ArrayList<String> files;
    protected String extention;

    public Bahasa(ArrayList<String> files) {
        this.files = files;
    }

    // Menghapus extention dari akhir nama file
    // Contohnya: namaFile "Main.jawa" akan berubah menjadi "Main"
    public String removeExtention(String namaFile) {
        int lastDotIndex = namaFile.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return namaFile.substring(0, lastDotIndex);
        }
        return namaFile;
    }

    public abstract void compile() throws BahasaError;
    public abstract void grade(String inputFilename, String outputFilename) throws BahasaError;
}

class BahasaFactory {
    // Mengembalikan kelas bahasa untuk namaBahasa yang diberikan. Jika bahasa adalah selain:
    // - "Jawa"
    // - "C"
    // - "Ular"
    // Maka ia akan mengembalikan error
    public static Bahasa getBahasaRunner(String namaBahasa, ArrayList<String> files) throws BahasaError {
        switch (namaBahasa) {
            case "Jawa":
                return new BahasaJawa(files);
            case "C":
                return new BahasaC(files);
            case "Ular":
                return new BahasaUlar(files);
            default:
                throw new BahasaNotExistsException();
        }
    }
}

class BahasaError extends Exception {
    public BahasaError() {
        super();
    }

    public BahasaError(String message) {
        super(message);
    }
}

class WrongExtentionException extends BahasaError {
    public WrongExtentionException(String supposedExtention, String filename) {
        // Mengembalikan pesan error dalam format:
        // Expected extention "{supposedExtention}" for {filename}
        super(String.format("Expected extention \"%s\" for %s", supposedExtention, filename));
    }
}

class TestcaseMismatchException extends BahasaError {
    public TestcaseMismatchException(String inputFilename, String outputFilename) {
        // Mengembalikan pesan error dalam format:
        // Input testcase for {inputFilename} got output filename of {outputFilename}
        super(String.format("Input testcase for %s got output filename of %s", inputFilename, outputFilename));
    }
}

class BahasaNotExistsException extends BahasaError {
    public BahasaNotExistsException() {
        // Mengembalikan pesan error "Bahasa doesn't exists!"
        super("Bahasa doesn't exists!");
    }
}