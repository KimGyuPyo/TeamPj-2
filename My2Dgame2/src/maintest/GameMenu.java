package maintest;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class GameMenu {
	
    public void musicvol() {

    	JFrame soundFrame = new JFrame("음향 설정");
        soundFrame.setSize(400, 150);
        soundFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        soundFrame.setLocationRelativeTo(null);  
        soundFrame.setLayout(new BorderLayout());

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(10);  // 큰 눈금 간격
        slider.setPaintTicks(true);      // 눈금 표시
        slider.setPaintLabels(true);    // 레이블 표시

 
        JLabel volumeLabel = new JLabel("볼륨: 50", JLabel.CENTER);
        volumeLabel.setFont(new Font("Serief", Font.BOLD, 20));

 
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int volume = slider.getValue();  // 슬라이더의 값 가져오기
                volumeLabel.setText("볼륨: " + volume);  // 레이블에 표시
                // 여기에 실제 음향 설정 로직 추가 가능
            }
        });

        soundFrame.add(slider, BorderLayout.CENTER);
        soundFrame.add(volumeLabel, BorderLayout.NORTH);

        soundFrame.setVisible(true);
    }
	
    public void createMenu(JFrame jframe, JFrame gameframe) {
    	JMenuBar menuBar = new JMenuBar();
    	
    	Font mFont = new Font("SansSerif", Font.BOLD, 20);
    	
    	JMenu setmenu = new JMenu("설정");
    	setmenu.setFont(mFont);
    	
    	JMenuItem vol = new JMenuItem("음향");
    	vol.addActionListener(e -> {
    		musicvol();
    	});
    	setmenu.add(vol);
    	setmenu.addSeparator();
    	
    	JMenuItem vol1 = new JMenuItem("뭐넣어야할까");
    	setmenu.add(vol1);

    	
    	JMenu rulemenu = new JMenu("도움말");
    	rulemenu.setFont(mFont);
    	
    	JMenuItem rule = new JMenuItem("게임방법");
    	rule.addActionListener(e -> {
    		GameRule G = new GameRule();
    		G.gameRule();
    	});
    	rulemenu.add(rule);

    	
    	
    	JMenu gomenu = new JMenu("나가기");
    	gomenu.setFont(mFont);
    	
    	
    	JMenuItem gom = new JMenuItem("시작메뉴");
    	gom.addActionListener(e -> {
    		
    		jframe.dispose();
    		gameframe.dispose();
    		new StartWindow();
    		
    	});
    	gomenu.add(gom);
    	
    	JMenuItem exit = new JMenuItem("게임종료");
    	exit.addActionListener(e -> {
    		System.exit(0);
    	});
    	gomenu.add(exit);
    	
    	
    		
    	menuBar.add(setmenu);
    	menuBar.add(rulemenu);
    	menuBar.add(gomenu);
    	
        jframe.setJMenuBar(menuBar);
    }
}
