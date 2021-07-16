import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double first, second, answer;
		System.out.println("Enter First Number ");
		first = keyboard.nextDouble();
		System.out.println("Enter Second Number ");
		second = keyboard.nextDouble();
		answer = first + second;
		System.out.println(answer);
		
	}
}
