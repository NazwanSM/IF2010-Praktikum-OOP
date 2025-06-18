import java.util.ArrayList;
import java.util.Scanner;

public class BukanOlympia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namaBahasa = scanner.next();
        int jumlahFile = scanner.nextInt();
        ArrayList<String> files = new ArrayList<>();
        for (int i = 0; i < jumlahFile; i++) {
            files.add(scanner.next());
        }

        try {
            Bahasa runner = BahasaFactory.getBahasaRunner(namaBahasa, files);
            
            runner.compile();
            
            int jumlahTestcase = scanner.nextInt();
            for (int i = 0; i < jumlahTestcase; i++) {
                String inputFile = scanner.next();
                String outputFile = scanner.next();

                try {
                    runner.grade(inputFile, outputFile);
                } catch (BahasaError e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (BahasaError e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}