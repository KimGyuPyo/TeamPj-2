package app;

// input x
// output x

// InheritanceEx에서 사용하기 위한 class로 NewStudent의 superclass이다
// private, (defalut). protected, public 각각의 access control를 알아보기 위한 예제이다.


public class Person {
	private int weight; // private class내의 member만 접근이 가능하며 subclass,package에 무관하다
	int age; // (default) 같은 package 내 모든 class가 접근 가능하다. 다른 package의 subclass는 안된다.
	protected int height;  // protected 같은 package 내 모든 class가 접근 가능하며 다른 package의 subclass에서도 접근이 가능하다
	public String name; // class면 다 된다.

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
}
