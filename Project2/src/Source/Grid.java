package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid {
    // 그리드 크기
    private static final int GRID_SIZE = 10;
    
    // 캐릭터의 현재 위치
    private static int currentX =(int)(Math.random() * 10);
    private static int currentY = (int)(Math.random() * 10);
    
    // 시작점 저장
    private static int startX = currentX;
    private static int startY = currentY;
    
    private static Navy navy = new Navy();
    private static WaterSpout waterSpout = new WaterSpout();
    private static SecretBox box = new SecretBox();
    
    private static JLabel characterLabel = new JLabel("O", JLabel.CENTER);
    
    public static int getcurrenX() {
    	return currentX;
    }
    
    public static int getcurrenY() {
    	return currentY;
    }
    
    public static void setcurrenX(int x) {
    	currentX = x;
    }
    
    public static void setcurrenY(int y) {
    	currentY = y;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // JFrame 설정
                JFrame frame = new JFrame("Grid with Movable Character");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
                JButton[][] gridButtons = new JButton[GRID_SIZE][GRID_SIZE];
                JLabel characterLabel = new JLabel("O", JLabel.CENTER);
                characterLabel.setFont(new Font("Arial", Font.BOLD, 30)); // 캐릭터 크기 설정

                // 그리드 버튼 생성
                for (int i = 0; i < GRID_SIZE; i++) {
                    for (int j = 0; j < GRID_SIZE; j++) {
                        gridButtons[i][j] = new JButton();
                        gridButtons[i][j].setPreferredSize(new Dimension(50, 50)); // 버튼 크기 설정
                        gridButtons[i][j].setLayout(new BorderLayout());  // 버튼에 레이아웃 설정 (필수)

                        final int x = i, y = j;
                        
                        // 버튼 클릭 시 캐릭터 이동
                        gridButtons[i][j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                moveCharacter(x, y, characterLabel, gridButtons);
                                
                            }
                        });
                        frame.add(gridButtons[i][j]);
                    }
                }

                // 초기 캐릭터 배치
                startCharacter(characterLabel, gridButtons);
                
                navy.placeNavy(gridButtons);
                
                waterSpout.placeSpout(gridButtons, navy);
                
                box.placeBox(gridButtons, 1, 1);

                // 프레임 크기 및 표시
                frame.setSize(600, 600);
                frame.setVisible(true);
            }
        });
    }		// 캐릭터 시작
    private static void startCharacter(JLabel characterLabel, JButton[][] gridButtons) {
    	gridButtons[currentX][currentY].add(characterLabel, BorderLayout.CENTER);
    }
    
    // 캐릭터 이동 메서드
    private static void moveCharacter(int x, int y, JLabel characterLabel, JButton[][] gridButtons) {
        // 이동하려는 위치가 현재 위치와 상하좌우 인접한 칸인지 확인
        if ((Math.abs(currentX - x) == 1 && currentY == y) || (Math.abs(currentY - y) == 1 && currentX == x)) {
            // 이전 위치 버튼을 비워줌
            gridButtons[currentX][currentY].removeAll();
            gridButtons[currentX][currentY].revalidate();
            gridButtons[currentX][currentY].repaint();
            
            // 새로운 위치로 캐릭터 이동
            currentX = x;
            currentY = y;

            // 이동된 버튼에 캐릭터 추가
            gridButtons[currentX][currentY].add(characterLabel, BorderLayout.CENTER);  // JLabel을 버튼의 중앙에 추가
            gridButtons[currentX][currentY].revalidate();
            gridButtons[currentX][currentY].repaint();
            
            moveNavy(gridButtons);		// 캐릭터 움직일때 해군도 같이 움직임~
            
            navy.checkMeet(currentX, currentY, startX, startY, gridButtons, characterLabel);	// 움직일때마다 만났는지 확인. 만났으면 처음위치로~
            
            waterSpout.setLocation(gridButtons, navy, currentX, currentY, characterLabel);		// 움직일때마다 만났는지 확인. 만났으면 랜덤위치로~
            
            box.openBox(gridButtons, currentX, currentY);
        }
    }
    
    private static void moveNavy(JButton[][] gridButtons) {

        // 해군의 이동
        navy.moveNavy(gridButtons);

        // 이동된 해군 배치
        navy.placeNavy(gridButtons);
    }
    
}

