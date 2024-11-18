package week4;

public class ArrayParameterEx {
	
	static void replaceSpace(char a[]) {		// <method replace>  argument : char[], behavior : replace (' ') to (,)
		// reference type (원본에 영향줄 수 있음)
		for(int i = 0; i < a.length; i++) {		
			if (a[i] == ' ') {		
				a[i] = ',';
			}
		}
	}
	
	static void printCharArray(char a[]) {		// <method print>  argument : char [], behavior : print char in char[]
		
		for(int j = 0; j < a.length; j++) {
			System.out.print(a[j]);
		}
		for(char c : a) {
			System.out.print(c);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[] = {'S', 'M', 'A', 'R', 'T', ' ', 'I', 'C', 'T', ' ', 'i', 's', ' ', 'b', 'e', 's', 't' };
		
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
	}
}
//		input : c[] = {'S', 'M', 'A', 'R', 'T', ' ', 'I', 'C', 'T', ' ', 'i', 's', ' ', 'b', 'e', 's', 't' }
//
//		output : SMART ICT is best
//		         SMART,ICT,is,best

// Passing arguments of 'primitive type' : 실제 값 자체를 copy, passing -> 원래 값에 영향 x
// Passing arguments of 'reference type' : 주소 값 copy, passing -> 원본에 영향 o