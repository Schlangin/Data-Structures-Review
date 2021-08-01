package compoundInterestProgram;

public class apples {
	public static void main(String[] args) {
			//Amount = Principal(1 + rate)^years;
		double amount;
		double principle = 10000;
		double rate = .01;
		
		for(int day=1;day<=20;day++) {
			amount = principle *Math.pow(1 + rate, day);
			System.out.println(day + "   " + amount);
		}
		
	}
}
