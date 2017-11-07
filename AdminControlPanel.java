
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
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
    private int totalUsers = 0;
    private int totalGroups = 0;
    private int totalMessages = 0;
    private float percentPositMsg = 0;
    private JTree allGroupsAndUsers;
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

    public JTree sendAllGroupsAndUsers(){
        return allGroupsAndUsers;
    }
    
    public JTextField sendUserIDInput(){
        return userIDInput;
    }
    
    public JTextField sendGroupIDInput(){
        return groupIDInput;
    }
    
    public void setAllGroupsAndUsers(JTree jtree){
        allGroupsAndUsers = jtree;
    }
    
    public void setUserIDInput(String str){
        userIDInput.setText(str);
    }
    
    public void setGroupIDInput(String str){
        groupIDInput.setText(str);
    }
}
