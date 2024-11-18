package app;

// input1 x
// output1 x

// 1. InheritanceEx 예제를 위한 superclass 이다 x, y좌표를 받아 showPoint method로 x, y 값을 보여준다


// input2 x
// output2 x


// 2. Inheritance에서 Constructor를 사용해 보는 예제이다. super()을 통해 매개변수를 받는다.

//public class MyPoint {
class MyPoint{
	/*	int x, y = 0;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}

*/
	private int x, y;
	
	MyPoint(){
		x = 0;
		y = 0;
	}
	
	MyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		System.out.println("("+x + "," + y +")");
	}


}
