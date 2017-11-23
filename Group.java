
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jorge
 * 
 * Group object. Each instance of this represents a group under-which more users
 * and groups can further be organized. 
 */
public class Group implements GroupHusk{
    private String name;
    private long creationTime = System.currentTimeMillis();
    
    public Group(String name){
        this.name = name;
    }
    
    @Override
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
    
    public void printCreationTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");    
        Date date = new Date(creationTime);
        System.out.println(sdf.format(date));
    }

    @Override
    public long getLastUpdated() {
        return 0;
    }
}
