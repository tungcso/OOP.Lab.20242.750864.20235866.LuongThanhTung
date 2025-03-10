import javax.swing.JOptionPane;

public class Calculator{
	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "Sum: ";
		
		strNum1 = JOptionPane.showInputDialog(null, "Luong Thanh Tung - Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		
		strNum2 = JOptionPane.showInputDialog(null, "Luong Thanh Tung - Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
		
		double num3 = num2 - num1;
		double num4 = num1/ num2;
		strNotification += num1+num2 + "\n" + "Differnce: " + Math.abs(num3) +"\n" + "Product: " + num2*num1 + "\n" + "Quotient" + num4;
		JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}