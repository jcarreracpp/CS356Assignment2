import javax.swing.DefaultListModel;
import javax.swing.JList;


/**
 * @author Jorge
 * 
 * The main driver class, gets the instance of AdminControlPanel singleton and
 * has the jpanel creator visitor visit it to generate the GUI. Clienthusk is 
 * the composite for UserHusk and GroupHusk, which are implemented by User and 
 * Group respectively. Users are observers/observables to each other. 
 */
public class Driver {
    public static DefaultListModel<ClientHusk> userBacklog = new DefaultListModel<>();
    public static DefaultListModel<String> userNames = new DefaultListModel<>();
    public static JList<String> allList;
    public static int totalUsers = 0;
    public static int totalGroups = 0;
    public static int totalMessages = 0;
    public static int positiveMessages = 0;
    
    public static void main(String[] args) {
        AdminControlPanel acp = AdminControlPanel.getAdminControlPanel();
        acp.accept(new PanelMakeVisitor());
    }
}
