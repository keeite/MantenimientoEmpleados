/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import net.ausiasmarch.neptuno.dao.EmpleadoDAO;
import net.ausiasmarch.neptuno.entity.Empleado;
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
public class TestEmpleados {
    
    public TestEmpleados() {
    }
    
    @BeforeClass
    public static void beforeClass() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        
    }
    
    @AfterClass
    public static void afterClass() {
    }
    
    @Before
    public void before() {
        Empleado empleado = new Empleado(1000, "Ambrosio", "Eustaquio", "Pamplona", "astronauta", 2, new Date(30/02/1933), new Date(23/04/1563));
    }
    
    @After
    public void after() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//    @Test
//    public void testCreate() {
//        assertNotNull(empleado);
//    }
}
