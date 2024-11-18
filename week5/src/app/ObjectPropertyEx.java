package app;

// input x
/* output
app.Point
app.Point@279f2327
app.Point@279f2327
*/
// Object class로 객체 속성을 알아보는 예제
// obj.toString()와 obj의 출력 결과가 같게 나왔다
// 인터넷님께서 자바는 print,println 등 출력 메소드를 사용하여 객체를 출력할때 자바 컴파일러가 자동으로 toString()메소드를 호출해 같은 결과가 나왔다고 하셨다.
// @이후의 값은 해시코드로 객체를 식별하는 하나의 고유 정수값이라 한다.
// 객체.toString()의 형태는 toString() 메소드를 재정의하여 쓰는것이 옳아 보인다.

class Point{
	private int x, y;
	public Point(int x, int y) {
		this.x =x;
		this.y =y;
	}
}

public class ObjectPropertyEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());
		System.out.println(obj.toString());
		System.out.println(obj);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(2, 5);
		print(p);

	}

}
