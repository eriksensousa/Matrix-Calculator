/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;   //Scanner library. A way to get input from keyboard
import java.util.*;
/**
 *
 * @author Nabeel Hussain Syed
 */
public class Matrix {
private String name;
private int rows;
private int columns;
public int[][] data;

    public Matrix(int row, int col, String nam, int[][] dat)
    {
        this.rows = row;
        this.columns = col;
        this.name = name;
        this.data = dat;
    }
    
    public Matrix()
    {
        this.rows= 0;
        this.columns = 0;
        this.name = null;
        this.data = null;        
    }
    
    public void setData(int[][] values)
    {
        this.data = values;
    }
    
    public int[][] getData()
    {
        return data;
    }
    
    public void setName(String Name)
    {
        this.name = Name;
    }

    public String getName()
    {
        return name;
    }

    public void setRows(int row)
    {
        this.rows = row;
    }
    
    public int getRows()
    {
        return rows;
    }

    public void setColumns(int cols)
    {
        this.columns = cols;
    }
    
    public int getColumns()
    {
        return columns;
    }

    public boolean checkAdditionAndSubtraction(Matrix matrix)
    {
        if(this.getRows() == matrix.rows && this.getColumns()==matrix.columns)
        return true;
        else
        return false;
    }
    
    public Matrix AddMatrices (Matrix matrix)
    {
       Matrix AddedMatrix = new Matrix(this.getRows(), this.getColumns(), this.getName(), this.getData());
       if(checkAdditionAndSubtraction(matrix))       
       {
           for (int i = 0; i < this.getRows(); i++) 
           {
            for (int j = 0; j < matrix.getColumns(); j++) 
            {
            AddedMatrix.data[i][j] = this.data[i][j] + matrix.data[i][j];
            }
           }
           return AddedMatrix;
       }
       else
       {
           System.out.println("Unable to add matrices");
           return null;           
       }
    }
    
    public Matrix SubtractMatrices (Matrix matrix)
    {
       Matrix SubtractedMatrix = new Matrix(this.getRows(), this.getColumns(), this.getName(), this.getData());
       if(checkAdditionAndSubtraction(matrix))       
       {
           for (int i = 0; i < this.getRows(); i++) 
           {
            for (int j = 0; j < matrix.getColumns(); j++) 
            {
            SubtractedMatrix.data[i][j] = this.data[i][j] - matrix.data[i][j];
            }
           }
           return SubtractedMatrix;
       }
       else
       {
           System.out.println("Unable to subtract matrices");
           return null;
       }
    }
    
    
    public boolean checkMultiplication(Matrix matrix)
    {
        if(this.getColumns() == matrix.getRows())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
        
    public Matrix MultiplyMatrices(Matrix matrix)
    {
        Matrix MultipliedMatrix = new Matrix(this.getRows(), matrix.getColumns(), this.getName(), this.getData());        
        if(checkMultiplication(matrix))
        {
            for (int i = 0; i < this.getRows(); i++)
            {
                for (int j = 0; j < matrix.getColumns(); j++)
                {
                    for (int k = 0; k < this.getColumns(); k++)
                    {
                    MultipliedMatrix.data[i][j] = MultipliedMatrix.data[i][j] + this.data[i][k] * matrix.data[k][j];
                    }
                }
            }
            return MultipliedMatrix;
        }
        else
        {
           System.out.println("Unable to multiply matrices");
           return null;            
        }
    }

    
    public Matrix TransposeOfMatrix(Matrix matrix)
    {
        Matrix TranposedMatrix = new Matrix(this.getRows(), this.getColumns(), this.getName(), this.getData());              
        for (int i = 0; i < matrix.getRows(); i++) 
        {
           for (int j = 0; j < matrix.getColumns(); j++) 
           {
            TranposedMatrix.data[i][j] = this.data[j][i];
           }
        }
        return TranposedMatrix;
    }   

    
    public Matrix ScalarMultiplication(Matrix matrix, int scalar)
    {
        Matrix ScalarMultipliedMatrix = new Matrix(this.getRows(), this.getColumns(), this.getName(), this.getData());              
        for (int i = 0; i < matrix.getRows(); i++) 
        {
           for (int j = 0; j < matrix.getColumns(); j++) 
           {
            ScalarMultipliedMatrix.data[i][j] = scalar * matrix.data[i][j];
           }
        }
        return ScalarMultipliedMatrix;
    }           
}
