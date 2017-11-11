
/**
 *
 * @author Jorge
 */
public interface UserHusk extends ClientHusk{
    
    @Override
    public void subscribeTo(ClientHusk ch);
  
    @Override
    public void notifyFollowers(String str);
}
