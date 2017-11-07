
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public class ACPMake implements ActionListener{
    private AdminControlPanel acp = null;
    
    public ACPMake(AdminControlPanel acp){
        if(this.acp == null){
            this.acp = acp;
        }
        displayControlPanel();
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
        acp.setAllGroupsAndUsers(new JTree(top));
        JScrollPane heirViewer = new JScrollPane(acp.sendAllGroupsAndUsers());
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
        PButton au = new PButton().addUser();
        PButton ag = new PButton().addGroup();
        PButton su = new PButton().showUsers();
        PButton sg = new PButton().showGroups();
        PButton sm = new PButton().showMessages();
        PButton sp = new PButton().showPercent();
        PButton uv = new PButton().userView();
        au.addActionListener(this);
        ag.addActionListener(this);
        su.addActionListener(this);
        sg.addActionListener(this);
        sm.addActionListener(this);
        sp.addActionListener(this);
        uv.addActionListener(this);

        addUserStrip.add(acp.sendUserIDInput());
                //userIDInput.setColumns(10);
        addUserStrip.add(au);
        addGroupStrip.add(acp.sendGroupIDInput());
                //groupIDInput.setColumns(10);
        addGroupStrip.add(ag);
        showGUStrip.add(su);
        showGUStrip.add(sg);
        showMsgPStrip.add(sm);
        showMsgPStrip.add(sp);
        backboard.add(addUserStrip);
        backboard.add(addGroupStrip);
        backboard.add(uv);
        backboard.add(empty0);
        backboard.add(empty1);
        backboard.add(showGUStrip);
        backboard.add(showMsgPStrip);
        
        return backboard;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("addNewUser")){
            System.out.println("\t"+acp.sendUserIDInput().getText());
            acp.setUserIDInput("");
        }
        if(e.getActionCommand().equals("addNewGroup")){
            System.out.println("\t"+acp.sendGroupIDInput().getText());
            acp.setGroupIDInput("");
        }
    }
}
