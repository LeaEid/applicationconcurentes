package net.cofares.ljug.listecirculaire.ListeCircullaire;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.cofares.ljug.exeptions.ListePleine;
import net.cofares.ljug.exeptions.ListeVide;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ppfar
 */
public class ListeCirculaireTest {

    public ListeCirculaireTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of put method, of class ListeCirculaire.
     */
    @Test
    public void testPut() throws InterruptedException {
        System.out.println("put");
        Integer d = 10;
        ListeCirculaire<Integer> instance = new ListeCirculaire<>(10);
        instance.put(d);
        Integer result = instance.get();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(d, result);

    }

    @Test
    public void testMultiPutGet() throws InterruptedException {
        System.out.println("Multi put get");
        Integer d = 10;
        ListeCirculaire<Integer> instance = new ListeCirculaire<>(10);
        for (int i = 1; i <= 10; i++) {

            instance.put(i);

            assertEquals(i, instance.getNbElem());
        }
        //Maitenant la 
        // TODO review the generated test code and remove the default call to fail.

        instance.put(11);

        //Toujours 10
        assertEquals(10, instance.getNbElem());
        Integer res;
        for (int i = 1; i <= 10; i++) {

            res = instance.get();

            assertEquals(10 - i, instance.getNbElem());
        }

        res = instance.get();

        assertEquals(0, instance.getNbElem());

    }

    /**
     * Test of get method, of class ListeCirculaire.
     *
     * @throws net.cofares.ljug.exeptions.ListePleine
     * @throws net.cofares.ljug.exeptions.ListeVide
     */
    @Test
    @Ignore
    public void testGet() throws InterruptedException {
        System.out.println("get");
        Integer d = 1;
        ListeCirculaire<Integer> instance = new ListeCirculaire<>(1);
        instance.put(d);
        Integer result = instance.get();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(d, result);
    }

    /**
     * Test of estPleine method, of class ListeCirculaire.
     */
    @Test
    @Ignore
    public void testEstPleine() {
        System.out.println("estPleine");
        ListeCirculaire instance = null;
        boolean expResult = false;
        boolean result = instance.estPleine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estVide method, of class ListeCirculaire.
     */
    @Test
    @Ignore
    public void testEstVide() {
        System.out.println("estVide");
        ListeCirculaire instance = null;
        boolean expResult = false;
        boolean result = instance.estVide();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbElem method, of class ListeCirculaire.
     */
    @Test
    public void testGetNbElem() throws InterruptedException {
        System.out.println("getNbElem");
        Integer d = 1;
        ListeCirculaire<Integer> instance = new ListeCirculaire<>(1);

        instance.put(d);
        assertEquals(1, instance.getNbElem());
        Integer result = instance.get();
        assertEquals(0, instance.getNbElem());
        instance.put(d);
        assertEquals(1, instance.getNbElem());
        instance.put(d);
        //Normalement on a pas pu ajouter donc reste 1 ==> il y une exeption
        assertEquals(1, instance.getNbElem());

    }

}
