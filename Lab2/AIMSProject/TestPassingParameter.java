package OOP;

public class TestPassingParameter {

    public static void main(String[] args) {

        // Initialize two DigitalVideoDisc objects with distinct titles
        DigitalVideoDisc discA = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc discB = new DigitalVideoDisc("Cinderella");

        // Attempt to swap the object references
        swap(discA, discB);

        // Output the titles after the swap attempt
        System.out.println("discA title: " + discA.getTitle());
        System.out.println("discB title: " + discB.getTitle());

        // Change the title of discA to match that of discB
        changeTitle(discA, discB.getTitle());

        // Output the title after modifying it
        System.out.println("discA updated title: " + discA.getTitle());
    }

    public static void swap(Object obj1, Object obj2) {
        Object temp = obj1;
        obj1 = obj2;
        obj2 = temp;
    }

    public static void changeTitle(DigitalVideoDisc disc, String newTitle) {
        String originalTitle = disc.getTitle();
        disc.setTitle(newTitle);
        disc = new DigitalVideoDisc(originalTitle); 
    }
}
