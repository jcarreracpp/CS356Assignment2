
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * @author Jorge
 * 
 * This class is a singleton, getAdminControlPanel() ensures that only one
 * instance of this object can exist.
 */
public class AdminControlPanel{
    private static AdminControlPanel acp = null;

    private float percentPositMsg = 0;
    private JList allGroupsAndUsers;
    private JTextField userIDInput = new JTextField();
    private JTextField groupIDInput = new JTextField();

    private AdminControlPanel() {
    }
    
    /**
     * Singleton lock constructor.
     * @return 
     */
    public static AdminControlPanel getAdminControlPanel(){
        if(acp == null){
            acp = new AdminControlPanel();
        }
        return acp;
    }
    
    public void accept(PanelMakeVisitor pmv){
        pmv.visit(this);
    }

    public JList sendAllGroupsAndUsers(){
        return allGroupsAndUsers;
    }
    
    public JTextField sendUserIDInput(){
        return userIDInput;
    }
    
    public JTextField sendGroupIDInput(){
        return groupIDInput;
    }
    
//    public int sendTotalUsers(){
//        return totalUsers;
//    }
//    
//    public int sendTotalGroups(){
//        return totalGroups;
//    }
//    
//    public int sentTotalMessages(){
//        return totalMessages;
//    }
    
    public float sendPercentPositMsg(){
        return percentPositMsg;
    }
    
    public void setAllGroupsAndUsers(JList jlist){
        allGroupsAndUsers = jlist;
    }
    
    public void setUserIDInput(String str){
        userIDInput.setText(str);
    }
    
    public void setGroupIDInput(String str){
        groupIDInput.setText(str);
    }
    
//    public void incrementUser(){
//        totalUsers++;
//    }
//    
//    public void incrementGroups(){
//        totalGroups++;
//    }
//    
//    public void incrementMessages(){
//        totalMessages++;
//    }
//    
//    public void incrementPositive(){
//        positiveMessages++;
//    }
//    
//    public float calcPosit(){
//        percentPositMsg = (float)positiveMessages / (float) totalMessages;
//        return (percentPositMsg*100.0f);
//    }
}
