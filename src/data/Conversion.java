package data;

public class Conversion {
	
	// Konvertiert Zellenkoordinaten in Pixelkoordinaten.
	// Wir multiplizieren mit 32, da eine Zelle 32 Pixel groß ist.
	public static int cellToCoord(int cell) {	
		return cell * 32;
	}

	// Konvertiert Pixelkoordinaten in Zellenkoordinaten.
	// Wir teilen durch 32, da eine Zelle 32 Pixel groß ist.
	public static int coordToCell(int coord) {	
		return coord / 32;
	}
}
