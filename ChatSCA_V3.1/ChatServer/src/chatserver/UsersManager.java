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


package chatserver;

import org.osoa.sca.annotations.Remotable;

/**
 * This interface lists the user services.
 * It's a remotable interface which is related to the main service 
 * of the chat room in the PythonServerComponent.
 * @author Mohamed Said MOSLI BOUKSIAA
 *
 */
@Remotable
public interface UsersManager {
	
	
	

	/**
	 * This method connects a user.
	 * @param pseudo The pseudo of the user to be connected.
	 * @param password The password of the user to be connected.
	 * @return This method returns 1 if the user is successfully 
	 * connected and 0 otherwise.
	 */
	 
	int connect(String pseudo, String password);
	
	 /**
	  * This method disconect the user.
	  * @param pseudo The username of the user to be disconnected.
	  */
	void disconnect(String pseudo);

}
