package TeamProjectWork;

public class Tile {
	
	public char TileType;
	public int TileCost;
	public boolean IsPirate = false;
	public boolean IsMarine = false;
	public boolean IsTreasure = false;
	
	public Tile() {}
	
	public Tile(char TileType) {
		this.TileType = TileType;
		
		if (TileType == 's') TileCost = 1;
		else if (TileType == 'i') TileCost = 0;
		else if (TileType == 'g') TileCost = -1;
		else if (TileType == 'p') {
			TileCost = 1;
			IsPirate = true;
		}
		else if (TileType == 'm') {
			TileCost = 1;
			IsMarine = true;
		}
		else if (TileType == 'c'){
			TileCost = 0;
		}
		else {
			TileCost = 0;
			IsTreasure = true;
		}
	}
}