/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.ausiasmarch.neptuno.dao;

import java.sql.Connection;
import java.util.List;
import net.ausiasmarch.neptuno.entity.Empleado;
import net.ausiasmarch.neptuno.model.DBConnection;
import net.ausiasmarch.neptuno.model.DriverType;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author a048598270y
 */
public class EmpleadoDAOTest {
    
    private static Connection conn;
    
    public EmpleadoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        conn = DBConnection.instance.getConnection(DriverType.ACCESS);
        EmpleadoDAO empleado = new EmpleadoDAO();
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
     * Test of create method, of class EmpleadoDAO.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Empleado t = null;
        EmpleadoDAO instance = new EmpleadoDAO();
        instance.create(t);

    }

    /**
     * Test of update method, of class EmpleadoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Empleado t = null;
        EmpleadoDAO instance = new EmpleadoDAO();
        instance.update(t);

    }

    /**
     * Test of delete method, of class EmpleadoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        EmpleadoDAO instance = new EmpleadoDAO();
        instance.delete(id);

    }

    /**
     * Test of insertOrUpdate method, of class EmpleadoDAO.
     */
    @Test
    public void testInsertOrUpdate() {
        System.out.println("insertOrUpdate");
        Empleado t = null;
        EmpleadoDAO instance = new EmpleadoDAO();
        instance.insertOrUpdate(t);

    }

    /**
     * Test of findById method, of class EmpleadoDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        EmpleadoDAO instance = new EmpleadoDAO();
        Empleado expResult = null;
        Empleado result = instance.findById(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of findAll method, of class EmpleadoDAO.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        EmpleadoDAO instance = new EmpleadoDAO();
        List<Empleado> expResult = null;
        List<Empleado> result = instance.findAll();
        assertEquals(expResult, result);

    }

    /**
     * Test of newKey method, of class EmpleadoDAO.
     */
    @Test
    public void testNewKey() {
        System.out.println("newKey");
        EmpleadoDAO instance = new EmpleadoDAO();
        Long expResult = null;
        Long result = instance.newKey();
        assertEquals(expResult, result);

    }

    /**
     * Test of cargo method, of class EmpleadoDAO.
     */
    @Test
    public void testCargo() {
        System.out.println("cargo");
        EmpleadoDAO instance = new EmpleadoDAO();
        List<String> expResult = null;
        List<String> result = instance.cargo();
        assertEquals(expResult, result);

    }

    /**
     * Test of idOficina method, of class EmpleadoDAO.
     */
    @Test
    public void testIdOficina() {
        System.out.println("idOficina");
        EmpleadoDAO instance = new EmpleadoDAO();
        List<Integer> expResult = null;
        List<Integer> result = instance.idOficina();
        assertEquals(expResult, result);

    }
    
}
