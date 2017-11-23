/**
 * @author Jorge
 * 
 * The overarching composite for User and Group to allow simple access.
 */
public interface ClientHusk {
    
    public void subscribeTo(ClientHusk ck);
    
    public void notifyFollowers(String str);
    
    public boolean labeledGroup();
    
    public String sendName();
    
    public void printCreationTime();

    public long getLastUpdated();
}
