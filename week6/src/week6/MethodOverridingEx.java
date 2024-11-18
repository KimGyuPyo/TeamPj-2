/*
 * Method Overriding 예제 코드
 * 
 * Method Overriding은 superclass에 선언된 메소드를 
 * 각 subclass들이 자신만의 내용으로 새롭게 구현하는 기능을 말한다. 
 * 
 * 이는 OOP의 네 가지 특징 중 다형성 Polymorphism 에 해당된다.
 * 
 * Shape 라는 superclass 아래에
 * Line, Rect, Circle 이라는 subclass 들이 존재하고,
 * 각 subclass에는 superclass의 draw() 메소드를 override 한 draw() 메소드가 구현되어있다.
 * 이는 각각의 모양을 문자열로 출력한다.
 * 
 * 만약 이름이 다르다면 override 된 메소드라고 할 수 없다.
 * 또한 이 메소드가 override 되었음을 강조하기 위해 메소드 위에 @Override 라고 적을 수도 있다.
 * 
 * output) Line
 *         Shape
 *         Line
 *         Circle
 */
package week6;

// Line, Rect, Circle의 superclass가 되는 Shape 클래스
class Shape {
	public Shape next;
	public Shape() {
		next = null;
	}
	
	// object의 모양을 문자열로 출력하는 메소드
	public void draw() {
		System.out.println("Shape");
	}
}

// Shape의 subclass가 되는 Line, Rect, Circle 클래스
// -> 각각의 모양을 문자열로 출력하는 draw() 메소드
//   -> Shape의 draw() 메소드를 overriding해서 구현
class Line extends Shape {
	@Override
	public void draw() {
		System.out.println("Line");	// draw() overriding
	}
}

class Rect extends Shape {
	@Override
	public void draw() {
		System.out.println("Rect");	// draw() overriding
	}
}

class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Circle"); // draw() overriding
	}
}

public class MethodOverridingEx {

	// Shape object의 draw() 를 실행하는 메소드
	static void paint(Shape p) {
		p.draw();
	}
	
	public static void main(String[] args) {
		// Line 클래스의 object 생성
		Line line = new Line();
		
		// Line 클래스의 draw()
		paint(line);
		// Shape 클래스의 draw()
		paint(new Shape());
		// Line 클래스의 draw()
		paint(new Line());
		// Circle 클래스의 draw()
		paint(new Circle());
	}
}
