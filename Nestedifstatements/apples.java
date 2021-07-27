package Nestedifstatements;

public class apples {
public static void main(String[] args) {
	int age = 60;
	
	if(age < 50) {
		System.out.println("your young");
	}else {
		System.out.println("your old");
		if (age > 75) {
			System.out.println( " you really old");
		}else {
			System.out.println("dont worry your not that old");
		}
	}
	
}
}
