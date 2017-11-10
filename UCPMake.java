
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public class UCPMake {
    private User user;

    public UCPMake(User user) {
        if(this.user == null){
            this.user = user;
        }
        displayUserControlPanel();
    }

    private void displayUserControlPanel() {
        JFrame window = new JFrame("User Control Panel of: Steve");
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
    
}