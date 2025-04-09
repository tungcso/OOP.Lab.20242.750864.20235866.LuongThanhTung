package OOP;

public class Aims {
    public static void main(String[] args) {

        // Step 1: Open a new DVD cart
        Cart shoppingCart = new Cart();

        // Step 2: Add "The Lion King" DVD to the cart
        DigitalVideoDisc lionKing = new DigitalVideoDisc(
            "The Lion King", "Animation", "Roger Allers", 87, 19.95f
        );
        shoppingCart.addDigitalVideoDisc(lionKing);

        // Step 3: Add "Star Wars" DVD
        DigitalVideoDisc starWars = new DigitalVideoDisc(
            "Star Wars", "Science Fiction", "George Lucas", 82, 24.95f
        );
        shoppingCart.addDigitalVideoDisc(starWars);

        // Step 4: Add "Aladin" DVD using a shorter constructor (no director or length)
        DigitalVideoDisc aladin = new DigitalVideoDisc(
            "Aladin", "Animation", 18.99f
        );
        shoppingCart.addDigitalVideoDisc(aladin);

        // Step 5: Show total cost of all DVDs currently in the cart
        System.out.println("Total cost is: " + shoppingCart.totalCost());

        // Step 6: Add a new DVD: "Frozen"
        DigitalVideoDisc frozen = new DigitalVideoDisc(
            "Frozen", "Animation", "Disney", 100, 20.00f
        );
        shoppingCart.addDigitalVideoDisc(frozen);

        // Step 7: Remove "Frozen" DVD from the cart
        System.out.println("Removing disc...");
        shoppingCart.removeDigitalVideoDisc(frozen);

        // Step 8: Display the total number of DVD objects created so far
        System.out.println("Total discs created: " + DigitalVideoDisc.getNbDigitalVideoDisc());
    }
}