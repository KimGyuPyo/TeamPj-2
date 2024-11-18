package app;

// input x
// output x

// Person이 superclass인 subclass NewStudent class이다 
// 같은 package이기에  age(default), height(protected) 는 접근이 가능하고
// name은 public 이라 class인 이상 조건을 타지 않는다
// Weight의 경우 private라 superclass 내부의 메소드를 이용하여 member에 접근하였다.

public class Newstudent extends Person {
	public void set() {
		age = 24;
		height = 174;
		name = "김만휘";
		setWeight(60);
	}

}
