package maintest;

import javax.swing.JFrame;

public class GameRule {
	
    public void gameRule() {		// 게임 방법 창 띄움
    	
    	JFrame gamerule = new JFrame("게임방법");
    	gamerule.setSize(600, 800);
    	gamerule.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	gamerule.setResizable(false);
    	gamerule.setLocation(500, 100);
    	
    	gamerule.setVisible(true);
    }
}
