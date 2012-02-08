package chatserver.message;
 

/**
 * This interface describes the MessagesManager unit.
 * @author Mohamed Habib ESSOUSSI
 * @author Mohamed Said MOSLI BOUKSIAA
 *
 */

public interface MessagesManager {
	/**
	 * This method returns the messages from the server.
	 * @param received The rank from which the method will return the messages.
	 * @return This returns a list of messages wrapped into
	 * a class Messages according
	 * to the following syntax:
	 * 		username:message.
	 */
	Messages checkMessages(int received);

	/**
	 * This method sends the message to the server.
	 * @param pseudo The username of the user.
	 * @param msg The message to be sent.
	 */
	void sendMessage(String pseudo, String msg);

}
