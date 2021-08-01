package Finalaveragecalcattempt;
import java.util.Scanner;
public class Calc {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int total = 0;
		int grade;
		int average;
		int counter = 0;
		System.out.println("How many grades would you like to input?");
		int input = keyboard.nextInt();
		System.out.println("enter " + input + " grades");
		while(counter < input) {
			grade = keyboard.nextInt();
			total = total + grade;
			counter++;
		}
		average = total / input ;
		System.out.println("Your classes average grade was " + average);
	}
}
