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
