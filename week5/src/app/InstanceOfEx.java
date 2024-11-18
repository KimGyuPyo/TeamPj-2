package app;

// input x
/* output
new NStudent() ->	Person Student
new Researcher() ->	Person Researcher 
new Professor() ->	Person Researcher Professor 
*/


// InstanceOf를 통해 객체의 타입을 확인해보는 예제이다
// upcasting은 subclass 객체를 superclass 타입으로 변환하는 것을 말한다.
// downcasting은 반대로 superclass 객체를 subclass 타입으로 변환 하는 것을 말한다.
// downcasting의 목적은 upcasting한 객체를 복구하는 것이다.
// upcasting을 할 경우 객체의 정보는 그대로이며 subclass의 맴버에 access하는 것이 제한된다.

class NPerson{}
class Nstudent extends NPerson{}
class Researcher extends NPerson{}
class Professor extends Researcher{}

public class InstanceOfEx {
	static void print(NPerson p) {
		if(p instanceof NPerson)
			System.out.print("Person ");
		if(p instanceof Nstudent)
			System.out.print("Student");
		if(p instanceof Researcher)
			System.out.print("Researcher ");
		if(p instanceof Professor)
			System.out.print("Professor ");
		System.out.println();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("new NStudent() ->\t"); print(new Nstudent());
		System.out.print("new Researcher() ->\t"); print(new Researcher());	
		System.out.print("new Professor() ->\t"); print(new Professor());
	}

}
