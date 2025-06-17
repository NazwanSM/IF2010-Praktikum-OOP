import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        int Q = sc.nextInt();
        int X;
        for (int i = 0; i < Q; i++) {
            String operation = sc.next();
            switch (operation) {
                case "add":
                    X = sc.nextInt();
                    set.add(X);
                    break;
                case "remove":
                    X = sc.nextInt();
                    if (set.contains(X)) {
                        set.remove(X);
                    } else {
                        System.out.println("Element " + X + " is not in The TreeSet");
                    }
                    break;
                case "first":
                    if (!set.isEmpty()) {
                        System.out.println(set.first());
                    } else {
                        System.out.println("EMPTY");
                    }
                    break;
                case "last":
                    if (!set.isEmpty()) {
                        System.out.println(set.last());
                    } else {
                        System.out.println("EMPTY");
                    }
                    break;
                default:
                    break;
                }
            }
        sc.close();
        }
    }
