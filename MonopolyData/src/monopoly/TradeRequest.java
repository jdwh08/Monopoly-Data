// Jonathan Wang
package monopoly;
import java.util.ArrayList;

import players.Player;

// Future extension project.
// Requests to trade properties, money, or getOutOfJail cards to other players.
public class TradeRequest {
	Player sender;
	Player receiver;
	ArrayList<Integer> sentProps;
	ArrayList<Integer> receivedProps;
	int sentMoney;
	int receivedMoney;
	boolean sentOutOfJail;
	boolean receivedOutOfJail;
	
	boolean isAccepted;
	
	public TradeRequest(Player iSender, Player iReceiver, ArrayList<Integer> iSentProps, ArrayList<Integer> iReceivedProps, int iSentMoney, int iReceivedMoney, boolean iSentOutOfJail, boolean iReceivedOutOfJail) {
		sender = iSender;
		receiver = iReceiver;
		sentProps = iSentProps;
		receivedProps = iReceivedProps;
		sentMoney = iSentMoney;
		receivedMoney = iReceivedMoney;
		sentOutOfJail = iSentOutOfJail;
		receivedOutOfJail = iReceivedOutOfJail;
	}
}
