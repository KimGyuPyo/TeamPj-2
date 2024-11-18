package mytype;

//input x
//output x
//app package의 CircleArrayEx에서 사용하기 위한 class 

public class Circle {
	
	private final double PI = 3.14; //private는 동일한 class에서만 접근이 가능
	
	private int radius;
	
	public Circle(int radius) { // Constructor, public 다른 class, package에서도 접근 가능
		this.radius = radius; // 변수이름이 같아 this reference를 사용함
	}
	
	public double getArea() {
		return PI * radius * radius;
	}

}
