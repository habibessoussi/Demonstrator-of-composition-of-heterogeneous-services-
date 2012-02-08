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
