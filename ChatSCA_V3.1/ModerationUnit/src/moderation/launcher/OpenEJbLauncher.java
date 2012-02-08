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
 
package moderation.launcher;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * This class starts the OpenEJB standalone server 
 * and deploy the EJB components.
 * @author Mohamed Habib ESSOUSSI.
 *
 */
public final class OpenEJbLauncher {
	
	/**
	 * Private constructor for utilitaire class.
	 */
	private OpenEJbLauncher() { }

	/**
	 * 
	 * @param args No need for arguments.
	 * @throws Exception OpenEJB Exception
	 */
	public static void main(final String[] args) throws Exception {
        System.out.println("Publishing SCA Chat as an EJB service");

        Properties properties = new Properties();
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        		"org.apache.openejb.client.LocalInitialContextFactory");
        properties.setProperty("openejb.embedded.remotable", "true");

        @SuppressWarnings("unused")
		InitialContext initialContext = new InitialContext(properties);

       
        System.out.println("EJB server running - waiting for requests");
        System.out.println("Press enter to shutdown.");
        System.in.read();
    }
}
