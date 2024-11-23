package Source;
// 비밀상자 : 섬에 위치

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SecretBox {
	private int boxX, boxY;
	private boolean boxOpen = false;
	private String contents;
	
	private ImageIcon BoxImage;
	private ImageIcon OpenBoxImage;
	
	public SecretBox() {
		String SpoutImagePath3 = "./Navy/Box.jpg";  // 용오름 이미지 경로 설정
        
        ImageIcon originalImageIcon3 = new ImageIcon(SpoutImagePath3);  // 이미지 불러오기
        
        Image img = originalImageIcon3.getImage();  
        Image scaledImage3 = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 크기 조정
        BoxImage = new ImageIcon(scaledImage3);  // 크기 조정된 이미지로 새로운 ImageIcon 생성
        
		String[] items = {"자원 증가", "자원 차감", "해군 피해가기"};
		this.contents = items[(int)(Math.random() * 3)];		// 3개중 랜덤하게 하나 들어있음
		
		OpenBox();
	}
	
	public void placeBox(JButton[][] gridButtons, int x, int y) {		// 섬 좌표 입력받아서 비밀상자 좌표 설정
		        
		this.boxX = x;
		this.boxY = y;
		
	    gridButtons[boxX][boxY].setIcon(BoxImage);  // 이미지 설정
	    gridButtons[boxX][boxY].revalidate();
	    gridButtons[boxX][boxY].repaint();
		
	}
	
	public void OpenBox() {	
		
		String SpoutImagePath4 = "./Navy/OpenBox.jpg";  
        
        ImageIcon originalImageIcon4 = new ImageIcon(SpoutImagePath4);  // 이미지 불러오기
        
        Image img = originalImageIcon4.getImage();  
        Image scaledImage4 = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 크기 조정
        OpenBoxImage = new ImageIcon(scaledImage4);  // 크기 조정된 이미지로 새로운 ImageIcon 생성

	}
	
    public int getBoxX() {
        return boxX;
    }

    public int getBoxY() {
        return boxY;
    }

    
    public String openBox(JButton[][] gridButtons, int userX, int userY) {
  	
    	if (boxX == userX && boxY == userY) {		
    		
    		if(gridButtons[boxX][boxY].getIcon().equals(OpenBoxImage)) {
    			
    			/*
    			gridButtons[boxX][boxY].setIcon(null); 		// 열린 상자 방문시 닫힌상자 소환 원하면 이거 사용하기
        		gridButtons[boxX][boxY].revalidate();
        		gridButtons[boxX][boxY].repaint();
            	
        		gridButtons[boxX][boxY].setIcon(BoxImage); 
        		gridButtons[boxX][boxY].revalidate();
        		gridButtons[boxX][boxY].repaint();
        		*/
        		
        		
        		return null;		// 열린 상자 다시 방문할경우, 아무것도 반환 x(안열림)
    		}
    		
    		else {
    			
    			gridButtons[boxX][boxY].setIcon(null); 
        		gridButtons[boxX][boxY].revalidate();
        		gridButtons[boxX][boxY].repaint();
            	
        		gridButtons[boxX][boxY].setIcon(OpenBoxImage); 
        		gridButtons[boxX][boxY].revalidate();
        		gridButtons[boxX][boxY].repaint();
        		
        		return contents;
    		}
    		
    	}
    	return null;
    }
}
