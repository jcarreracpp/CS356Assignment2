
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Jorge
 */
class User implements Panelize{
    private JTextField userIDInput = new JTextField();
    private JTextField userMessage = new JTextField();
    private JTextArea following = new JTextArea();
    private JTextArea feed = new JTextArea();
    private List<User> listOfFollowing = new ArrayList();
    private List<User> listOfFollowed = new ArrayList();

    @Override
    public void accept(PanelVisitor pv) {
        pv.visit(this);
    }
    
    public JTextField sendUserIDInput(){
        return userIDInput;
    }
    
    public JTextField sendUserMessage(){
        return userMessage;
    }
    
    public JTextArea sendFollowing(){
        following.setEditable(false);
        following.append("Current following:\n");
        return following;
    }
    
    public JTextArea sendFeed(){
        feed.setEditable(false);
        feed.append("News feed:\n");
        return feed;
    }
}
