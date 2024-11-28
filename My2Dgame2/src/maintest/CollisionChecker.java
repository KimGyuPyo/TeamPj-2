package maintest;

import entity.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
		
	}
	
	 boolean indexCheck(int col, int row) {
	        return col >= 0 && col < gp.tileM.mapTileNum.length &&
	               row >= 0 && row < gp.tileM.mapTileNum[0].length;
	 }
	
	public void checkTile(Entity entity) {
		
		int entityLeftX = entity.x + entity.solidArea.x;
		int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
		int entityTopY= entity.y + entity.solidArea.y;
		int entityBottomY= entity.y + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftX/gp.tileSize;
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize;
		int entityBottomRow = entityBottomY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		
		switch (entity.direction) {
        case "up":
            entityTopRow = (entityTopY - 1 - entity.speed) / gp.tileSize;
            if (indexCheck(entityLeftCol, entityTopRow) && indexCheck(entityRightCol, entityTopRow)) {
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            break;
        
        case "down":
            entityBottomRow = (entityBottomY + entity.speed) / gp.tileSize;
            if (indexCheck(entityLeftCol, entityBottomRow) && indexCheck(entityRightCol, entityBottomRow)) {
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            break;
        
        case "left":
            entityLeftCol = (entityLeftX - 1 - entity.speed) / gp.tileSize;
            if (indexCheck(entityLeftCol, entityTopRow) && indexCheck(entityLeftCol, entityBottomRow)) {
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            break;
        
        case "right":
            entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
            if (indexCheck(entityRightCol, entityTopRow) && indexCheck(entityRightCol, entityBottomRow)) {
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            break;
		}
	}
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for(int i = 0; i < gp.obj.length; i++) {
			
			
			if(gp.obj[i] != null) {
				
				entity.solidArea.x = entity.x + entity.solidArea.x;
				entity.solidArea.y = entity.y + entity.solidArea.y;
				
				gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;
	
				//intersects 메서드는 rectangle 안의 함수로 충돌을 판단함 타일에 왜 안썻냐? 하면 오브젝트 같이 개수가 적은거에 쓰는게 맞대서...
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed * gp.tileSize;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed * gp.tileSize;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed * gp.tileSize;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed * gp.tileSize;
					if(entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if(gp.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if(player == true) {
							index = i;
						};
					}
					break;
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				
				gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
				gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;				
			}
		}
		
		return index;
	}
}