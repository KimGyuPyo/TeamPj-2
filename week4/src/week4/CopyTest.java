package week4;

import java.util.Arrays;

public class CopyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1, 2, 3};
		int b[] = a.clone();		// 메모리 주소 a, b 다르게 출력 -> Deep copy
		
		System.out.println("array a : " + a);		// System.out.println(Array) -> 배열의 메모리 주소값 출력
		System.out.println("array b : " + b);
		
		System.out.println();
		
		//---------------------------------------
		
		int aa[] = {1, 2, 3};
		int bb[] = Arrays.copyOf(aa, aa.length);	// 메모리 주소 a, b 다르게 출력 -> Deep copy
		
		System.out.println("array aa : " + aa);
		System.out.println("array bb : " + bb);
		
		System.out.println();
		
		//--------------------------------------
		
		int aaa[] = {1, 2, 3};
		int bbb[] = new int[aaa.length];	// 메모리 주소 a, b 다르게 출력 -> Deep copy
		
		System.arraycopy(aaa, 0, bbb, 0, aaa.length);
		
		System.out.println("array aaa : " + aaa);
		System.out.println("array bbb : " + bbb);
		
		System.out.println();
		
		//--------------------------------------
		
		int aaaa[] = {1, 2, 3};
		int bbbb[] = aaaa;		// 메모리 주소 a, b 동일하게 출력 -> Shallow copy
		
		System.out.println("array aaaa : " + aaaa);
		System.out.println("array bbbb : " + bbbb);
		
		System.out.println();
		
		//--------------------------------------

	}

}
// 				[input] 					[output]
//
//     		 a = {1, 2, 3}				a : [I@1f32e575			서로 다른 값 출력 (Deep)
//		     b = a.clone()				b : [I@1be6f5c3
//
//			aa = {1, 2, 3}				aa : [I@6b884d57		서로 다른 값 출력 (Deep)
//	bb = Arrays.copyOf(aa, aa.length)   bb : [I@38af3868
//
// 		   aaa = {1, 2, 3}				aaa : [I@77459877		서로 다른 값 출력 (Deep)
//     bbb = new int[aaa.length]		bbb : [I@5b2133b1
//
//		  aaaa = {1, 2, 3}				aaaa : [I@72ea2f77		서로 같은 값 출력 (Shallow)
//          bbbb = aaaa				    bbbb : [I@72ea2f77
//
//

// Shallow copy : reference 위치만 copy
// Deep copy : 복사본으로 새 객체를 생성
// 차이점 -> Shallow : 원본과 복사본이 같은 공간 가르켜 복사본 update -> 원본에 영향줌
//		   Deep : 독립적인 복사본을 가지므로, 복사본 update -> 원본에 반영 X
