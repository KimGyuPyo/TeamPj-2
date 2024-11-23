package Source;

import javax.swing.*;
import java.awt.*;

public class Navy {		// 기본 해군
	
	private int NavyX;
	private int NavyY;
	
	private static int[] movelist = {-1, 1, 1, -1};  // 예시: 좌, 우, 우, 좌 순서로 이동
	
	private int movelistindex = 0;
	
	private ImageIcon navyImage;
	
	public Navy() {		// 10*10 grid 무작위 좌표에 소환
		
		String navyImagePath = "./Navy/Navy.jpg";  // 해군 이미지 경로 설정
		ImageIcon originalImageIcon = new ImageIcon(navyImagePath);  // 이미지 불러오기
        
        Image img = originalImageIcon.getImage();  
        Image scaledImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 50x50 크기로 조정
        navyImage = new ImageIcon(scaledImage);  // 크기 조정된 이미지로 새로운 ImageIcon 생성
        
        
		this.NavyX = (int)(Math.random()*10);
		this.NavyY = (int)(Math.random()*10);
	}
	
	public int getNavyX() {		// 해군 x 좌표
		return NavyX;
	}
	
	public int getNavyY() {		// 해군 y 좌표
		return NavyY;
	}
	
	public void setNavyX(int x) {
		this.NavyX = x;
	}
	
	public void setNavyY(int y) {
		this.NavyY = y;
	}
	
	public void placeNavy(JButton[][] gridButtons) {
		
		if(NavyY > 9) {
			NavyY = 9;
			movelistindex+=2;		// 해군 움직이는 범위가 맵 벗어나는 경우 처리(좌 우 우 좌 에서 3번째 우 에서 grid 넘을 경우 4 좌 생략하고 1좌 시작)
		}
		
		if(NavyY < 1) {
			NavyY = 1;
			movelistindex+=2;
		}
		
	    gridButtons[NavyX][NavyY].setIcon(navyImage);  // 이미지 설정
	    gridButtons[NavyX][NavyY].revalidate();
	    gridButtons[NavyX][NavyY].repaint();
	}
	
	public void deleteNavy(JButton[][] gridButtons) {
		gridButtons[NavyX][NavyY].setIcon(null);
        gridButtons[NavyX][NavyY].revalidate();
        gridButtons[NavyX][NavyY].repaint();
	}
	
	public void moveNavy(JButton[][] gridButtons) {
        int newY = NavyY;
        
        deleteNavy(gridButtons);

        newY += movelist[movelistindex % 4];
        movelistindex++;

        // 해군의 위치 변경
        NavyY = newY;
        placeNavy(gridButtons);  // 해군 이동 후 그리드에 배치
      
    }
	
	
	public int rolldice() {		// 주사위 굴리기
		return (int)(Math.random()*6 + 1);
	}
	
	public String battle() {		// 사용자와 만나면 battle
		
		int UserDice = rolldice();
		int NavyDice = rolldice();
		
		while(true) {
			if(UserDice > NavyDice) {
				return "win";
			}
			if(UserDice < NavyDice) {
				return "lose";
			}
			UserDice = rolldice();		// 무승부면 다시 굴리기
			NavyDice = rolldice();
		}
	}
	
	public void checkMeet(int x, int y, int firstX, int firstY, JButton[][] gridButtons, JLabel characterLabel) {		// 만나면 초기화~
		if (x == NavyX && y == NavyY) {
			gridButtons[x][y].removeAll();
            gridButtons[x][y].revalidate();
            gridButtons[x][y].repaint();
            
            gridButtons[firstX][firstY].add(characterLabel, BorderLayout.CENTER);
            gridButtons[firstX][firstY].revalidate();
            gridButtons[firstX][firstY].repaint();
            
            Grid.setcurrenX(firstX);
            Grid.setcurrenY(firstY);
		}
	}
}