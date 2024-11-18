package app;

// input x
/* output
SeoulTech
(1) Alice in SeoulTech
(2) Bob in SeoulTech
*/
// static에 대한 예제
// main() method, global variables or functions(전역 변수,전역 함수), Shared variable between objects(같은 변수를 object들이 가질때)에 사용한다
// static method는 오직 static data에만 access 할 수 있다
// this는 사용 할 수 없다.

public class Student {
	int stuid;
	String name;
	static String univ = "SeoulTech";

	
	public Student(int id, String n) {
		this.stuid = id;
		this.name = n;
	}
	
	public String toString() {
		return "(" + stuid + ") " + name + " in " + univ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Student.univ);
		
		Student stu1 = new Student(1, "Alice");
		Student stu2 = new Student(2, "Bob");
		
		System.out.println(stu1.toString());
		System.out.println(stu2.toString());

	}

}
