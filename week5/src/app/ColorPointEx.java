package app;

// input1 x
/* output1 
(1,2)
blue(3,4)
*/

// 1. Inheritance 예제로 Mypoint를 상속하여 subclass인 ColorPoint를 만들어 superclass의 메소드를 사용해보는 예제이다.


// input2 x
/* output2 
green(5,6)
*/

// 2.  Inheritance에서 Constructor를 사용해 보는 예제이다.

public class ColorPointEx {

	public static void main(String[] args) {
/*		MyPoint p = new MyPoint();
		p.set(1, 2);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.set(3, 4);
		cp.setColor("blue"); // 빨강이 왠지 싫다
		cp.showColorPoint();
	}
*/
		ColorPoint cp = new ColorPoint(5, 6, "green");
		cp.showColorPoint();
	}

}
