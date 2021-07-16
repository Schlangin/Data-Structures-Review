import java.util.Scanner;
public class Switchstatement {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		
		int age;
		age = 7;
		
		switch (age) {
		case 1:
			System.out.println("You can crawl");
			break;
		case 2:
			System.out.println("You can talk");
			break;
		case 3:
			System.out.println("You can get in trouble");
		break;
	default:
		System.out.println("I dont know how old you are");
		break;
		}
	}
}
