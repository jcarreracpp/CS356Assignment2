
/**
 *
 * @author Jorge
 */
public class Driver {
    public static void main(String[] args) {
        AdminControlPanel acp = AdminControlPanel.getAdminControlPanel();
        acp.accept(new PanelMakeVisitor());
    }
}
