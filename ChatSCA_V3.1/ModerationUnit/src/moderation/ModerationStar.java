package moderation;

import javax.ejb.Remote;

/**
 * The interface extends the Moderation interface.
 * It aims to define the EJB Service which moderate bad words with stars.
 * @author Mohamed Habib ESSOUSSI
 *
 */
@Remote
public interface ModerationStar extends Moderation {

}
