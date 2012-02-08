package moderation;

import javax.ejb.Stateless;

/**
 * This class implements the ModerationStar interface. It defines the algorithm
 * of replacement of the bad words with stars.
 * 
 * @author Mohamed Habib ESSOUSSI
 * @author Mohamed Said MOSLI BOUKSIAA
 * 
 */
@Stateless
public class ModerationStarImpl implements ModerationStar {

	/**
	 * List of bad words.
	 */
	private String[] list = { "putain", "wtf" };

	@Override
	public final String messageModerate(final String msg) {

		String modifiedMessage = new String(msg);
		if (!msg.equals("")) {
			if (msg.charAt(msg.length() - 1) == '\n') {
				modifiedMessage = modifiedMessage.substring(0,
						modifiedMessage.length() - 1);
			}

			String messageCopy = new String(modifiedMessage);

			String replacement;
			char[] regex = null;

			for (String str : list) {
				replacement = "";
				regex = new char[str.length() * 4];

				for (int i = 0; i < str.length(); i++) {
					replacement += "*";
					int j = 4 * i;
					regex[j] = '[';
					regex[j + 1] = str.toLowerCase().charAt(i);
					regex[j + 2] = str.toUpperCase().charAt(i);
					regex[j + 3] = ']';
				}

				modifiedMessage = modifiedMessage.replaceAll(new String(regex),
						replacement);
			}
			if (!modifiedMessage.equals(messageCopy)) {
				modifiedMessage += " [auto-moderated]";
			} 
		}
		return modifiedMessage;

	}

	/**
	 * Bad words getter.
	 * 
	 * @return Array of bad words.
	 */
	public final String[] getList() {
		return list;
	}

}
