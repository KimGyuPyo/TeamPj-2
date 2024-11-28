package maintest;

import object.TestObj;

public class ObjSetter {
	
	GamePanel gp;
	
	public ObjSetter(GamePanel gp) {
		this.gp = gp;		
	}
	
	public void SetObject() {
		
		gp.obj[0] = new TestObj();
		gp.obj[0].x = 20 * gp.tileSize;
		gp.obj[0].y = 20 * gp.tileSize;
		
		gp.obj[1] = new TestObj();
		gp.obj[1].x = 24 * gp.tileSize;
		gp.obj[1].y = 20 * gp.tileSize;
		gp.obj[1].collision = true;
	}

}
