package app;

// input x
/* output 
5
10
-8
*/
// mytype package의 Clac class를 임포트하여 static method를 사용해 보는 예제
import mytype.Clac; // Clac class를 사용하기 위한 임포트

public class ClacEx {
	public static void main(String[] args) {
		System.out.println(Clac.abs(5)); //절댓값
		System.out.println(Clac.max(10, 8)); // 큰값
		System.out.println(Clac.min(-3, -8)); // 작은값
		
	}
}
