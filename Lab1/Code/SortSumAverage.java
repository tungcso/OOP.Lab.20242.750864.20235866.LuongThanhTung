import java.util.Arrays;
import java.util.Scanner;

public class SortSumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         System.out.print("Luong Thanh Tung - Enter number of elements: ");
        int n = sc.nextInt();

        
        int[] numbers = new int[n];

                System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

    
        Arrays.sort(numbers);

        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / n;

        
        System.out.println("\nSorted Array: " + Arrays.toString(numbers));
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average value: " + average);

        sc.close();
    }
}