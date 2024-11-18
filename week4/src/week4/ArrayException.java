package week4;

import java.lang.ArrayIndexOutOfBoundsException;	// ArrayIndexOutOfBoundsException : 배열의 범위를 벗어난 접근 시 발생
													// 패키지 -> java.lang (유의)
public class ArrayException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {		// try { Exception 발생 가능한 실행문 }
		int[] intArray = new int[5];		// 정수형, 크기 5인 배열 생성
		intArray[0] = 0;
	
		for (int i = 0; i < 5; i++) {
			intArray[i+1] = i + 1 + intArray[i];
			System.out.println("intArray[" + i + "] = " + intArray[i]);
		}
		} catch (ArrayIndexOutOfBoundsException e) {		// catch (예외 타입 선언) { 예외 처리문 }
			System.out.println("Exception : ArrayIndexOutOfBoundsException");		// Exception 발생 시 호출됨
		}
	}

}
		// input : 0, 1, 2, 3, 4
		// output : 0, 1, 3, 6, , Exception : ArrayIndexOutOfBoundsException

		// try - catch

		// try {
		//   실행문
		//  }
		// catch (처리할 예외 타입 선언)
		// {
		//   예외 처리문
		//	}

		// for 문 에서 i = 4 일 경우, intArray[5] = 4 + 1 + intArray[4] -> 크기 5인 'intArray' 배열 범위 초과
		// -> 예외 타입 'ArrayIndexOutOfBoundsException'