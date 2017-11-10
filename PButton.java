
import javax.swing.JButton;


/**
 *
 * @author Jorge
 */
public class PButton extends JButton{
    
    public void PButton(){}
    
    public PButton addUser(){
        setText("Add User");
        setActionCommand("addNewUser");
        return this;
    }
    
    public PButton addGroup(){
        setText("Add Group");
        setActionCommand("addNewGroup");
        return this;
    }
    
    public PButton showUsers(){
        setText("Show Total Users");
        setActionCommand("userCount");
        return this;
    }
    
    public PButton showGroups(){
        setText("Show Total Groups");
        setActionCommand("groupCount");
        return this;
    }
    
    public PButton showMessages(){
        setText("Show Total Messages");
        setActionCommand("messageCount");
        return this;
    }
    
    public PButton showPercent(){
        setText("Show Positive Percentage");
        setActionCommand("positivePercent");
        return this;
    }
    
    public PButton userView(){
        setText("Open User View");
        setActionCommand("userView");
        return this;
    }
    
    public PButton followUser(){
        setText("Follow User");
        setActionCommand("follow");
        return this;
    }
    
    public PButton sendMessage(){
        setText("Send Message");
        setActionCommand("sendMsg");
        return this;
    }
}
