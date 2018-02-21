// Jonathan Wang
package monopoly;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import players.Player;
import players.SemiRandomPlayer;

public class MonopolyRunner {
	static Player currentPlayer;
	static Board monopolyBoard;
	private static Path outputPath;
	private static File output;
	static List<String> writeLines;

	public static void main(String[] args) throws IOException {
		// Initialize
		SemiRandomPlayer playerOne = new SemiRandomPlayer(1500, false);
		currentPlayer = playerOne;
		SemiRandomPlayer playerTwo = new SemiRandomPlayer(1500, false);
		monopolyBoard = new Board(playerOne, playerTwo);
		
		output = new File("monopolyData");
		outputPath = Paths.get(output.getPath());
		writeLines = new ArrayList<String>();
		
		// Main game loop
		while (playerOne.getMoney() > 0 && playerTwo.getMoney() > 0) {
			currentPlayer = Board.getCurrentPlayer();

			boolean hasDoubles = false;
			int numDoubles = 0;

			do {
				// Move
				if (monopolyBoard.canMove(currentPlayer)) {
					hasDoubles = monopolyBoard.move(currentPlayer);
					// Just been sent to jail
					if (currentPlayer.isInJail()) {
						System.out.println("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Action: " + -2 + " Money: " + currentPlayer.getMoney());
						writeLines.add("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Action: " + -2 + " Money: " + currentPlayer.getMoney());
						break;
					}
					if (hasDoubles) {
						numDoubles++;
					}
				}
				int beforeActionLoc = Board.getPlayerLocs().get(currentPlayer);
				doAction();
				// Just been sent to jail
				if (currentPlayer.isInJail()) {
					System.out.println("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Action: " + -2 + " Money: " + currentPlayer.getMoney());
					writeLines.add("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Action: " + -2 + " Money: " + currentPlayer.getMoney());
					break;
				}

				int afterActionLoc = Board.getPlayerLocs().get(currentPlayer);
				// Check if action caused player to move
				if (beforeActionLoc != afterActionLoc) {
					// Allow the player to buy the property if unowned
					doAction();
				}

				// TODO: Anytime player stuff

			}
			while (hasDoubles && numDoubles < 3);

			if (numDoubles == 3) {
				monopolyBoard.goToJail(currentPlayer);
			}
			monopolyBoard.switchCurrentPlayer();
		}
		
		Files.write(outputPath, writeLines, Charset.forName("UTF-8"));
	}

	public static void doAction() {
		// Action
		int actionId = currentPlayer.getAction();
		// TODO:
		// Check to see if action is legal

		switch (actionId) {
		case 0:
			monopolyBoard.payTax(currentPlayer);
			break;
		case 1:
			monopolyBoard.buyProperty(currentPlayer, Board.getPlayerLocs().get(currentPlayer));
			break;
		case 2:
			monopolyBoard.drawCard(currentPlayer);
			break;
		case 3:
			monopolyBoard.payOutJail(currentPlayer);
			break;
		case 4:
			monopolyBoard.useOutJail(currentPlayer);
			break;
		case 5:
			monopolyBoard.rollOutJail(currentPlayer);
			break;
		}
		System.out.println("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Action: " + actionId + " Money: " + currentPlayer.getMoney());
		writeLines.add("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Action: " + actionId + " Money: " + currentPlayer.getMoney());
	}
	
	// TODO: Anytime
	
	/*public static void doAnytime() {
		ArrayList<Integer> playerOutput = currentPlayer.getAnytime();
		int actionId = playerOutput.
	}*/
}
