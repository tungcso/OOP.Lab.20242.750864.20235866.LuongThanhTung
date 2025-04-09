package OOP;

public class Cart {

    // Maximum number of DVDs allowed in the cart
    public static final int MAX_ITEMS = 20;

    // Array to store the DVDs
    private DigitalVideoDisc[] discs = new DigitalVideoDisc[MAX_ITEMS];

    // Keeps track of how many discs have been added
    private int totalDiscs = 0;

    // Adds a single DVD to the cart
    public void addDisc(DigitalVideoDisc disc) {
        if (totalDiscs < MAX_ITEMS) {
            discs[totalDiscs++] = disc;
            System.out.println("Disc successfully added.");
        } else {
            System.out.println("Cart is full. Cannot add more discs.");
        }
    }

    // Adds multiple DVDs using varargs
    public void addDiscs(DigitalVideoDisc... discArray) {
        for (DigitalVideoDisc d : discArray) {
            addDisc(d);
        }
    }

    // Adds exactly two DVDs
    public void addDiscs(DigitalVideoDisc firstDisc, DigitalVideoDisc secondDisc) {
        addDisc(firstDisc);
        addDisc(secondDisc);
    }

    // Removes a DVD from the cart
    public void removeDisc(DigitalVideoDisc disc) {
        int indexToRemove = -1;

        for (int i = 0; i < totalDiscs; i++) {
            if (discs[i] == disc) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < totalDiscs - 1; i++) {
                discs[i] = discs[i + 1];
            }
            discs[--totalDiscs] = null;
            System.out.println("Disc removed successfully.");
        } else {
            System.out.println("Disc not found in the cart.");
        }
    }

    // Calculates the total cost of all DVDs in the cart
    public float getTotalCost() {
        float total = 0.0f;
        for (int i = 0; i < totalDiscs; i++) {
            total += discs[i].getCost();
        }
        return total;
    }
}
