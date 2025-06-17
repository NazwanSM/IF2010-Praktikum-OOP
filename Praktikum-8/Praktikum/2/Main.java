import java.util.*;


public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        int q = sc.nextInt();
        for (int i = 0; i < q; i++){
            String opr = sc.next();
            String chara;
            switch(opr){
                case("tambah"):
                    chara = sc.next();
                    stack.push(chara);
                    System.out.println("sudah menambahkan " + chara);
                    break;
                case("beli"):
                    if (stack.empty()){
                        System.out.println("maaf stock habis");
                    }
                    else {
                        chara = stack.pop();
                        System.out.println("telah membeli " + chara);
                    }
                    break;
                case("lihat"):
                    if (stack.empty()){
                        System.out.println("maaf stock habis");
                    }
                    else {
                        System.out.println("print paling atas adalah " + stack.peek());
                    }
                    break;
                case("habis?"):
                    if (stack.empty()){
                        System.out.println("ya, habis");
                    }
                    else {
                        System.out.println("masih ada kok");
                    }
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}