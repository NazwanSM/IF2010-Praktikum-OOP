import java.util.ArrayList;

public class BahasaC extends Bahasa {
    public BahasaC(ArrayList<String> files) {
        super(files);
        extention = ".c";
    }

    public void compile() throws BahasaError {
        for (String file : this.files) {
            if (!file.endsWith(this.extention)) {
                throw new WrongExtentionException(this.extention, file);
            }
        }
        System.out.println("gcc -o " + removeExtention(files.get(0)) + " " + String.join(" ", files));
    }

    public void grade(String inputFilename, String outputFilename) throws BahasaError {
        if (!inputFilename.endsWith(".in")) {
            throw new WrongExtentionException(".in", inputFilename);
        }
        if (!outputFilename.endsWith(".out")) {
            throw new WrongExtentionException(".out", outputFilename);
        }
        if (!removeExtention(inputFilename).equals(removeExtention(outputFilename))) {
            throw new TestcaseMismatchException(inputFilename, outputFilename);
        }
        System.out.println("./" + removeExtention(files.get(0)) + " < " + inputFilename + " > " + outputFilename);
    }
}