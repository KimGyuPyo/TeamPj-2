/*
 * Math 클래스를 이용한 예제 코드
 * 
 * java.lang.Math 클래스의 모든 메소드는 static 타입으로
 * 메소드 호출 시 클래스명을 포함한 이름으로 코드를 작성해야 하고,
 * instantiation 없이 사용 가능하다.
 * 
 * output) 3.141592653589793
 *         4.0
 *         3.0
 *         3.0
 *         7.38905609893065
 *         3
 *         이번주 행운의 번호는 
 *         32 
 *         26 
 *         30 
 *         3 
 *         19 
 */
package week6;

public class MathEx {

	public static void main(String[] args) {
		
		// 원주율 상수 출력
		System.out.println(Math.PI);
		
		// 원주율 상수 변수 선언
		double a = Math.PI;

		// a의 올림 출력
		System.out.println(Math.ceil(a));
		// a의 내림 출력
		System.out.println(Math.floor(a));
		// a의 제곱근 출력
		System.out.println(Math.sqrt(9));
		// e^2 출력
		System.out.println(Math.exp(2));
		// 3.14의 반올림 출력
		System.out.println(Math.round(3.14));

		// 1~45 사이의 정수형 난수 5개 출력
		System.out.println("이번주 행운의 번호는 ");
		for(int i = 0; i < 5; i++) {

			System.out.println(((int)(Math.random() * 45) + 1) + " ");
		}
		System.out.println();
	}
}
