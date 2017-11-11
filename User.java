
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Jorge
 */
class User implements Panelize, UserHusk{
    private String name;
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
            listOfFollowed.get(i).addToFeedText(str + "\n");
        }
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
    
    private List<User> getFollowed(){
        return listOfFollowed;
    }
    
    public List<User> getFollowed(User us){
        return us.getFollowed();
    }
    
    public void addToFollowed(User us){
        getFollowed(us).add(this);
    }
    
    public String sendName(){
        return name;
    }
    
    public void addToFollowingText(String str){
        following.append(str + "\n");
    }
    
    public void addToFeedText(String str){
        feed.append(str + "\n");
    }

}
