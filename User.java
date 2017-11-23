
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Jorge
 * 
 * User object. Each instance of this represents a single user with their own
 * list of people followed/followers etc.
 */
class User implements Panelize, UserHusk{
    private String name;
    private long creationTime = System.currentTimeMillis();
    private long lastUpdated  = 0;
    private JTextField userIDInput = new JTextField();
    private JTextField userMessage = new JTextField();
    private JTextArea following = new JTextArea();
    private JTextArea feed = new JTextArea();
    private List<User> listOfFollowing = new ArrayList();
    private List<User> listOfFollowed = new ArrayList();

    public User(String name){
        this.name = name;
        following.setEditable(false);
        following.append("Current following:\n");
        feed.setEditable(false);
        feed.append("News feed:\n");
    }
    
    @Override
    public void accept(PanelVisitor pv) {
        pv.visit(this);
    }
    
    @Override
    public void subscribeTo(ClientHusk ch) {
        listOfFollowing.add((User)ch);
        addToFollowed((User)ch);
    }

    @Override
    public void notifyFollowers(String str) {
        for(int i = 0; i < listOfFollowed.size(); i++){
            listOfFollowed.get(i).addToFeedText(this, str);
            listOfFollowed.get(i).setUpdated(System.currentTimeMillis());
        }
        lastUpdated = System.currentTimeMillis();
        addToFeedText(this, str);
        Driver.totalMessages++;
    }
    
    @Override
    public boolean labeledGroup(){
        return false;
    }
    
    public JTextField sendUserIDInput(){
        return userIDInput;
    }
    
    public JTextField sendUserMessage(){
        return userMessage;
    }
    
    public JTextArea sendFollowing(){
        return following;
    }
    
    public JTextArea sendFeed(){
        return feed;
    }
    
    public List<User> getFollowed(){
        return listOfFollowed;
    }
    
    public List<User> getFollowed(User us){
        return us.getFollowed();
    }
    
    public void addToFollowed(User us){
        getFollowed(us).add(this);
    }
    
    public void setUpdated(long time){
        lastUpdated = time;
    }
    
    public long getLastUpdated(){
        return lastUpdated;
    }
    
    public void follow(User us){
        boolean escape = false;
        for(int i = 0; i < listOfFollowing.size(); i++){
            if(us == listOfFollowing.get(i)){
                escape = true;
            }
        }
        if(name.equals(us.sendName())){
            escape = true;
        }
        
        if(!escape){
            System.out.println("ARRIED");
            listOfFollowing.add(us);
            addToFollowingText(us.sendName());
            addToFollowed(us);
        }
    }
    
    @Override
    public String sendName(){
        return name;
    }
    
    public void addToFollowingText(String str){
        following.append(str + "\n");
    }
    
    public void addToFeedText(User us, String str){
        feed.append(us.sendName() + ": " + str + "\n");
    }

    public void printCreationTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");    
        Date date = new Date(creationTime);
        System.out.println(sdf.format(date));
    }
    
}
