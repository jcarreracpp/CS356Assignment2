import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author Jorge
 * 
 * Makes the GUI aspect of the user control panel and handles following list,
 * feed, adding users to follow, and sending messages.
 */
public class UCPMake implements ActionListener{
    private User user;

    public UCPMake(User user) {
        if(this.user == null){
            this.user = user;
        }
        displayUserControlPanel();
    }

    private void displayUserControlPanel() {
        JFrame window = new JFrame("User Control Panel of: " + user.sendName());
        window.setPreferredSize(new Dimension(400, 500));
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel jc = userComponentCompile();
        window.add(jc);
        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private JPanel userComponentCompile() {
        PButton pb;
        JPanel backboard = new JPanel(new GridLayout(2,0));
        JPanel topHalf = new JPanel(new GridBagLayout());
        JPanel botHalf = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        topHalf.add(user.sendUserIDInput(), gbc);
        pb = new PButton().followUser();
        pb.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        topHalf.add(pb, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        topHalf.add(user.sendFollowing(), gbc);
        backboard.add(topHalf);
        
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        botHalf.add(user.sendUserMessage(), gbc);
        pb = new PButton().sendMessage();
        pb.addActionListener(this);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        botHalf.add(pb, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        botHalf.add(user.sendFeed(), gbc);
        backboard.add(botHalf);
        
        return backboard;
    }
    
    private boolean userNameExists(String str){
        String temp = str.trim();
        boolean result = false;
        for(int i = 0; i < Driver.userNames.size(); i++){
            if(temp.equals(Driver.userNames.get(i).trim())){
                result = true;
            }
        }
        return result;
    }
    private void isPositive(String str) {
        if(str.toLowerCase().indexOf("great") >= 0 || str.toLowerCase().indexOf("good") >= 0
                || str.toLowerCase().indexOf("nice") >= 0){
            Driver.positiveMessages++;
        }
    }
    private int findID(String str){
        str = str.trim();
        for(int i = 0; i < Driver.userNames.size(); i++){
            if(str.equals(Driver.userNames.get(i).trim())){
                return i;
            }
        }
        return 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("follow")){
            int iD = 0;

            if(userNameExists(user.sendUserIDInput().getText())){
                iD = findID(user.sendUserIDInput().getText());
                
                if(iD != 0){
                    user.follow((User)Driver.userBacklog.elementAt(iD));

                }
                user.sendUserIDInput().setText("");
            }
        }
        
        if(e.getActionCommand().equals("sendMsg")){
            user.notifyFollowers(user.sendUserMessage().getText());
            isPositive(user.sendUserMessage().getText());
            user.sendUserMessage().setText("");
        }
    }
}
