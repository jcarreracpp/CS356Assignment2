/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public interface UserHusk {
    
    public void subscribeFollower(User us);
    
    public void unsubscribeFollower();
    
    public void notifyFollowers(User us);
    
    public void notifyFollowers();
}
