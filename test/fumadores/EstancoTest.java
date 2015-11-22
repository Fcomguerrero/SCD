/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fumadores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fcis
 */
public class EstancoTest {
    
    public EstancoTest() {
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
     * Test of obtenerIngrediente method, of class Estanco.
     */
    @Test
    public void testObtenerIngrediente() {
        System.out.println("obtenerIngrediente");
        int miIngrediente = 0;
        Estanco instance = new Estanco();
        instance.obtenerIngrediente(miIngrediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ponerIngrediente method, of class Estanco.
     */
    @Test
    public void testPonerIngrediente() {
        System.out.println("ponerIngrediente");
        int ingrediente = 0;
        Estanco instance = new Estanco();
        instance.ponerIngrediente(ingrediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esperarRecogidaIngrediente method, of class Estanco.
     */
    @Test
    public void testEsperarRecogidaIngrediente() {
        System.out.println("esperarRecogidaIngrediente");
        Estanco instance = new Estanco();
        instance.esperarRecogidaIngrediente();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
