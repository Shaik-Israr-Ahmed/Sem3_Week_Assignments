import java.util.Scanner;

public class LoginSimulator {

    static void simulateLogin(String correctCode, String[] attempts) {

        boolean accessGranted = false;

        for (int i = 0; i < attempts.length; i++) {

            if (attempts[i].equals(correctCode)) {

                System.out.println("Access granted on attempt " + (i + 1));

                accessGranted = true;

                break;
            }
        }

        if (!accessGranted) {

            System.out.println("Access denied — all attempts used");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct code: ");
        String correctCode = sc.nextLine();

        String[] attempts = new String[3];

        System.out.println("Enter 3 attempts:");

        for (int i = 0; i < 3; i++) {
            attempts[i] = sc.nextLine();
        }

        simulateLogin(correctCode, attempts);

        sc.close();
    }
}