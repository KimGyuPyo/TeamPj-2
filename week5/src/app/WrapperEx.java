package app;

// input x
/* output
4는 숫자
F는 영문자
123
1c
11100
3
3.14
3.14
true
false
*/

// Wrapper class는 Java.lang package에 포함된 class이며 데이터 타입을 객체로 사용할 수 있게 한다.
// 문자 및 숫자 판단, 문자열의 정수 변환, 10진수 정수의 2진수, 16진수 문자열로의 변환 등 변환 및 판단에 사용된다.
// 기본 데이터 타입을 Wrapper class의 객체로 바꾸는것을 boxing 반대로 Wrapper 객체에 포함된 데이터값을 추출하는것을 unboxing이라 한다.
// Autoboxing java 컴파일러는 자동으로 boxing 해준다(int -> Integer, double -> Double).


public class WrapperEx {

	public static void main(String[] args) {
		System.out.println(Character.toLowerCase('A'));
		char c1 = '4', c2 = 'F';
		
		if (Character.isDigit(c1)) {
			System.out.println(c1 + "는 숫자");
		}
		
		if (Character.isAlphabetic(c2)) {
			System.out.println(c2 + "는 영문자");
		}
		
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.toHexString(28));
		System.out.println(Integer.toBinaryString(28));
		System.out.println(Integer.bitCount(28));
		
		Double d = Double.valueOf(3.14);
		System.out.println(d.toString());
		System.out.println(Double.parseDouble("3.14"));
		
		boolean b = (4>3);
		System.out.println(Boolean.toString(b));
		System.out.println(Boolean.parseBoolean("false"));
	}

}
