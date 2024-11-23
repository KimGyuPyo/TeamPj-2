package Source;
// 늪 : 다음에 2칸만 이동 : 자원, 이동 자세히 안정해져서 아직 미구현

public class Swamp {
	
	private int SwampX;
	private int SwampY;
	
	public void Swamp() {		// 10 * 10 gird 무작위 위치에 소환
		this.SwampX = (int)(Math.random()*10);
		this.SwampY = (int)(Math.random()*10);
	}
}
