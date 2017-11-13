/**
 * @author Jorge
 * 
 * Visitor. Visits other classes that can accept this and adds the ability to
 * generate GUI elements.
 */
public interface PanelVisitor {
    public void visit(AdminControlPanel apc);
    public void visit(User user);
}
