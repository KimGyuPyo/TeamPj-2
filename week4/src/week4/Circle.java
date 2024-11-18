package week4;

public class Circle {		// 'Circle' class 생성 (public : 다른 class, package 에서 access 가능)
	
	private final double PI = 3.14;		// private : 동일 class 내에서만 access 가능
	
	//public int radius;
	//public String name;
	
	private int radius;		// 'private' member variables
	private String name;
	
	public Circle() {
		this(1, "random pizza");
	}
	
	//public Circle() {			// constructor ('constructor' 이름은 'class'와 동일해야함)
		
	//}
	
	
	public Circle(int r, String n) {
		this.initialize(r, n);
	}
	
	public Circle(Circle c) {		// 만들어진 object 를 argument 로 받음 (Implement copy constructor)
		radius = c.radius;
		name = new String(c.name);
	}
	
	//public void initialize(int r, String n) {		// initialization method (radius = r, name = n)
	//		radius = r;
	//  	name = n;
	//}
	
	private void initialize(int r, String n) {	
			radius = r;
		  	name = n;
		}
	
	public double getPI() {
		return PI;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}
	
	public String toString() {		// name, radius 값 확인 method
		return "name : " + name + " radius : " + radius;
	}
	
	public static void main(String[] args) {
		// System.out.println("Design a Circle class");
		
		Circle pizza = new Circle(15, "Hawaiian Pizza");
		System.out.println(pizza.toString());
		
		Circle pizza2 = new Circle();
		System.out.println(pizza2.toString());
		
		//Circle pizza = new Circle();		// reference variable 'pizza'선언, 객체 생성 (메모리 공간 할당)
		
		//pizza.radius = 10;		// initialization by reference variable
		//pizza.name = "Cheese Pizza";
		
		//System.out.println(pizza.toString());
		
		//Circle pizza2 = new Circle();	
		
		//pizza2.initialize(6, "Chicago Pizza");	// initialization by method
		
		//System.out.println(pizza2.toString()); toString -> 객체를 문자열로 표현!!!!!!!!!!!!!!
		
		//Circle pizza3 = new Circle(15, "Hawaiian Pizza");	// initialization by constructor (이 방법 추천)
		//System.out.println(pizza3.toString());		
		
		//Circle pizzaCopy = new Circle(pizza3);		// copy constructor 사용
		//System.out.println(pizzaCopy.toString());
		
	}

}
//		input : 15, Hawaiian Pizza      1, random pizza
//		output : name : Hawaiian Pizza radius : 15
//				 name : random pizza radius : 1

// package : 유사 class 모아놓은 collection (class 의 상위개념), 서로 다른 package 에서는 동일한 이름 중복 사용가능

// Declaration - Instantiation - Initialization, 점(.)연산자 이용하여 객체 멤버에 접근 가능 ( pizza.toString() )

// Constructor : class 이름과 동일해야 하며, return type 지정불가, 'default constructor' 존재
// method overloading -> 여러 constructor 지정 가능

// this <-> this()
// this : object 자기 자신을 가리킴, 객체의 member variable 과 메소드의 변수의 이름이 같은 경우 사용
// this() : class 내부에서 다른 constructor 호출, constructor 의 첫번째 줄에서만 사용가능(위치 정해짐)