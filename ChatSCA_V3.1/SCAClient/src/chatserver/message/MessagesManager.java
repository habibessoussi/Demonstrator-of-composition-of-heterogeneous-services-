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
