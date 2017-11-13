/**
 * @author Jorge
 * 
 * Interface for the user object that extends ClientHusk interface.
 */
public interface UserHusk extends ClientHusk{
    
    @Override
    public void subscribeTo(ClientHusk ch);
  
    @Override
    public void notifyFollowers(String str);
}
