/**
 * @author Jorge
 * 
 * Part of the visitor pattern, enables AdminControlPanel and User to be visited.
 */
public interface Panelize {
    public void accept(PanelVisitor pv);
}
