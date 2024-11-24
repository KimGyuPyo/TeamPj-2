package maintest;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameWindow2 {
	
	private int resource;
    private int turn;
    private int score;
    
    private JFrame jf1;
    
    public void setwin1jf(JFrame gameWindow1) {
    	this.jf1 = gameWindow1;
    }
    
    public void setresource(int resource) {
    	this.resource = resource;
    }
    
    public void setturn(int turn) {
    	this.turn = turn;
    }
    
    public void setscore(int score) {
    	this.score = score;
    }
	
    public void gameWindow2() {
    	
        JFrame gameWindow2 = new JFrame("창2");
        gameWindow2.setSize(400, 1000);  // 게임 창 크기
        gameWindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 게임 창 닫기
        gameWindow2.setResizable(false); 
        gameWindow2.setLocation(1200, 0);
        
        Container c = gameWindow2.getContentPane();
        c.setLayout(null);
        
        
        GameMenu M = new GameMenu();
        M.createMenu(gameWindow2, jf1);

        
        JLabel Resource = new JLabel("자원 : " + resource);
        Resource.setFont(new Font("Serief", Font.BOLD, 25));
        Resource.setBounds(140, 50, 200, 100);
        c.add(Resource);
        
        JLabel Turn = new JLabel("턴 : " + turn);
        Turn.setFont(new Font("Serief", Font.BOLD, 25));
        Turn.setBounds(140, 150, 200, 100);
        c.add(Turn);
        
        JLabel Item = new JLabel("아이템");
        Item.setFont(new Font("Serief", Font.BOLD, 25));
        Item.setBounds(140, 250, 200, 100);
        c.add(Item);
        
        JLabel Score = new JLabel("점수 : " + score);
        Score.setFont(new Font("Serief", Font.BOLD, 25));
        Score.setBounds(140, 800, 200, 100);
        c.add(Score);
        
        // 첫 번째 게임 창 보이기
        gameWindow2.setVisible(true);
    }
}
