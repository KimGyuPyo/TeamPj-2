package week4;

public class MethodEx {
	
	public int getSum(int i, int j) {		// 두 정수 i 와 j 를 더하는 method
		return i + j;
	}
	
	public int getSum(int i, int j, int k) {		// 세 정수 i j k 를 더하는 method
		return i+ j+ k;
	}
	
	public double getSum(double i, double j) {		// 두 실수 i 와 j 를 더하는 method
		return i + j;
	}

		//	1 ~ 3 method 같은 이름 'getSum' 가지지만, argument 의 개수와 Type 다름 
		// 두 method 가 매개변수의 개수, Type 이 같을 때, return Type 서로 다르면 method overloading 실패?????????????
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodEx a = new MethodEx();
		
		int val1 = a.getSum(1,  2);		// 1번째 method 실행
		
		int val2 = a.getSum(1, 2, 3);		// 2번째 method 실행
		
		double val3 = a.getSum(1.1, 2.2);	// 3번째 method 실행
		
		
		System.out.println("val1 is " + val1 + " val2 is " + val2 + " val3 is " + val3);
	}

}
//		input :   1, 2     1, 2, 3      1.1, 2.2
//	   output :   3		   6            3.3000000000000003 -> 3.3이 아닌 이유??????

// method overloading : 같은 이름의 method 를 여러 개 만드는 것 ( 여러 constructor 지정 가능 )
