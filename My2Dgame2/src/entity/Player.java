package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import maintest.GamePanel;
import maintest.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	int x_move = 0;
	int y_move = 0;
	int move = 0;
	int move_amont = 5;
	
    boolean isMoving = false;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		x = 0; // x좌표
		y = 0; // y좌표
		speed = 1; //
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/pxArt (1).png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/pxArt (1).png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/pxArt (1).png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/pxArt (1).png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(!isMoving) {
			
			if(keyH.upPressed == true || keyH.downPressed == true || 
					keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true || keyH.escPressed == true) {
				
				
				if(keyH.upPressed == true) {
					direction = "up";
					y -= speed *32;
					y_move--;
					move++;
				}
				else if(keyH.downPressed == true) {
					direction = "down";
					y += speed *32;
					y_move++;
					move++;
				}
				else if(keyH.leftPressed == true) {
					direction = "left";
					x -= speed *32;
					x_move--;
					move++;
				}
				else if(keyH.rightPressed == true) {
					direction = "right";
					x += speed *32;
					x_move++;
					move++;
				}
				
				spriteCounter++;
				if(spriteCounter > 5) {
					if(spriteNum == 1) {
						spriteNum = 2;
					}
					else if (spriteNum == 2) {
						spriteNum = 1;
					}
					spriteCounter = 0;
				}
				
				if(move > move_amont) {
					
					isMoving = true;
		        }
					

			}
				
			
		} else {
			if(keyH.enterPressed) {
                // 'enter' 키가 눌리면 이동을 확정
                move = 0;
                x_move = 0;
                y_move = 0;
                isMoving = false;
            } 
            else if(keyH.escPressed) {
                // 'esc' 키가 눌리면 이동을 취소하고 원래 위치로 돌아감
                x -= x_move * 32;
                y -= y_move * 32;
                
                x_move = 0;
                y_move = 0;
                move = 0;
                isMoving = false;
            }
		}
				
	}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image =  up1;
				break;
			}
			if(spriteNum == 2) {
				image =  up2;
				break;
			}
		case "down":
			if(spriteNum == 1) {
				image =  down1;
				break;
			}
			if(spriteNum == 2) {
				image =  down2;
				break;
			}
		case "left":
			if(spriteNum == 1) {
				image =  left1;
				break;
			}
			if(spriteNum == 2) {
				image =  left2;
				break;
			}
		case "right":
			if(spriteNum == 1) {
				image =  right1;
				break;
			}
			if(spriteNum == 2) {
				image =  right2;
				break;
			}		
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}

}
