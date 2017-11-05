
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

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
    private int totalUsers = 0;
    private int totalGroups = 0;
    private int totalMessages = 0;
    private float percentPositMsg = 0;
    private JTree allGroupsAndUsers;

    private AdminControlPanel() {
    }
    
    public static AdminControlPanel getAdminControlPanel(){
        if(acp == null){
            acp = new AdminControlPanel();
        }
        return acp;
    }

    public void displayControlPanel() {
        JFrame window = new JFrame("Admin Control Center");
        window.setPreferredSize(new Dimension(800, 600));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jc = adminComponentCompile();
        window.add(jc);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    private JPanel adminComponentCompile(){
        JScrollPane heirViewer = treeGen();
        JPanel buttonPanel = buttonPanelGen();
        
        JPanel backboard = new JPanel(new BorderLayout());
        backboard.add(heirViewer, BorderLayout.WEST);
        backboard.add(buttonPanel, BorderLayout.EAST);
        
        
        return backboard;
    }

    private JScrollPane treeGen() {
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root");
        allGroupsAndUsers = new JTree(top);
        JScrollPane heirViewer = new JScrollPane(allGroupsAndUsers);
        return heirViewer;
    }

    private JPanel buttonPanelGen() {
        JPanel backboard = new JPanel(new GridLayout(7,0));
        JPanel addUserStrip = new JPanel(new GridLayout(0,2));
        JPanel addGroupStrip = new JPanel(new GridLayout(0,2));
        JPanel showGUStrip = new JPanel(new GridLayout(0,2));
        JPanel showMsgPStrip = new JPanel(new GridLayout(0,2));
        JPanel empty0 = new JPanel();
        JPanel empty1 = new JPanel();
        
        JTextField userIDInput = new JTextField();
        JButton addUserID = new JButton("Add User");
        JTextField groupIDInput = new JTextField();
        JButton addGroupID = new JButton("Add Group");
        JButton showTotalUsers = new JButton("Show Total Users");
        JButton showTotalGroups = new JButton("Show Total Groups");
        JButton showTotalMsgs = new JButton("Show Total Messages");
        JButton showPositPercent = new JButton("Show Positive Percentage");
        JButton openUserView = new JButton("Open User View");
        



        addUserStrip.add(userIDInput);
                userIDInput.setColumns(10);
        addUserStrip.add(addUserID);
        addGroupStrip.add(groupIDInput);
                groupIDInput.setColumns(10);
        addGroupStrip.add(addGroupID);
        showGUStrip.add(showTotalUsers);
        showGUStrip.add(showTotalGroups);
        showMsgPStrip.add(showTotalMsgs);
        showMsgPStrip.add(showPositPercent);
        backboard.add(addUserStrip);
        backboard.add(addGroupStrip);
        backboard.add(openUserView);
        backboard.add(empty0);
        backboard.add(empty1);
        backboard.add(showGUStrip);
        backboard.add(showMsgPStrip);
        
        return backboard;
    }
}
