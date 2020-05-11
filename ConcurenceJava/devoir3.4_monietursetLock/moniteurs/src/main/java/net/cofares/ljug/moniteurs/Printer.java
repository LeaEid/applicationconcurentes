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
public class Printer {
    private OddFlag oddFlag = new OddFlag();
    
    synchronized void printEven(int number) {
        try {
            while (oddFlag.getIsOdd()) { // isOdd [is not even]--> wait
                System.out.printf("EVEN THREAD WAIT\n");
                wait();
            }
            // is Even -- > print & notify ODD Thread
            System.out.printf("%d\n ", number); // print even number
            oddFlag.setIsOdd(true);  
            notifyAll(); // wake up odd thread
            System.out.printf("NOTIFIED\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } 
    }
    
    synchronized void printOdd(int number) {
        try {
            while (!oddFlag.getIsOdd()) { // !isOdd --> wait
                System.out.printf("ODD THREAD WAIT\n");
                wait();
            }
            // is Odd -- > print & notify EVEN Thread
            System.out.printf("%d\n ", number); // print odd number
            oddFlag.setIsOdd(false);
            notifyAll(); // wake up even thread
            System.out.printf("NOTIFIED\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }  
    }
    
}
