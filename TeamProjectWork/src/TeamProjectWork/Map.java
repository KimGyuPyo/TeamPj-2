package TeamProjectWork;

import java.util.*;
import java.io.*;
import TeamProjectWork.Tile;

public class Map {
	
	Tile tile[][] = new Tile[40][40];
	
	public void ImportMap(String FilePath) {
		try {
			FileReader fr = new FileReader(FilePath);
			BufferedReader br = new BufferedReader(fr);
			
			int cint;
			int i = 0, j = 0;
			
			while((cint = br.read()) != -1) {
				char c = (char) cint;
				
				if(c == '\t') {
					j++;
				} 
				else if (c == '\r') {
					continue;
				} 
				else if (c == '\n') {
					i++;
					j = 0;
				} 
				else {
					tile[i][j] = new Tile(c);
				}
			}
			
			br.close();
			
			System.out.println("Map imported.");
		}
		catch (IOException e) {
			System.out.println("Failed to import map. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void PrintMap() {
		if (tile == null) {
			System.out.println("Map is not imported. Import map first.");
			return ;
		}
		
		for(int i = 0; i < 40; i++) {
			for(int j = 0; j < 40; j++) {
				System.out.print(tile[i][j].TileType + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String arg[]) {
		Map map = new Map();
		
		String FilePath = "C:\\Jungwoo\\Map.txt";
		
		map.ImportMap(FilePath);
		
		map.PrintMap();
	}
}
