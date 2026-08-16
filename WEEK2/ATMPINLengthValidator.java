import java.util.Scanner;
public class ATMPINLengthValidator {
    public void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("INVALID PIN length must be 4 digits only.");
        } else {
            System.out.println("VALID PIN length.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your ATM PIN: ");
        String pin = sc.nextLine();

        ATMPINLengthValidator validator = new ATMPINLengthValidator();
        validator.checkPinLength(pin);
        
        sc.close();
    }
}