package mytype;

// input x
// output x
// CalcEx에서 사용하기 위한 class abs, max, min 계산 결과값을 리턴해준다.
// Clac는 무슨 약자일까

public class Clac { 
	public static int abs(int a) { return (a>0) ? a: -a; }
	public static int max(int a, int b) { return (a > b) ? a:  b; }
	public static int min(int a, int b) { return (a > b) ? b: a; }
}

