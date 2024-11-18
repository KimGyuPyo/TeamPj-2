/*
 * 예외가 발생하면 이를 인지하고 처리하는 try-catch-finally statement
 * try -> 예외가 발생할 가능성이 있는 블록
 * catch -> try 블록에서 예외가 발생했을 때 이를 처리하는 블록
 * finally -> 예외 발생 여부와 상관없이 무조건 실행되는 블록 (생략가능)
 * 
 * ex) input : jungwoo jungwoo
 * 	   output : 이름은 jungwoo, Exception : InputMismatchException    -> error
 * 
 * ex) input : jungwoo 23
 * 	   output : 이름은 jungwoo, 나이는 23살
 */

package week3;

import java.util.Scanner;
import java.util.InputMismatchException;	// 다른 자료형이 입력되면 발생하는 예외 처리

public class InputException {

	public static void main(String[] args) {
		System.out.println("이름, 나이를 빈칸으로 분리하여 입력하세요");
		
		try {
			Scanner sin = new Scanner(System.in);	
			
			String name = sin.next();
			System.out.print("이름은 " + name + ", ");
			
			int age = sin.nextInt();
			System.out.print("나이는 " + age + "살");

			sin.close();
		}	// String이 아닌 다른 자료형이 입력될 수 있음
		catch (InputMismatchException e) {
			System.out.println("Exception : InputMismatchException");
		}	// 예외가 발생했을 때 문자열 출력
		
	}
}