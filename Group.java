/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public class Group implements GroupHusk{

    @Override
    public void subscribeTo(ClientHusk ck) {
        throw new UnsupportedOperationException("Groups cannot subscribe!");
    }

    @Override
    public void notifyFollowers(String str) {
        throw new UnsupportedOperationException("Groups cannot message!");
    }
    
}
