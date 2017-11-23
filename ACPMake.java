import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Jorge
 * 
 * Makes the GUI aspect of the admin control panel and handles the organization
 * of the element display list on the left.
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
        Driver.userBacklog.add(0, new Group("Root"));
        Driver.userNames.add(0, ((Group)Driver.userBacklog.get(0)).sendName());
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
        PButton vi = new PButton().verifyIDs();
        PButton lu = new PButton().latestUser();
        au.addActionListener(this);
        ag.addActionListener(this);
        su.addActionListener(this);
        sg.addActionListener(this);
        sm.addActionListener(this);
        sp.addActionListener(this);
        uv.addActionListener(this);
        vi.addActionListener(this);
        lu.addActionListener(this);

        addUserStrip.add(acp.sendUserIDInput());
        addUserStrip.add(au);
        addGroupStrip.add(acp.sendGroupIDInput());
        addGroupStrip.add(ag);
        showGUStrip.add(su);
        showGUStrip.add(sg);
        showMsgPStrip.add(sm);
        showMsgPStrip.add(sp);
        backboard.add(addUserStrip);
        backboard.add(addGroupStrip);
        backboard.add(uv);
        empty0.add(vi);
        backboard.add(empty0);
        empty1.add(lu);
        backboard.add(empty1);
        backboard.add(showGUStrip);
        backboard.add(showMsgPStrip);
        
        return backboard;
    }
    private String heirArchy(String str, boolean isthisagroup){
        int space = 0;

        space = (str.length() - str.trim().length());
        space = space/2;
        if(space == 0)
            space = 1;
        str = "";

        if(Driver.allList.getSelectedIndex() == 0){
            str = "  ";

        }else if(!Driver.userBacklog.get(Driver.allList.getSelectedIndex()).labeledGroup()){
            for(int i = 0; i < space; i++){
                str = str + "  ";
            }

        }else{
            for(int i = 0; i < space; i++){
                str = str + "  ";
            }
            str = str + "  ";

        }
        if(isthisagroup){
            str = str + "GROUP: ";
        }
            
        return str;
    }
    private boolean alreadyExists(String str){
        str = str.trim();
        for(int i = 0; i < Driver.userNames.size(); i++){
            if(Driver.userNames.get(i).trim().equals(str) || Driver.userNames.get(i).trim().equals("GROUP: " + str)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("addNewUser")){
            if(!Driver.allList.isSelectionEmpty() && !acp.sendUserIDInput().getText().equals("")
                    && !alreadyExists(acp.sendUserIDInput().getText())){
                Driver.userBacklog.add(Driver.allList.getSelectedIndex()+1, new User(acp.sendUserIDInput().getText()));
                String buffer = heirArchy(Driver.allList.getSelectedValue(), false);
                Driver.userNames.add(Driver.allList.getSelectedIndex()+1, buffer + acp.sendUserIDInput().getText());
                acp.setUserIDInput("");
                Driver.totalUsers++;
            }
        }
        if(e.getActionCommand().equals("addNewGroup")){
            if(!Driver.allList.isSelectionEmpty() && !acp.sendGroupIDInput().getText().equals("")
                    && !alreadyExists(acp.sendGroupIDInput().getText())){
                Driver.userBacklog.addElement(new Group(acp.sendGroupIDInput().getText()));
                String buffer = heirArchy(Driver.allList.getSelectedValue(), true);
                Driver.userNames.addElement(buffer + acp.sendGroupIDInput().getText());
                acp.setGroupIDInput("");
                Driver.totalGroups++;
            }
        }
        if(e.getActionCommand().equals("userView")){
            if(!Driver.allList.isSelectionEmpty()){
                try{
                ((User)Driver.userBacklog.getElementAt(Driver.allList.getSelectedIndex())).accept(new PanelMakeVisitor());
                    Driver.userBacklog.getElementAt(Driver.allList.getSelectedIndex()).printCreationTime();
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
            JOptionPane.showMessageDialog (null, (int)positPercent + "%", "Percent of Positive Messages", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(e.getActionCommand().equals("verifyID")){
            boolean incorrect = false;
            for(int i = 0; i < Driver.userBacklog.getSize(); i++){
                if(Driver.userBacklog.getElementAt(i).sendName().indexOf(" ") != -1){
                    incorrect = true;
                }
            }
            
            if(incorrect){
                JOptionPane.showMessageDialog (null, "Group/User IDs are not valid!", "Verify ID", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog (null, "Group/User IDs are valid.", "Verify ID", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(e.getActionCommand().equals("lastUser")){
            ClientHusk temp = null;
            for(int i = 0; i < Driver.userBacklog.getSize(); i++){
                //try{
                    if(temp == null){
                        temp = Driver.userBacklog.get(i);
                    }else if((temp).getLastUpdated() < (Driver.userBacklog.get(i)).getLastUpdated()){
                        temp = Driver.userBacklog.get(i);
                    }
                //}catch(Exception ex){}
            }
            
            if(temp == Driver.userBacklog.get(0) || temp == null){
                JOptionPane.showMessageDialog (null, "Error, no users exist or no one has posted!", "Latest updated User", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog (null, temp.sendName() + " is the latest updated user.", "Latest updated User", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
