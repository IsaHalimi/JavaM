package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import game.Game;
import game.GameState;

public class DrawMenu extends JLabel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Prüft den aktuellen Spielstatus und zeichnet das entsprechende Menü.
		if (Game.gamestate == GameState.start) {
			// Zeichnet das Startmenü
			g.setColor(new Color(24, 70, 145));
			g.fillRect(0, Gui.height / 2 - 50, Gui.width+200, 100);
			g.setColor(Color.WHITE);
			g.setFont(Gui.pixelfont.deriveFont(14f));
			g.drawString("PRESS ENTER TO START", Gui.width/2, Gui.height / 2 +10);
		} else if(Game.gamestate == GameState.pause) {
			// Zeichnet das Pausenmenü
			g.setColor(new Color(100, 100, 100));
			g.fillRect(0, Gui.height / 2 - 50, Gui.width+200, 100);
			g.setColor(Color.WHITE);
			g.setFont(Gui.pixelfont.deriveFont(14f));
			g.drawString("PRESS ESC TO CONTINUE", Gui.width/2 -10, Gui.height / 2 +10);
		} else if(Game.gamestate == GameState.gameover){
			// Zeichnet das Game-Over-Menü
			g.setColor(new Color(175, 28, 28));
			g.fillRect(0, Gui.height / 2 - 50, Gui.width+200, 100);
			g.setColor(Color.WHITE);
			g.setFont(Gui.pixelfont.deriveFont(14f));
			g.drawString("YOU LOST. PRESS ENTER TO START AGAIN", 75, Gui.height / 2 +10);
		}

		// Fordert eine Neumalung des Fensters an
		repaint();
		
	}

}
