import java.util.Scanner;



public class DaysInMonth {
    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        int month = 0;
        boolean validInput = false;
        while (true) {
            System.out.print("Luong Thanh Tung - Enter a year: ");
            year = scanner.nextInt();
            if( year >=0){
                    break;
            }

            System.out.println("Invalid year. Please enter again.");
        }
        scanner.nextLine();
       
        
        while (!validInput) {
            System.out.print("Enter a month: ");
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "january": case "jan.": case "jan":
                case "1": month = 1; validInput = true; break;
                case "february": case "feb.": case "feb":
                case "2": month = 2; validInput = true; break;
                case "march": case "mar.": case "mar": 
                case "3": month = 3; validInput = true; break;
                case "april": case "apr.": case "apr": 
                case "4": month = 4; validInput = true; break;
                case "may": case "5": month = 5; validInput = true; break;
                case "june": case "jun.": case "jun": 
                case "6": month = 6; validInput = true; break;
                case "july": case "jul.": case "jul": 
                case "7": month = 7; validInput = true; break;
                case "august": case "aug.": case "aug": 
                case "8": month = 8; validInput = true; break;
                case "september": case "sep.": case "sep": 
                case "9": month = 9; validInput = true; break;
                case "october": case "oct.": case "oct": 
                case "10": month = 10; validInput = true; break;
                case "november": case "nov.": case "nov": 
                case "11": month = 11; validInput = true; break;
                case "december": case "dec.": case "dec": 
                case "12": month = 12; validInput = true; break;
                default:
                    System.out.println("Invalid month. Please enter again.");
            }
        }

        
        int days;
        switch (month) {
            case 4: case 6: case 9: case 11: 
                days = 30; break;
            case 2: 
                days = (isLeapYear(year)) ? 29 : 28; 
                break;
            default: 
                days = 31; 
        }

        System.out.println("The month has " + days + " days.");
        scanner.close();
    }
    
}