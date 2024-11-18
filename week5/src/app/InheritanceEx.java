package app;

// input x
/* output
24
김만휘
174
60
*/

// Inheritance를 통해 만든 subclass NewStudent class를 이용해보는 예제이다


public class InheritanceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Newstudent s = new Newstudent();
		s.set();
		
		System.out.println(s.age);
		System.out.println(s.name);
		System.out.println(s.height);
		System.out.println(s.getWeight()); // s.weight은 private이기에 .getWeight() method를 사용했다.

	}

}
