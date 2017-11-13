/**
 * @author Jorge
 * 
 * Calls the classes that construct the GUI after a visit has occurred.
 */
public class PanelMakeVisitor implements PanelVisitor{

    @Override
    public void visit(AdminControlPanel acp) {
        new ACPMake(acp);
    }

    @Override
    public void visit(User user) {
        new UCPMake(user);
    }
    
}
