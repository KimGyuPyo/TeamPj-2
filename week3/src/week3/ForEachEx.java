/*
 * for-each 를 사용한 코드
 * 
 * for(type variableName : arrayName) 
 *     자료형    변수명    반복문을 돌릴 배열 이름
 *     
 * 루프가 한번 돌 때 마다 변수가 다음 배열 요소 값으로 설정된다. 
 * 
 * ex) 1 2 3 4 5  -> 합은 15
 *     사과 배 바나나 체리 딸기 포도 
 *     월요일 화요일 수요일 목요일 금요일 토요일 일요일 
 */

package week3;

public class ForEachEx {
	
	enum Week{월, 화, 수, 목, 금, 토, 일}
	
	public static void main(String[] args) {
		
		int n[] = {1, 2, 3, 4, 5};
		String names[] = {"사과", "배", "바나나", "체리", "딸기", "포도"};
		
		int sum = 0;
		for(int k : n) {	// 길이 5인 int형 배열로 for-each 문 작성
			System.out.print(k + " ");
			sum += k;
		}	// 한번 돌 때마다 n[0] -> n[1] -> n[2] -> ... 순으로 설정
		System.out.println(" -> 합은 " + sum);
		
		for (String s : names) {	// 길이 7인 string형 배열로 for-each 
			System.out.print(s + " ");
		}	// 한번 돌 때마다 names[0] -> names[1] -> names[2] -> ... 순으로 설정
		System.out.println();
		
		for(Week day : Week.values()) {	// enum으로 for-each
			System.out.print(day + "요일 ");
		}	// 한번 돌 때마다 index number 0 -> 1 -> 2 -> ... 순으로 상수값 출력
		System.out.println();
	}
}
