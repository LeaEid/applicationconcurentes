/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.garde;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Garde {

    private boolean garde;

    public Garde(boolean g) {
        //On initialise la garde
        garde = g;
    }
    /**
     * @return the garde
     */
    public synchronized boolean isGarde() {
        return garde;
    }

    //when(garde) => action
    public synchronized void garde() {
        while (!isGarde()) try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Garde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //when(!garde) => action
    public synchronized void notGarde() {
        while (isGarde()) try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Garde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param garde the garde to set
     */
    public synchronized void setGarde(boolean garde) {
        //vérifier si la va;leur de la garde a changé
        //Si oui faire notifyAll
        if (this.garde != garde) {
            this.garde = garde;
            notifyAll();       
        }
        
    }

}
