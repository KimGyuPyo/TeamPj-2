package maintest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartWindow extends JFrame {
	
	public int resource = 300;		// 시작 자원/턴 300, 100이라 둠
	public int turn = 100;			// 다른 클래스에서도 접근 가능하도록
	public int score = 0;
	

    public StartWindow() {

        setTitle("붕어방 해적단");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLayeredPane layeredPane = new JLayeredPane();  // 레이어드 페인 생성
        layeredPane.setLayout(null);

        /*Container c = getContentPane();
        c.setBackground(Color.white);  
        c.setLayout(null);  */
        
        ImageIcon backgroundImage = new ImageIcon("./Image/Ship.jpg");  // 이미지 파일 경로
        Image img = backgroundImage.getImage();
        Image scaledImage = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage1 = new ImageIcon(scaledImage);
        
        JLabel backgroundLabel = new JLabel(backgroundImage1);
        backgroundLabel.setBounds(0,0, 600, 600);  // 이미지 크기 설정
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        /*c.add(backgroundLabel);  // 배경으로 추가*/
        
        JLabel gamename = new JLabel("<html> 붕어방 <br> 해.적.단 </html>");
        gamename.setFont(new Font("Serief", Font.BOLD, 40));
        gamename.setBounds(10, -40, 300, 200);
        layeredPane.add(gamename, Integer.valueOf(1));

        // 각 버튼 생성
        JButton startButton = new JButton("게임시작");
        startButton.setFont(new Font("Serief", Font.BOLD, 25));
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.gray));

        
        startButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	startButton.setBorderPainted(true);
            	startButton.setContentAreaFilled(true);
            	startButton.setBackground(Color.orange);  // 마우스 올렸을 때 색상
            }
            public void mouseExited(MouseEvent e) {
            	startButton.setBorderPainted(false);
            	startButton.setContentAreaFilled(false);  // 마우스 떼었을 때 색상
            }
        });
        
        
        startButton.addActionListener(e -> {
            // 게임 시작 버튼 클릭 시 처리할 코드
            openGameWindows();  // 두 개의 게임 창을 열기
            dispose();  // 기존 창 닫기
        });

        JButton helpButton = new JButton("게임방법");
        helpButton.setFont(new Font("Serief", Font.BOLD, 25));
        helpButton.setForeground(Color.black);
        helpButton.setBorderPainted(false);
        helpButton.setFocusPainted(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorder(BorderFactory.createLineBorder(Color.gray));

        
        
        helpButton.addActionListener(e -> {
            // 게임 방법 버튼 클릭 시 처리할 코드
        	GameRule G1 = new GameRule();
    		G1.gameRule();
        });
        
        helpButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	helpButton.setBorderPainted(true);
            	helpButton.setContentAreaFilled(true);
            	helpButton.setBackground(Color.orange);  // 마우스 올렸을 때 색상
            }
            public void mouseExited(MouseEvent e) {
            	helpButton.setBorderPainted(false);
            	helpButton.setContentAreaFilled(false);  // 마우스 떼었을 때 색상
            }
        });

        
        JButton exitButton = new JButton("종료");
        exitButton.setFont(new Font("Serief", Font.BOLD, 25));
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.gray));
 
        
        exitButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
            	exitButton.setBorderPainted(true);
            	exitButton.setContentAreaFilled(true);
            	exitButton.setBackground(Color.orange);  // 마우스 올렸을 때 색상
            }
            public void mouseExited(MouseEvent e) {
            	exitButton.setBorderPainted(false);
            	exitButton.setContentAreaFilled(false);  // 마우스 떼었을 때 색상
            }
        });
        
        exitButton.addActionListener(e -> {
            // 종료 버튼 클릭 시 애플리케이션 종료
            System.exit(0);
        });

        startButton.setBounds(10, 260, 160, 60);
        helpButton.setBounds(10, 320, 160, 60);
        exitButton.setBounds(10, 380, 160, 60);
        
        layeredPane.add(startButton, Integer.valueOf(1));
        layeredPane.add(helpButton, Integer.valueOf(1));
        layeredPane.add(exitButton, Integer.valueOf(1));
        
        this.setContentPane(layeredPane);
/*
        c.add(startButton);
        c.add(helpButton);
        c.add(exitButton);
*/
        setSize(600, 600);
        setLocationRelativeTo(null);  

        setResizable(false);  

        setVisible(true);  
    }

    // 두 개의 게임 창을 여는 메서드
    private void openGameWindows() {
    	gameWindow1 win1 = new gameWindow1();
    	win1.gameWindow1();
    	
    	gameWindow2 win2 = new gameWindow2();
    	
    	win2.setwin1jf(win1.gameWindow1);		// win1 frame win2로 전달 (win2 메뉴중 '메뉴이동' 시 창 2개다 닫고 메뉴창 띄우기위해)
    	
    	win2.setresource(resource);
    	win2.setturn(turn);
    	win2.setscore(score);
    	
    	win2.gameWindow2();
    	
    }
    /*
    private void gameRule() {		// 게임 방법 창 띄움
    	JFrame gamerule = new JFrame("게임방법");
    	gamerule.setSize(600, 800);
    	gamerule.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	// 다른 클래스처리
    	setResizable(false);
    	gamerule.setLocation(500, 100);
    	
    	gamerule.setVisible(true);
    }
    */

/*
    public void createMenu(JFrame jframe) {
    	JMenuBar menuBar = new JMenuBar();
    	
    	Font mFont = new Font("SansSerif", Font.BOLD, 20);
    	
    	JMenu setmenu = new JMenu("설정");
    	setmenu.setFont(mFont);
    	
    	JMenuItem vol = new JMenuItem("음향");
    	vol.addActionListener(e -> {
    		JOptionPane.showMessageDialog(jframe, "음향 설정을 여는 기능을 구현하세요.");
    	});
    	setmenu.add(vol);
    	setmenu.addSeparator();
    	
    	JMenuItem vol1 = new JMenuItem("뭐넣어야할까");
    	setmenu.add(vol1);

    	
    	JMenu rulemenu = new JMenu("도움말");
    	rulemenu.setFont(mFont);
    	
    	JMenuItem rule = new JMenuItem("게임방법");
    	rule.addActionListener(e -> {
    		GameRule G2 = new GameRule();
    		G2.gameRule();
    	});
    	rulemenu.add(rule);

    	
    	
    	JMenu gomenu = new JMenu("나가기");
    	gomenu.setFont(mFont);
    	
    	
    	JMenuItem gom = new JMenuItem("시작메뉴");
    	gom.addActionListener(e -> {
    		jframe.dispose();
    		new StartWindow();
    	});
    	gomenu.add(gom);
    	
    	JMenuItem exit = new JMenuItem("게임종료");		외부 클래스로 처리
    	exit.addActionListener(e -> {
    		System.exit(0);
    	});
    	gomenu.add(exit);
    	
    	
    		
    	menuBar.add(setmenu);
    	menuBar.add(rulemenu);
    	menuBar.add(gomenu);
    	
        jframe.setJMenuBar(menuBar);
    }
*/    
    


}


