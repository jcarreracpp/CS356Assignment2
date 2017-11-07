/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public class PanelMakeVisitor implements PanelVisitor{

    @Override
    public void visit(AdminControlPanel acp) {
        new ACPMake(acp);
    }

    @Override
    public void visit(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
