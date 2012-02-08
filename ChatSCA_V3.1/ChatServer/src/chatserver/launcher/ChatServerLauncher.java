package chatserver.launcher;

import java.io.IOException;
import org.apache.tuscany.sca.host.embedded.SCADomain;

/**
 * Class launcher of the composite.
 * @author Mohamed Habib ESSOUSSI
 *
 */
public final class ChatServerLauncher {

	/**
	 * Constructor.
	 */
	private ChatServerLauncher() { }
	
	/**
	 * 
	 * @param args No need.
	 */
	public static void main(final String[] args) {
		SCADomain scaDomain = SCADomain.
				newInstance("chatserver.composite");
		try {
			System.out
					.println("Chat server started (press enter to shutdown)");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scaDomain.close();
		System.out.println("Chat server stopped");
	}
}
