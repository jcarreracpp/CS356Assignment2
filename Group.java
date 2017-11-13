/**
 * @author Jorge
 * 
 * Group object. Each instance of this represents a group under-which more users
 * and groups can further be organized. 
 */
public class Group implements GroupHusk{
    private String name;
    
    public Group(String name){
        this.name = name;
    }
    
    public String sendName(){
        return name;
    }
    
    @Override
    public void subscribeTo(ClientHusk ck) {
        throw new UnsupportedOperationException("Groups cannot subscribe!");
    }

    @Override
    public void notifyFollowers(String str) {
        throw new UnsupportedOperationException("Groups cannot message!");
    }
    
    @Override
    public boolean labeledGroup(){
        return true;
    }
    
}
