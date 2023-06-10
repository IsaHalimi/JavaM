package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import game.Game;

public class DataHandler {
	
	// Lädt den Highscore aus einer Datei und setzt den entsprechenden Wert im Spiel
	public static void load() {
		File file = new File("rsc/data/save.txt");
		
		try {
			Scanner sc = new Scanner(file);
			// Setzt den Highscore auf den in der Datei gefundenen Wert
			Game.highscore = sc.nextInt();
			sc.close();
			
		} catch (FileNotFoundException e) {
			// Falls die Datei nicht gefunden wird, wird der Stacktrace ausgegeben
			e.printStackTrace();
		}
	}
	
	// Speichert den aktuellen Highscore in einer Datei
	public static void save() {
		File file = new File("rsc/data/save.txt");
		
		try {
			OutputStream stream = new FileOutputStream(file);
			try {
				// Schreibt den aktuellen Highscore in die Datei
				stream.write(Integer.toString(Game.highscore).getBytes());
				stream.close();
				
			} catch (IOException e) {
				// Falls ein Fehler beim Schreiben der Datei auftritt, wird der Stacktrace ausgegeben
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// Falls die Datei nicht gefunden wird, wird der Stacktrace ausgegeben
			e.printStackTrace();
		}
	}
}
