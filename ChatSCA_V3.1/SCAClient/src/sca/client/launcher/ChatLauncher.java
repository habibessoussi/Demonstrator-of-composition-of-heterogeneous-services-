package sca.client.launcher;
 
import java.io.IOException;

import javax.naming.Context;

import org.apache.tuscany.sca.host.embedded.SCADomain;

/**
 * This class launches the Chat Client.
 * @author Mohamed Habib ESSOUSSI
 *
 */
public final class ChatLauncher {

	/**
	 * Constructor.
	 */
	private ChatLauncher() { }
	
	/**
	 * Launcher of the client.
	 * @param args No need
	 */
	public static void main(final String[] args) {
		
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.openejb.client.RemoteInitialContextFactory");
        System.setProperty(Context.PROVIDER_URL, "ejbd://localhost:4201");
        
		SCADomain scaDomain = SCADomain.newInstance("client.composite");

		Runnable use = scaDomain.getService(Runnable.class,
				"ClientComponent/Runnable");
		use.run();

		try {
			System.out
					.println("client server started (press enter to shutdown)");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scaDomain.close();
		System.out.println("client server stopped");
	}

}
