
/**
 *
 * @author Jorge
 */
public interface ClientHusk {
    
    public void subscribeTo(ClientHusk ck);
    
    public void notifyFollowers(String str);
}
