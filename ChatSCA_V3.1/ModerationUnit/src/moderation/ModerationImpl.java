package moderation;

import javax.ejb.Stateless;

@Stateless
public class ModerationImpl implements Moderation {

	private String[] list = { "putain", "wtf" };

	@Override
	public String messageModerate(String msg) {

		String modifiedMessage = new String(msg);

		if (msg.charAt(msg.length() - 1) == '\n')
			modifiedMessage = modifiedMessage.substring(0,
					modifiedMessage.length() - 1);

		String messageCopy = new String(modifiedMessage);

		String replacement;
		char[] regex = null;

		for (String str : list) {
			replacement = "";
			regex = new char[str.length()*4];
			
			for (int i = 0; i < str.length(); i++) {
				replacement += "*";
				int j = 4*i ;
				regex[j] =  '[' ;
				regex[j+1] = str.toLowerCase().charAt(i);
				regex[j+2] = str.toUpperCase().charAt(i);
				regex[j+3] = ']' ;
			}			

			modifiedMessage = modifiedMessage.replaceAll(new String(regex), replacement);
		}
		if (!modifiedMessage.equals(messageCopy)) {
			modifiedMessage += " [auto-moderated]";
		}
		else
			System.out.println(regex.toString());
		return modifiedMessage;

	}

	public String[] getList() {
		return list;
	}

}
