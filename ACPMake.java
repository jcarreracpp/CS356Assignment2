
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
        backboard.add(heirViewer);
        backboard.add(buttonPanel, BorderLayout.EAST);
        
        
        return backboard;
    }
    
    private JScrollPane treeGen() {
        Driver.userBacklog.add(0, new User("Root"));
        Driver.userNames.add(0, Driver.userBacklog.get(0).sendName());
        Driver.allList = new JList(Driver.userNames);
        acp.setAllGroupsAndUsers(Driver.allList);
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
    private String heirArchy(String str){
        int space = 0;
//        String trim = new String();
//        trim = str;
//        trim = trim.trim();
        space = (str.length() - str.trim().length());
        str = "";
        System.out.println("SPACE: "+space);
        for(int i = 0; i < space; i++){
            str = str + "  ";
        }
        if(space == 0)
            str = str + "  ";
        return str;
    }
    private boolean alreadyExists(String str){
        str = str.trim();
        for(int i = 0; i < Driver.userNames.size(); i++){
            if(Driver.userNames.get(i).trim().equals(str)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("addNewUser")){
            if(!Driver.allList.isSelectionEmpty() && !acp.sendUserIDInput().getText().equals("")
                    && !alreadyExists(acp.sendUserIDInput().getText())){
                Driver.userBacklog.addElement(new User(acp.sendUserIDInput().getText()));
                String buffer = heirArchy(Driver.allList.getSelectedValue());
                Driver.userNames.addElement(buffer + acp.sendUserIDInput().getText());
                acp.setUserIDInput("");
                Driver.totalUsers++;
            }
        }
        if(e.getActionCommand().equals("addNewGroup")){
            System.out.println("\t"+acp.sendGroupIDInput().getText());
            acp.setGroupIDInput("");
            Driver.totalGroups++;
        }
        if(e.getActionCommand().equals("userView")){
            if(!Driver.allList.isSelectionEmpty()){
                try{
                Driver.userBacklog.getElementAt(Driver.allList.getSelectedIndex()).accept(new PanelMakeVisitor());
                } catch(Exception ex){
                
                }
            }
        }
        if(e.getActionCommand().equals("userCount")){
            JOptionPane.showMessageDialog (null, Driver.totalUsers, "Total Users Count", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getActionCommand().equals("groupCount")){
            JOptionPane.showMessageDialog (null, Driver.totalGroups, "Total Groups Count", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getActionCommand().equals("messageCount")){
            JOptionPane.showMessageDialog (null, Driver.totalMessages, "Total Messages", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getActionCommand().equals("positivePercent")){
            float positPercent = ((float)Driver.positiveMessages / (float)Driver.totalMessages);
            positPercent = (positPercent*100);
            if(positPercent != positPercent)
                positPercent = 0.0f;
            JOptionPane.showMessageDialog (null, positPercent, "Percent of Positive Messages", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
