package methodsWinstances;

import java.util.Scanner;
public class apples {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		tuna tunaObject = new tuna();
		System.out.println("Enter name of first gf here");
		String temp = keyboard.nextLine();
		tunaObject.setName(temp);
		tunaObject.saying();
		
	}
	
	
}
