// Jonathan Wang
package monopoly;

import java.awt.Color;
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
	// The current player
	static Player currentPlayer;
	// The monopolyBoard.
	static Board monopolyBoard;
	// The path for the output file
	private static Path outputPath;
	// The output file
	private static File output;
	// A List of Strings representing the lines to be written to the output file.
	static List<String> writeLines;
	// An array representing all the possible colors for the colorProperties.
	static Color[] propColors = { Color.MAGENTA, Color.CYAN, Color.PINK, Color.ORANGE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE };

	/* Main runner for the code.
	 * Precondition: The program is started.
	 * Postcondition: Written file of events.
	 */
	public static void main(String[] args) throws IOException {
		// Initialize
		SemiRandomPlayer playerOne = new SemiRandomPlayer(1500, false);
		currentPlayer = playerOne;
		SemiRandomPlayer playerTwo = new SemiRandomPlayer(1500, false);
		monopolyBoard = new Board(playerOne, playerTwo);
		
		output = new File("monopolyData.csv");
		outputPath = Paths.get(output.getPath());
		writeLines = new ArrayList<String>();
		writeLines.add("Player, Location, Action, Anytime, AnytimeTarget, Money");
		
		int numTurns = 0;
		// Main game loop
		while (playerOne.getMoney() > 0 && playerTwo.getMoney() > 0 && numTurns < 1000) {
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
						writeLines.add("" + currentPlayer + ", " + Board.getPlayerLocs().get(currentPlayer) + ", " + -2 + ", " + ", " + ", " + currentPlayer.getMoney());
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
					writeLines.add("" + currentPlayer + ", " + Board.getPlayerLocs().get(currentPlayer) + ", " + -2 + ", " + ", " + ", " + currentPlayer.getMoney());
					break;
				}

				int afterActionLoc = Board.getPlayerLocs().get(currentPlayer);
				// Check if action caused player to move
				if (beforeActionLoc != afterActionLoc) {
					// Allow the player to buy the property if unowned
					doAction();
				}
				// TODO: Anytime player stuff
				doAnytime();
			}
			while (hasDoubles && numDoubles < 3);

			if (numDoubles == 3) {
				monopolyBoard.goToJail(currentPlayer);
			}
			monopolyBoard.switchCurrentPlayer();
			numTurns++;
		}
		
		Files.write(outputPath, writeLines, Charset.forName("UTF-8"));
	}

	/* Converts player output for actions into actual effects on the board
	 * Precondition: The current player has decided upon an action
	 * Postcondition: The game after the effect. Player, location, action, money added to file and console output.
	 */
	public static void doAction() {
		// Action
		int actionId = currentPlayer.getAction();

		switch (actionId) {
		case 0:
			monopolyBoard.payTax(currentPlayer);
			break;
		case 1:
			monopolyBoard.buyProperty(currentPlayer);
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
		writeLines.add("" + currentPlayer + ", " + Board.getPlayerLocs().get(currentPlayer) + ", " + actionId + ", " + ", " + ", " + currentPlayer.getMoney());
	}
	
	/* Converts player output for anytimes (things which can be done regardless of player location, ex. buying a house) into actual effects on the board
	 * Precondition: The current player has decided upon an anytime
	 * Postcondition: The game after the effect. Player, location, anytime, target for the anytime, money added to file and console output.
	 */
	public static void doAnytime() {
		ArrayList<Integer> playerOutput = currentPlayer.getAnytime();
		while (!playerOutput.isEmpty()) {
			int anytimeId = playerOutput.get(0);
			
			switch (anytimeId) {
			case 0:
				// This shouldn't happen because I'm not doing trades.
				break;
			case 1:
				monopolyBoard.buyHouse(currentPlayer, propColors[playerOutput.get(1)]);
				break;
			case 2:
				monopolyBoard.sellHouse(currentPlayer, propColors[playerOutput.get(1)]);
				break;
			case 3:
				monopolyBoard.mortgage(currentPlayer, playerOutput.get(1));
				break;
			case 4:
				monopolyBoard.deMortgage(currentPlayer, playerOutput.get(1));
				break;
			}
			System.out.println("Player: " + currentPlayer + " Location: " + Board.getPlayerLocs().get(currentPlayer) + " Anytime: " + anytimeId + " Target: " + playerOutput.get(1) + " Money: " + currentPlayer.getMoney());
			writeLines.add("" + currentPlayer + ", " + Board.getPlayerLocs().get(currentPlayer) + ", " + ", " + anytimeId + ", " + playerOutput.get(1) + ", " + currentPlayer.getMoney());
			
			playerOutput = currentPlayer.getAnytime();
		}
	}
}
