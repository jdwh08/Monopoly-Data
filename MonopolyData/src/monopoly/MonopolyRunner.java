package monopoly;

import players.Player;
import players.SemiRandomPlayer;

public class MonopolyRunner {
	static Player currentPlayer;
	static Board monopolyBoard;

	public static void main(String[] args) {
		// Initialize
		SemiRandomPlayer playerOne = new SemiRandomPlayer(1500, false);
		currentPlayer = playerOne;
		SemiRandomPlayer playerTwo = new SemiRandomPlayer(1500, false);
		monopolyBoard = new Board(playerOne, playerTwo);

		// Main game loop
		while (playerOne.getMoney() > 0 && playerTwo.getMoney() > 0) {
			currentPlayer = monopolyBoard.getCurrentPlayer();

			boolean hasDoubles = false;
			int numDoubles = 0;

			do {
				// Move
				if (monopolyBoard.canMove(currentPlayer)) {
					hasDoubles = monopolyBoard.move(currentPlayer);
					// Just been sent to jail
					if (currentPlayer.isInJail()) {
						System.out.println("Player: " + currentPlayer + " Location: " + monopolyBoard.getPlayerLocs().get(currentPlayer) + " Action: " + -2 + " Money: " + currentPlayer.getMoney());
						break;
					}
					if (hasDoubles) {
						numDoubles++;
					}
				}
				int beforeActionLoc = monopolyBoard.getPlayerLocs().get(currentPlayer);
				doAction();
				// Just been sent to jail
				if (currentPlayer.isInJail()) {
					System.out.println("Player: " + currentPlayer + " Location: " + monopolyBoard.getPlayerLocs().get(currentPlayer) + " Action: " + -2 + " Money: " + currentPlayer.getMoney());
					break;
				}

				int afterActionLoc = monopolyBoard.getPlayerLocs().get(currentPlayer);
				// Check if action caused player to move
				if (beforeActionLoc != afterActionLoc) {
					// Allow the player to buy the property if unowned
					doAction();
				}

				// Anytime
				// TODO:

			}
			while (hasDoubles && numDoubles < 3);

			if (numDoubles == 3) {
				monopolyBoard.goToJail(currentPlayer);
			}
			monopolyBoard.switchCurrentPlayer();
		}
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
		System.out.println("Player: " + currentPlayer + " Location: " + monopolyBoard.getPlayerLocs().get(currentPlayer) + " Action: " + actionId + " Money: " + currentPlayer.getMoney());
	}
}
