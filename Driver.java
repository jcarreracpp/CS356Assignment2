
import javax.swing.DefaultListModel;
import javax.swing.JList;


/**
 *
 * @author Jorge
 */
public class Driver {
    public static DefaultListModel<User> userBacklog = new DefaultListModel<>();
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
