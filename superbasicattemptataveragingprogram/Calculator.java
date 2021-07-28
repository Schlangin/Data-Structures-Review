package superbasicattemptataveragingprogram;
import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int total;
		int num = 0;
		
		System.out.println("Would you like to use the averaging calculator yes 1 or no 2" );
		 int answer = keyboard.nextInt();
		if(answer != 1) {
			System.out.println("come again later");
		}
		if(answer == 1) {
			System.out.println("enter all your numbers added together");
			double numbers = keyboard.nextDouble();
			System.out.println("enter the number of numbers");
			int numofnum = keyboard.nextInt();
			
			System.out.println("The average of your numbers is "   );
			System.out.println((numbers/numofnum));
			
		}
		
		
		
	}
}


//an average is all the numbers added / the number of numbers