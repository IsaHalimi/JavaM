package infrastructure;

import java.awt.FontFormatException;
import java.io.IOException;

import game.Block;
import game.Game;
import io.DataHandler;
import ui.Gui;

public class Main {
	
    // Die Main-Methode - Einstiegspunkt der Anwendung.
	public static void main(String[] args) {
		
		// Lade vorhandene Daten aus Dateien.
		DataHandler.load();
	
		// Erstelle den aktuellen Block im Spiel und füge ihn zur Liste der Blöcke hinzu.
		Game.currentBlock = new Block();
		Game.blocks.add(Game.currentBlock);

        // Erstelle den nächsten Block im Spiel.
		Game.nextBlock = new Block();
		
		try {
            // Erstelle das Hauptfenster der Anwendung.
			Gui g = new Gui();
			g.create();
		} catch (FontFormatException | IOException e) {
            // Fehlerbehandlung, falls das Erstellen der GUI fehlschlägt.
			System.out.println("Failed to create GUI.");
			e.printStackTrace();
		}
		
        // Starte die Hauptschleife des Spiels.
		startLoop();
		
	}
	
    // Die Methode, um die Spielschleife zu starten.
	public static void startLoop() {
		GameLoop loop = new GameLoop();
		loop.start();
	}

}
