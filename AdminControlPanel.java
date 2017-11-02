/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public class AdminControlPanel {
    private static AdminControlPanel acp = null;

    private AdminControlPanel() {
    }
    
    public static AdminControlPanel getAdminControlPanel(){
        if(acp == null){
            acp = new AdminControlPanel();
        }
        return acp;
    }
}
