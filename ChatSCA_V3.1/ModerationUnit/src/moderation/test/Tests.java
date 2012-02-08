package moderation.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Set;

import moderation.ModerationStarImpl;
import moderation.ModerationSubsImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a unit test class to test the returns
 * of both of implementations.
 * 
 * @author Mohamed Habib ESSOUSSI.
 *
 */
public class Tests {

	/**
	 * List of bad words.
	 */
	private String[] badwords;
	
	/**
	 * Set of geek words.
	 */
	private Set<String> geekwords;

	/**
	 * List of messages to test.
	 */
	private String[] msg;
	
	/**
	 * Bad words moderation implementation.
	 */
	private ModerationStarImpl mi;
	
	/**
	 * Geek words moderation implementation.
	 */
	private ModerationSubsImpl misub;

	/**
	 * Setting up fields before testing.
	 */
	@Before
	public final void setUp() {
		mi = new ModerationStarImpl();
		badwords = mi.getList();

		misub = new ModerationSubsImpl();
		geekwords = misub.getsubstitutionsMap().keySet();

		msg = new String[3];
		msg[0] = "booof wtf ! putain wTf";
		msg[1] = "PuTainnnn !!!";
		msg[2] = "wooT leet thanks";

	}

	/**
	 * The main test.
	 */
	@Test
	public final void testModeratedSentence() {

		for (String msgi : msg) {
			assertNotNull(msgi);
			assertFalse(msgi.equals(""));

			for (String str : badwords) {
				if (msgi.toLowerCase().contains(str.toLowerCase())) {
					assertNotSame(msgi, mi.messageModerate(msgi));
				}
			}
			for (String str : geekwords) {
				if (msgi.toLowerCase().contains(str.toLowerCase())) {
					assertNotSame(msgi, misub.messageModerate(msgi));

				}
			}
		}
	}

	/**
	 * Print the test result at the end of the test.
	 */
	@After
	public final void tearDown() {
		for (String msgi : msg) {
			System.out
					.println(misub.messageModerate(mi.messageModerate(msgi)));
		}
	}

}
