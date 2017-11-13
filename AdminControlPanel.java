import javax.swing.JList;
import javax.swing.JTextField;


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
    
}
