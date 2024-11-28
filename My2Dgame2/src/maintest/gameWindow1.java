package maintest;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameWindow1 {
	
	protected JFrame gameWindow1;		// 게임 실행 중 게임 메뉴로 돌아가기 누르면 창 2개다 꺼지고 메뉴창 띄울수 있도록 필드로 선언

    public void gameWindow1() {
    	
    	gameWindow1 = new JFrame();
    	gameWindow1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	gameWindow1.setResizable(false);
    	gameWindow1.setTitle("2D Adventure");
    	
    	GamePanel gamePanel = new GamePanel();
    	gameWindow1.add(gamePanel);
    	
    	gameWindow1.pack();
		
    	gameWindow1.setLocationRelativeTo(null);
    	gameWindow1.setVisible(true);
        gameWindow1.setLocation(110, 0);
		
        gamePanel.setupGame();
		gamePanel.startGameThread();
		
    	
/*        // 두 번째 게임 관련 창 생성
        gameWindow1 = new JFrame("창1");
        gameWindow1.setSize(1100, 1000);  // 두 번째 창 크기
        gameWindow1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 두 번째 창 닫기
        gameWindow1.setResizable(false); 
        gameWindow1.setLocation(110, 0);

        // 두 번째 게임 창에 추가할 내용 (예: 레이블)
        JLabel secondLabel = new JLabel("두 번째 게임 관련 창");
        secondLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gameWindow1.add(secondLabel);

        // 두 번째 게임 창 보이기
        gameWindow1.setVisible(true);
        
*/    }
    
}
