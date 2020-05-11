/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package net.cofares.ljug.moniteurs;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class Compteur2En2 implements Runnable{
    private final int DEBUT;
    private final int FIN;
    private final boolean isEvenNumber;
    private final Printer print = new Printer();
    
    public Compteur2En2(int d, int f, boolean isEven) {
        DEBUT=d; 
        FIN=f;
        isEvenNumber = isEven;
    }
    
    @Override
    public void run () {
        System.out.printf("\nDebut du thread %s\n",Thread.currentThread());
        for (int i=DEBUT; i<FIN; i+=2){
            if (isEvenNumber) {
                print.printEven(i);
            } else {
                print.printOdd(i);
            }
        }
        System.out.printf("\nfin du thread %s\n",Thread.currentThread());
    }
}