
/**
 *
 * @author Jorge
 */
public interface UserHusk extends ClientHusk{
    
    public void subscribeFollower(User us);
        
    public void notifyFollowers(User us);
    
    public void notifyFollowers();
}
