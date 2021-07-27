package SimpleAveragingProgram;
import java.util.Scanner;

public class apples {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		int total = 0;
		int grade;
		int average;
		int counter = 0;
		
		while (counter < 10) {
			grade = keyboard.nextInt();
			total = total + grade;
			counter++;
		}
		average = total/10;
		System.out.println("your average is " + average);
		
	}
}
