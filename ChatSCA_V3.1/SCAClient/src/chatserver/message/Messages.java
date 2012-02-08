package chatserver.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class wraps the list of messages sent over Java RMI.
 * @author Mohamed Habib ESSOUSSI
 *
 */
public class Messages  implements Serializable {

	/**
	 * ID Serializable.
	 */
	private static final long serialVersionUID = -3340860855910696281L;
	
	/**
	 * List of messages.
	 */
	private List<String> messageList = new ArrayList<String>();

	/**
	 * Default constructor.
	 */
	public Messages() { }

	/**
	 * Constructor.
	 * @param l List of messages
	 */
	public Messages(final List<String> l) {
		this.messageList = l;
	}
	/**
	 * List of messages field getter.
	 * @return list of messages.
	 */
	public final List<String> getMessageList() {
		return messageList;
	}

	/**
	 * List of messages field setter.
	 * @param mymessageList List of messages.
	 */
	public final void setMessageList(final List<String> mymessageList) {
		this.messageList = mymessageList;
	}

}
