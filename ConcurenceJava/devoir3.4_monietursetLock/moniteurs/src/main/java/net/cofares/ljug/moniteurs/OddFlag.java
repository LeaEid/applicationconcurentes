/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.ljug.moniteurs;

/**
 *
 * @author Lea
 */
public class OddFlag {
    private volatile boolean isOdd ;
    
    public OddFlag() {
        this.isOdd = false;
    }
    
    synchronized public boolean getIsOdd (){
        return isOdd;
    }

    synchronized public void setIsOdd(boolean isOdd) {
        this.isOdd = isOdd;
    }
    
    
    
}
