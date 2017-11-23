/**
 * @author Jorge
 * 
 * Interface for the group object that extends ClientHusk interface.
 */
public interface GroupHusk extends ClientHusk{
    
    @Override
    public void subscribeTo(ClientHusk ch);
  
    @Override
    public void notifyFollowers(String str);
    
    @Override
    public String sendName();
}
