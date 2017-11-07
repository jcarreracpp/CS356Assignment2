
/**
 *
 * @author Jorge
 */
public interface ClientHusk {
    
    public void subscribeFollower(User us);
        
    public void notifyFollowers(User us);
    
    public void notifyFollowers();
}
