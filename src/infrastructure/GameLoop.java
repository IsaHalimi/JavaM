package infrastructure;

import data.Collision;
import game.Block;
import game.Game;
import game.GameState;

public class GameLoop extends Thread {

    // Variable zur Steuerung der Laufzeit der Schleife
	private boolean running = true;

    // Die Run-Methode wird aufgerufen, wenn der Thread gestartet wird
	@Override
	public void run() {
		while (running) { // Die Schleife läuft, solange 'running' true ist
			try {
				// Spiellogik wird nur ausgeführt, wenn der Spielstatus 'ingame' ist
				if (Game.gamestate == GameState.ingame) {
					
                    // Überprüft auf Kollisionen mit der Wand und anderen Blöcken,
                    // wenn keine gefunden werden, wird die Y-Position des aktuellen Blocks erhöht
					if (!Collision.collideWithWall(Game.currentBlock, 0)
							&& !Collision.collideWithBlock(Game.currentBlock, 0)) {
						Game.currentBlock.setY(Game.currentBlock.getY() + 1);
						Collision.collideWithWall(Game.currentBlock, 0);

					}

                    // Wenn ein neuer Block erstellt werden muss,
                    // überprüft es auf volle Reihen, fügt den nächsten Block zur Blockliste hinzu,
                    // setzt den aktuellen Block auf den nächsten und erzeugt einen neuen nächsten Block
					if (Game.spawnNewBlock) {
						Collision.checkFullRow(1);
						Game.blocks.add(Game.nextBlock);
						Game.currentBlock = Game.nextBlock;
						Game.nextBlock = new Block();
						Game.spawnNewBlock = false;
					}
				}
                // Wenn das Spiel nicht beschleunigt wird, wartet der Thread eine Sekunde,
                // ansonsten wartet er nur 100 Millisekunden
				if (!Game.speedup) {
					sleep(1000);
				} else {
					sleep(100);
				}

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}
