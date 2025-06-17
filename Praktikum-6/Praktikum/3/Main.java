import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String inputPassword = scanner.nextLine();
            Password password = new Password(inputPassword);

            boolean isValid = password.validate();
            System.out.println(isValid);
            System.out.println("Password validated.");

        } catch (InvalidLengthException e) {
            System.out.println("InvalidLengthException! " + e.getMessage());
            System.out.println("Password string error!");
        } catch (InvalidPasswordException e) {
            System.out.println("InvalidPasswordException! " + e.getMessage());
            System.out.println("Password string error!");
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        } finally {
            scanner.close();
            System.out.println("Operation finished.");
        }
    }
}