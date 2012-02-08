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
