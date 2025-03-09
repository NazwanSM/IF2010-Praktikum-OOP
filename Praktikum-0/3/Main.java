import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int k1;
        int k2;
        int k3;
        int k4;
        int k5;
        int mult;
        int boost;
        int skor;

        k1 = scan.nextInt();
        k2 = scan.nextInt();
        k3 = scan.nextInt();
        k4 = scan.nextInt();
        k5 = scan.nextInt();
        
        mult = scan.nextInt();
        boost = scan.nextInt();

        if (boost == 1){
            boost = 2;
        }
        else if (boost == 2){
            boost = 3;
        }
        else {
            boost = 1;
        }

        skor = (k1+k2+k3+k4+k5)*(mult*boost);


        System.out.print(skor + "\n");

        scan.close();
    }
}