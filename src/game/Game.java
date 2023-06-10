package game;

import java.util.ArrayList;

public class Game {
	
	// Spielstand und Punkte, die hinzugefügt werden sollen
	public static int score = 0, highscore = 0, scoreToAdd = 0;

	// Flags für das Spawnen eines neuen Blocks und für das Beschleunigen der Blockbewegung
	public static boolean spawnNewBlock = false, speedup = false;
	
	// Liste der Blöcke und der aktuelle und nächste Block
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static Block currentBlock, nextBlock;
	
	// Die Karte des Spiels
	public static int[][] map = new int[10][18];
	
	// Der aktuelle Zustand des Spiels
	public static GameState gamestate = GameState.start;
	
	// Methode zur Rücksetzung des Spiels
	public static void clear() {
		// Setzt alle Zellen der Karte auf 0
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y] = 0;
			}
		}
		// Setzt den Spielstand auf 0
		score = 0;
	}
	

}
