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
