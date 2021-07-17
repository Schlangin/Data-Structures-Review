package methodswparameters;

import java.util.Scanner;
public class apples {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		Tuna tunaObject = new Tuna();
		
		System.out.println("Enter Your name here ");
		String name = keyboard.nextLine();
		
		tunaObject.simpleMessage(name);
	}
}
