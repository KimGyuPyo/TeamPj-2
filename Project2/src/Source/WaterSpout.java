package Source;

import javax.swing.*;
import java.awt.*;

public class WaterSpout {
    
	private int SpoutX;
    private int SpoutY;
    
    private ImageIcon SpoutImage;

    // 생성자 : 10x10 그리드에 무작위 위치로 소환
    public WaterSpout() {
        String SpoutImagePath1 = "./Navy/Spout.jpg";  // 용오름 이미지 경로 설정
        
        ImageIcon originalImageIcon1 = new ImageIcon(SpoutImagePath1);  // 이미지 불러오기
        
        Image img = originalImageIcon1.getImage();  
        Image scaledImage1 = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 크기 조정
        SpoutImage = new ImageIcon(scaledImage1);  // 크기 조정된 이미지로 새로운 ImageIcon 생성
        
        this.SpoutX = (int)(Math.random() * 10);  // 0~9 사이의 랜덤값
        this.SpoutY = (int)(Math.random() * 10);  
    }
    
    public int getSpoutX() {
        return SpoutX;
    }

    public int getSpoutY() {
        return SpoutY;
    }

    // 용오름을 그리드에 배치하는 메서드
    public void placeSpout(JButton[][] gridButtons, Navy navy) {		// 용오름 첫 위치 정할때 해군과 안겹치게
    	
        while ((SpoutX == navy.getNavyX() && SpoutY == navy.getNavyY()) || (SpoutX == navy.getNavyX() && SpoutY == navy.getNavyY() + 1)
        		|| (SpoutX == navy.getNavyX() && SpoutY == navy.getNavyY() - 1)) {		// 해군 이동반경에 용오름 안생성되도록
        	SpoutX = (int)(Math.random() * 10);
            SpoutY = (int)(Math.random() * 10);
        }

        gridButtons[SpoutX][SpoutY].setIcon(SpoutImage);  
        gridButtons[SpoutX][SpoutY].revalidate();
        gridButtons[SpoutX][SpoutY].repaint();
    }

    // 용오름과 사용자가 만났을 때 처리하는 메서드
    public void setLocation(JButton[][] gridButtons, Navy navy, int userX, int userY, JLabel characterLabel) {

        if (SpoutX == userX && SpoutY == userY) {
        	
        	gridButtons[userX][userY].removeAll();
            gridButtons[userX][userY].revalidate();
            gridButtons[userX][userY].repaint();


            userX = (int)(Math.random() * 10);
            userY = (int)(Math.random() * 10);


            while (userX == navy.getNavyX() && userY == navy.getNavyY()) {
                userX = (int)(Math.random() * 10);
                userY = (int)(Math.random() * 10);
            }


            gridButtons[userX][userY].add(characterLabel, BorderLayout.CENTER);
            gridButtons[userX][userY].revalidate();
            gridButtons[userX][userY].repaint();
            
            // 용오름도 맵 내에서 랜덤한 위치로 이동 (해군과 겹치지 않도록)
            
            gridButtons[SpoutX][SpoutY].setIcon(null);
            gridButtons[SpoutX][SpoutY].revalidate();
            gridButtons[SpoutX][SpoutY].repaint();
            
            
            SpoutX = (int)(Math.random() * 10);
            SpoutY = (int)(Math.random() * 10);

            while ((SpoutX == navy.getNavyX() && SpoutY == navy.getNavyY()) || (SpoutX == navy.getNavyX() && SpoutY == navy.getNavyY() + 1)
            		|| (SpoutX == navy.getNavyX() && SpoutY == navy.getNavyY() - 1)) {		// 해군 이동반경에 용오름 안생성되도록
            	SpoutX = (int)(Math.random() * 10);
                SpoutY = (int)(Math.random() * 10);
            }

            // 용오름 새 위치로 갱신
            gridButtons[SpoutX][SpoutY].setIcon(SpoutImage);  
            gridButtons[SpoutX][SpoutY].revalidate();
            gridButtons[SpoutX][SpoutY].repaint();
            
            Grid.setcurrenX(userX);
            Grid.setcurrenY(userY);
        }
    }
}
