package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Collision;
import game.Game;
import game.GameState;
import infrastructure.GameLoop;
import infrastructure.Main;

public class KeyHandler implements KeyListener {

	// Wird aufgerufen, wenn eine Taste getippt (gedrückt und losgelassen) wurde
	@Override
	public void keyTyped(KeyEvent e) {
		// Nicht implementiert
	}

	// Wird aufgerufen, wenn eine Taste gedrückt wurde
	@Override
	public void keyPressed(KeyEvent e) {
		// Prüfen, ob das Spiel im Startzustand ist und die Enter-Taste gedrückt wurde
		if (Game.gamestate == GameState.start) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Game.gamestate = GameState.ingame;
			}
		}

		// Prüfen, ob das Spiel im Spielzustand ist und entsprechende Tasten gedrückt wurden
		if (Game.gamestate == GameState.ingame) {
			// Prüfen, ob die Leertaste gedrückt wurde
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// Drehen des Blocks, wenn keine Kollision vorliegt
				try {
					if (!Collision.collideInRotation(Game.currentBlock)) {
						Game.currentBlock.rotate();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			// Aktivieren der Geschwindigkeitssteigerung, wenn die Abwärtstaste gedrückt wurde
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Game.speedup = true;
			}

			// Verschieben des Blocks nach rechts, wenn die Rechtstaste gedrückt wurde und keine Kollision vorliegt
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				try {
					if (!Collision.collideWithWall(Game.currentBlock, 1)
							&& !Collision.collideWithBlock(Game.currentBlock, 1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() + 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			// Verschieben des Blocks nach links, wenn die Linkstaste gedrückt wurde und keine Kollision vorliegt
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				try {
					if (!Collision.collideWithWall(Game.currentBlock, -1)
							&& !Collision.collideWithBlock(Game.currentBlock, -1)) {
						Game.currentBlock.setX(Game.currentBlock.getX() - 1);
					} 
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			// Wechseln in den Pause-Modus, wenn die Escape-Taste gedrückt wurde
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.gamestate = GameState.pause;
			}
		// Weitermachen des Spiels, wenn es pausiert war und die Escape-Taste gedrückt wurde
		} else if (Game.gamestate == GameState.pause) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				Game.gamestate = GameState.ingame;
			}
			// Wenn das Spiel vorbei ist und die Enter-Taste gedrückt wird, wird das Spiel neu gestartet
		} else if (Game.gamestate == GameState.gameover) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				Game.gamestate = GameState.ingame;
				Game.clear();
			}

		}

	}

	// Wird aufgerufen, wenn eine Taste losgelassen wurde
	@Override
	public void keyReleased(KeyEvent e) {
		// Deaktivieren der Geschwindigkeitssteigerung, wenn die Abwärtstaste losgelassen wurde
		if (Game.gamestate == GameState.ingame) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Game.speedup = false;
			}
		}

	}
}
