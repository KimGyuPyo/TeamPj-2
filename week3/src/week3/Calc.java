/*
 * CLI (command line-interface)를 이용
 * Run -> Run configurations -> 해당 코드 -> Arguments 에 입력 (띄어쓰기로 구분)
 * arg에 입력된 문자열을 double 형으로 변환하여 전체 합 구하는 코드
 * 
 * ex) Program arguments : abc 3 5.7
 * 	   output : 에러 출력 ("abc"에 예외 발생 : string은 double로 변환 불가)
 * 
 * ex) Program arguments : 1 3 5.7
 * 	   output : 합계 : 9.7
 */

package week3;

public class Calc {

	public static void main(String[] args) {
		double sum = 0.0;
		
		for (int i = 0; i < args.length; i++)	// args에 입력된 인자 개수만큼 반복
			sum += Double.parseDouble(args[i]);	// 각 문자열을 double로 변환하여 합산
		
		System.out.println("합계 : " + sum);
	}
}
