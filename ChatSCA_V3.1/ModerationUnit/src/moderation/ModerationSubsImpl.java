/*
 * Master-Level project:                                                           
 *       Demonstrator of composition of heteregenous services                      
 *       with SCA                                                                 
 *                                                                                 
 *  Copyright (C) 2012                                                            
 *  Authors: Mohamed Habib ESSOUSSI                                                
 *           Mohamed Said MOSLI BOUSKIAA                                           
 *                                                                                 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of 
 * this software and associated documentation files (the "Software"), to deal in    
 * the Software without restriction, including without limitation the rights to     
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies    
 * of the Software, and to permit persons to whom the Software is furnished to do   
 * so, subject to the following conditions:                                         
 *                                                                                  
 * The above copyright notice and this permission notice shall be included in all   
 * copies or substantial portions of the Software.                                  
 *                                                                                  
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR       
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,         
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE      
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER           
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,    
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE    
 * SOFTWARE.                                                                        
 *                                                                                  
 *  TELECOM SudParis | Oct 2011-Jan 2012                                            
 */   
 
package moderation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;

/**
 * This class implements the ModerationSubs interface. It defines the algorithm
 * of substitution of the geek words with normal words.
 * 
 * @author Mohamed Habib ESSOUSSI
 * 
 */
@Stateless
public class ModerationSubsImpl implements ModerationSubs {

	/**
	 * Mapping geek words with normal words.
	 */
	private Map<String, String> substitutionsMap;

	/**
	 * Contructor.
	 */
	public ModerationSubsImpl() {
		substitutionsMap = new HashMap<String, String>();
		substitutionsMap.put("lol", "Hehe");
		substitutionsMap.put("kawai", "mignon");
		substitutionsMap.put("leet", "élite");
		substitutionsMap.put("THX", "Merci");
		substitutionsMap.put("PLZ", "S'il vous plaît");
		substitutionsMap.put("BRB", "Je reviens bientôt");
		substitutionsMap.put("wOOt", "Youpi !");
		substitutionsMap.put("owned", "Je t'ai eu !");
		substitutionsMap.put("KTHXBYE", "Ok merci, au revoir");
	}

	@Override
	public final String messageModerate(final String msg) {

		String modifiedMessage = new String(msg);
		if (!msg.equals("")) {
			if (msg.charAt(msg.length() - 1) == '\n') {
				modifiedMessage = modifiedMessage.substring(0,
						modifiedMessage.length() - 1);
			}

			String messageCopy = new String(modifiedMessage);

			char[] regex = null;
			Set<String> keySet = substitutionsMap.keySet();

			for (String str : keySet) {
				regex = new char[str.length() * 4];

				for (int i = 0; i < str.length(); i++) {
					int j = 4 * i;
					regex[j] = '[';
					regex[j + 1] = str.toLowerCase().charAt(i);
					regex[j + 2] = str.toUpperCase().charAt(i);
					regex[j + 3] = ']';
				}

				modifiedMessage = modifiedMessage.replaceAll(new String(regex),
						substitutionsMap.get(str));
			}
			if (!modifiedMessage.equals(messageCopy)) {
				modifiedMessage += " [auto-antiGeek-moderated]";
			}
		}
		return modifiedMessage;

	}

	/**
	 * Mapping words getter.
	 * 
	 * @return the map which maps the geek words with normal words.
	 */
	public final Map<String, String> getsubstitutionsMap() {
		return substitutionsMap;
	}

}
