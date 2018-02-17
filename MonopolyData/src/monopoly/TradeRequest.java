package monopoly;
import java.util.ArrayList;

import players.Player;

// TODO:
// Make trade requests
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
	
	public TradeRequest(Player iSender, Player iReceiver, ArrayList<Integer> iSentProps, ArrayList<Integer> iReceivedProps, boolean iSentOutOfJail, boolean iReceivedOutOfJail) {
		sender = iSender;
		receiver = iReceiver;
		sentProps = iSentProps;
		receivedProps = iReceivedProps;
		sentOutOfJail = iSentOutOfJail;
		receivedOutOfJail = iReceivedOutOfJail;
	}
}
