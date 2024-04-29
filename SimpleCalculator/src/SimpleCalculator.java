import java.util.Scanner;
import java.io.*;

public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		Calculator cal = new Calculator(input);
		cal.makingNumbers();
		try {
			cal.zeroCheckerAdd();
			cal.zeroCheckerSub();
			cal.calculation();
			cal.rangeChecker();
		}catch(AddZeroException e) {
			System.out.println("AddZeroException");
			return;
		}
		catch(SubtractZeroException e) {
			System.out.println("SubtractZeroException");
			return;
		}
		catch(OutOfRangeException e) {
			System.out.println("OutOfRangeException");
			return;
		}
		System.out.printf("%d",cal.result);
	}
}

class Calculator{
	String str;
	int num1, num2;
	int decider;
	int result;
	String right, left;
	Calculator(String str){
		this.str = str;
	}
	void makingNumbers() {
		left = str.split("\\+")[0];
		decider = 1;
		if (left.equals(str)) {
			left = str.split("\\-")[0];
			right = str.split("\\-")[1];
			decider = 2;
		}
		else
			right = str.split("\\+")[1];
		num1 = Integer.valueOf(left);
		num2 = Integer.valueOf(right);
	}
	void calculation() {
		if (decider == 1)
			result = num1 + num2;
		if (decider == 2)
			result = num1 - num2;
	}
	void zeroCheckerAdd() throws AddZeroException {
		if (decider != 1)
			return;
		if (num1 == 0 || num2 == 0)
			throw new AddZeroException();			
	}
	
	void zeroCheckerSub() throws SubtractZeroException{
		if (decider != 2)
			return;
		if (num1 == 0 || num2 == 0)
			throw new SubtractZeroException();		
	}
	
	void rangeChecker() throws OutOfRangeException{
		if (num1 > 1000 || num2 > 1000)
			throw new OutOfRangeException();
		if (result < 0 || result > 1000)
			throw new OutOfRangeException();
	}
}

class OutOfRangeException extends Exception{
	public OutOfRangeException() {}
}

class AddZeroException extends Exception{
	public AddZeroException() {}
}

class SubtractZeroException extends Exception{
	public SubtractZeroException() {}
}