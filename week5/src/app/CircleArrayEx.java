package app;

// input x
/*output 
0
28
113
254
452
*/
// mytype package의 Circle class를 임포트해 사용해보는 예제

import mytype.Circle; // 다른 패키지에 있는 class이기에 import를 해야한다.

public class CircleArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle[] c;
		c = new Circle[5];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = new Circle(i*3);
		}
		
		for (Circle cobj : c) {
			System.out.println((int)cobj.getArea());
		}

	}

}
