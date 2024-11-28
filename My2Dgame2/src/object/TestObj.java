package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class TestObj extends SuperObject{
	
	public TestObj() {
		
		name = "obj";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/obj.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
