import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Luong Thanh Tung - What's your name?");
        String strName = keyboard.nextLine();

        System.out.println("Luong Thanh Tung - How old are you?");
        int iAge = keyboard.nextInt();

        System.out.println("Luong Thanh Tung - How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        // similar to other data types
        // nextByte(), nextShort(), nextLong()
        // nextFloat(), nextBoolean()

        System.out.println("Mrs./Ms. " + strName + ", " + iAge + " years old. "
                + "Your height is " + dHeight + " m.");

        keyboard.close(); // Closing scanner to prevent resource leaks
    }
}