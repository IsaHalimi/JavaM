package ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import io.KeyHandler;

public class Gui {

	// Definiert die Größe des Fensters
	public static int width = 320, height = 576;
	JFrame jf; // Die Hauptkomponente des Fensters
	
	public static Font pixelfont; // Die Schriftart, die im Spiel verwendet wird

	// Methode zur Erstellung des Spielfensters
	public void create() throws FontFormatException, IOException {

		jf = new JFrame("Tetris"); // Erstellt das Fenster und benennt es "Tetris"
		jf.setSize(width + 17 + 200, height + 41); // Legt die Größe des Fensters fest
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Legt fest, dass das Programm beim Schließen des Fensters beendet wird
		jf.setLocationRelativeTo(null); // Zentriert das Fenster auf dem Bildschirm
		jf.setResizable(false); // Verhindert, dass das Fenster skaliert wird
		jf.setLayout(null); // Verwendet kein Layout, sodass Komponenten manuell positioniert werden können
		jf.addKeyListener(new KeyHandler()); // Fügt einen KeyListener hinzu, der Tastendrücke verarbeitet
		jf.requestFocus(); // Fordert den Fokus für das Fenster an, sodass Tasteneingaben registriert werden
		
		// Lädt eine spezielle Schriftart aus einer Datei
		pixelfont = Font.createFont(Font.TRUETYPE_FONT, new File("rsc/fonts/FFFFORWA.TTF")).deriveFont(12f);

		// Erstellt die Komponenten, die das Spiel, das Interface und das Menü zeichnen
		DrawMenu dm = new DrawMenu();
		setupDraw(dm, 0, 0, width +200, height);
		
		DrawGame dg = new DrawGame();
		setupDraw(dg, 0, 1, width + 1, height + 1);

		DrawInterface di = new DrawInterface();
		setupDraw(di, width + 1, 1, width, height);
		
		// Macht das Fenster sichtbar
		jf.setVisible(true);
	}

	// Hilfsmethode zur Einrichtung einer Komponente, die etwas zeichnet
	private void setupDraw(JLabel draw, int x, int y, int width, int height) {
		draw.setBounds(x, y, width, height); // Setzt die Position und Größe der Komponente
		draw.setVisible(true); // Macht die Komponente sichtbar
		jf.add(draw); // Fügt die Komponente dem Fenster hinzu
	}
}
