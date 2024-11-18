package app;

// input1 x
// output1 x

// 1. InheritanceEx 예제를 위한 MyPoint class의 subclass이다. 색과 색과함께 좌표를 출력하는 메소드가 추가 되었다.


// input2 x
// output2 x

// 2. Inheritance에서 Constructor를 사용해 보는 예제이다. super()을 통해 매개변수를 superclass에 보내준다.

public class ColorPoint extends MyPoint {
	/*	String color;
	
	public void setColor(String color) {
		this.color = color;
	}

	
	public void showColorPoint(){
		System.out.println(color+"("+x + "," + y +")");
	}
	
*/
	private String color;
	
	ColorPoint(int x, int y, String color){
		super(x, y);
		this.color = color;
	}
		
	public void showColorPoint(){
		System.out.print(color);
		showPoint();
	}

}
