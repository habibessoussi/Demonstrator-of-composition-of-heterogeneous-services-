package moderation;


/**
 * Interface Moderation.
 * @author Mohamed Habib ESSOUSSI
 *
 */
public interface Moderation {
	
	/**
	 * This method moderates the message entered by the user.
	 * @param msg The message entered by the user.
	 * @return The message moderated.
	 */
	String messageModerate(String msg);
}
