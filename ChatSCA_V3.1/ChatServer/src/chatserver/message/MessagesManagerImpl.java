package chatserver.message;
 
import java.util.ArrayList;

/**
 * This class implements the MessagesManager unit.
 * @author Mohamed Said MOSLI BOUKSIAA
 *
 */
public class MessagesManagerImpl implements MessagesManager {

	/**
	 * Static list of messages to be sent or check over JAVA RMI.
	 */
	private static ArrayList<String> myMessages = new ArrayList<String>();

	/**
	 * Send the message to the server means add it to the list of messages
	 * field. The message will be added in the following format:
	 * 		pseudo:message
	 * @param pseudo The username of the client.
	 * @param msg The message to be added.
	 */
	@Override
	public final void sendMessage(final String pseudo, final String msg) {
		
		if (!msg.equals("")) {
			myMessages.add(pseudo + ": " + msg);
		}
	}

	/**
	 * This method returns the elements of the static list of messages
	 * starting from a rank defined by received (int) variable.
	 * @param received the rank from which this methods return the messages.
	 * @return The list of messages wrapped into Messages Serializable class
	 * to be transfered over JAVA RMI.
	 */
	@Override
	public final Messages checkMessages(final int received) {
		
		ArrayList<String> tempList = new ArrayList<String>();
		for (int i = received; i < myMessages.size(); i++) {
			tempList.add(myMessages.get(i));
		}

		return new Messages(tempList);
	}

}
