package moderation;

import javax.ejb.Remote;

/**
 * The interface extends the Moderation interface.
 * It aims to define the EJB Service which moderate geek 
 * words with normal words.
 * @author Mohamed Habib ESSOUSSI
 *
 */
@Remote
public interface ModerationSubs extends Moderation {

}
