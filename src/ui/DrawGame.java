package ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

import data.Conversion;
import game.Game;

public class DrawGame extends JLabel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Zeichnet den aktuellen Spielblock auf der GUI
		g.setColor(Game.currentBlock.getColor());
		for (int j = 0; j < Game.currentBlock.getBounds()[Game.currentBlock.getRotation()].length; j++) {
			for (int k = 0; k < Game.currentBlock.getBounds()[Game.currentBlock.getRotation()][j].length; k++) {

				// Prüft, ob die Zelle des Blocks gefüllt ist und zeichnet dann das Rechteck auf dem Bildschirm
				if (Game.currentBlock.getBounds()[Game.currentBlock.getRotation()][j][k] == 1) {
					g.fillRect(Conversion.cellToCoord(Game.currentBlock.getX() + j),
							Conversion.cellToCoord(Game.currentBlock.getY() + k), 32, 32);
				}
			}
		}

		// Zeichnet alle Blöcke auf der Karte
		for (int i = 0; i < Game.map.length; i++) {
			for (int j = 0; j < Game.map[i].length; j++) {
				if (Game.map[i][j] > 0) {
					// Wählt die Farbe des Blocks basierend auf dem Wert in der Karte
					switch (Game.map[i][j]) {
					case 1:
						g.setColor(Color.CYAN);						
						break;
					case 2:
						g.setColor(Color.YELLOW);
						break;
					case 3:
						g.setColor(Color.MAGENTA);
						break;
					case 4:
						g.setColor(Color.ORANGE);
						break;
					case 5:
						g.setColor(Color.BLUE);
						break;
					case 6:
						g.setColor(Color.RED);
						break;
					case 7:
						g.setColor(Color.GREEN);
						break;
					}
					// Zeichnet das Rechteck für den Block
					g.fillRect(Conversion.cellToCoord(i), Conversion.cellToCoord(j), 32, 32);
				}
			}
		}

		// Zeichnet die Rasterlinien
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 18; j++) {
				g.drawRect(i * 32, j * 32, 32, 32);
			}
		}

		// Zeichnet die Umrandung des Spielfelds
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, Gui.width, Gui.height);

		// Fordert eine Neumalung des Fensters an
		repaint();
	}
}