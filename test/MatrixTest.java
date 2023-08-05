/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nabeel Hussain Syed
 */
public class MatrixTest {
  
    @Test
    public void testAddMatrices() {
        int data[][];
        data = new int[2][2];
        String someMatrix = "Some matrix";
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<2; j++)
            {
                data[i][j]=2;
            }
        }
        Matrix m1 = new Matrix(2,2,someMatrix, data);
        Matrix m2 = new Matrix(2,2,someMatrix, data);
        Matrix m3 = m1.AddMatrices(m2);
        int expected[][]={{4,4},{4,4}};
        assertArrayEquals(expected, m3.data);
    }

    /**
     * Test of SubtractMatrices method, of class Matrix.
     */
    @Test
    public void testSubtractMatrices() {
 int data[][];
        data = new int[2][2];
        String someMatrix = "Some matrix";
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<2; j++)
            {
                data[i][j]=2;
            }
        }
        Matrix m1 = new Matrix(2,2,someMatrix, data);
        Matrix m2 = new Matrix(2,2,someMatrix, data);
        Matrix m3 = m1.AddMatrices(m2);
        int expected[][]={{4,4},{4,4}};
        assertArrayEquals(expected, m3.data);
    }
    
    

    /**
     * Test of MultiplyMatrices method, of class Matrix.
     */
    @Test
    public void testMultiplyMatrices() {
    int data[][];
    String someMatrix = "Some Matrix";
            data = new int[2][2];
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<2; j++)
            {
                data[i][j]=2;
            }
        }
       
        Matrix m1 = new Matrix(2,2,someMatrix, data);
        Matrix m2 = new Matrix(2,2,someMatrix, data);
        Matrix m3 = m1.MultiplyMatrices(m2);     
        int expected[][]={{10,66},{66,18996522}};        
        assertArrayEquals(expected, m3.data);

    }

    /**
     * Test of TransposeOfMatrix method, of class Matrix.
     */
    @Test
    public void testTransposeOfMatrix() {
    int data[][] = {{1,2},{3,4}};
        String someMatrix = "Some matrix";

        Matrix m1 = new Matrix(2,2,someMatrix, data);
        Matrix m3 = m1.TransposeOfMatrix(m1);
        int expected[][]={{1,3},{3,4}};
        assertArrayEquals(expected, m1.data);
    }

    /**
     * Test of ScalarMultiplication method, of class Matrix.
     */
    @Test
    public void testScalarMultiplication() {
        int data[][] = {{1,1},{1,1}};
        String someMatrix = "Some matrix";
        Matrix m1 = new Matrix(2,2,someMatrix, data);
        Matrix m3 = m1.ScalarMultiplication(m1, 2);
        int expected[][]={{2,2},{2,2}};
        assertArrayEquals(expected, m3.data);    
    }
    
}
