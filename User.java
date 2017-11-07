
/**
 *
 * @author Jorge
 */
class User implements Panelize{

    @Override
    public void accept(PanelVisitor pv) {
        pv.visit(this);
    }
    
}
