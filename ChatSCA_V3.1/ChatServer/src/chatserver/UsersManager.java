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
