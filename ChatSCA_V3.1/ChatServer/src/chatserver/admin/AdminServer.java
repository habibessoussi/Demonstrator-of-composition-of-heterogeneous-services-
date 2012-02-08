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
 
package chatserver.admin;
 
import org.osoa.sca.annotations.Remotable;

/**
 * This interface lists the administator prerogatives.
 * It's a remotable interface which is related to the service 
 * of administration the chat room in the PythonServerComponent.
 * @author Mohamed Said MOSLI BOUKSIAA
 *
 */
@Remotable
public interface AdminServer {
	
	/**
	 * Add a User to the chat room.
	 * @param pseudo The username of the user to be added.
	 * @param password The password of the user to be added.
	 * @return This method returns 1 if the user is successfully 
	 * added and 0 otherwise.
	 */
	 int addUser(String pseudo, String password);
	 
	 /**
	  * Delete a User from the chat room.
	  * @param pseudo The username of the user to be deleted.
	  * @return This method returns 1 if the user is successfully 
	  * deleted and 0 otherwise.
	  */
	 int deleteUser(String pseudo);
	 
	 /**
	  * This Method return all the users.
	  * @return This returns a String which includes all 
	  * the users separated by '\n'.
	  */
	 String getUsers();
	 
	 /**
	  * This method connects the administrator to his panel.
	  * @param pseudo The pseudo of the admin.
	  * @param password The password of the admin.
	  * @return This method returns 1 if the admin is successfully 
	  * connected and 0 otherwise.
	  */
	 int connectAdmin(String pseudo, String password);
	 
	 /**
	  * This method disconect the admin.
	  * @param pseudo The username of the admin to be disconnected.
	  */
	 void disconnectAdmin(String pseudo);


}
