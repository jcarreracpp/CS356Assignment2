/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public interface PanelVisitor {
    public void visit(AdminControlPanel apc);
    public void visit(User user);
}
