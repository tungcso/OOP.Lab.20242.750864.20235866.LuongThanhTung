import javax.swing.JOptionPane;

public class ShowTwoNumbers{
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification= "You've just entered: ";

        strNum1 =  JOptionPane.showInputDialog(null,
            "Please input the first number: (Enter 2023)","Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
    
        strNum2 = JOptionPane.showInputDialog(null,
                    "Please input the second number: (Enter 5866) ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null,strNotification,
                    "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

    }
    
}