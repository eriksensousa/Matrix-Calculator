import java.util.Scanner;   //Scanner library. A way to get input from keyboard
import java.util.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nabeel Hussain Syed
 */
public class Main {
public int options;
public static List<Matrix>MatricesData;
public static int matricesInEquation;
public static List<String> EquationElements;

static Scanner userInput = new Scanner(System.in);


    public static void main(String[] args)
    {
        MatricesData = new ArrayList<Matrix>();
        EquationElements = new ArrayList<String>();
        Matrix result = new Matrix();
        System.out.println("**********MATRIX COMPUTER**********");
        String equation;
        String matrixName;
        int row;
        int col;
        int x;
        int z;
        
        for(int y=1; y<=2; y++)
        {
        System.out.println("Enter the name of the "+y+" matrix: "); 
        matrixName = userInput.next();
        System.out.println("Enter the rows of the "+y+" matrix: ");  
        row = userInput.nextInt();
        System.out.println("Enter the columns of the "+y+" matrix: ");  
        col = userInput.nextInt();  
        int[][] MatriceData = new int[row][col];
        for(int p=0; p<row; p++)
        {
            for(int j=0; j<col; j++)
            {
                x = p+1;
                z = j+1;
                System.out.println("Enter value for "+x+" row and "+z+ " column: ");
                MatriceData[p][j] = userInput.nextInt();                
            }
        }
        Matrix b1 = new Matrix(row,col,matrixName,MatriceData);
        MatricesData.add(b1);
        }
              
        System.out.println("Enter the equation(Operands and operators should have spaces in between and for transpose, enter ^ and for inverse, enter inv): ");        
        equation = userInput.nextLine();
        equation = userInput.nextLine();        
        //String[] r = equation.split(" ");
        StringTokenizer stt = new StringTokenizer(equation," ");
            while (stt.hasMoreTokens()){
                String token = stt.nextToken();
                EquationElements.add(token);
            }
        while(true)
        {
            if(EquationElements.size() == 2)
            {
                if(EquationElements.get(1).equals("^"))
                {
                        result = MatricesData.get(0).TransposeOfMatrix(MatricesData.get(0));                        
                        if(result != null)
                        {
                            result.getData();
                            for(int i=0; i<result.getRows(); i++)
                            {
                                for(int j=0; j<result.getColumns(); j++)
                                {                            
                                System.out.print(result.data[i][j]+" ");
                                }
                                System.out.println();
                            }
                            break;
                        }
                        else
                        {
                            System.out.println("Program exiting as the operands are unable to be multiplied");                        
                            System.exit(0);
                        }                    
                }
            }
            else if(EquationElements.size() == 3)
            {
                if(EquationElements.get(1).equals("+") || EquationElements.get(1).equals("*") || EquationElements.get(1).equals("-"))
                {
                    if(EquationElements.get(1).equals("+"))
                    {
                        result = MatricesData.get(0).AddMatrices(MatricesData.get(1));
                        if(result != null)
                        {
                            result.getData();
                            for(int i=0; i<result.getRows(); i++)
                            {
                                for(int j=0; j<result.getColumns(); j++)
                                {                            
                                System.out.print(result.data[i][j]+" ");
                                }
                                System.out.println();
                            }
                            break;
                        }
                        else
                        {
                            System.out.println("Program exiting as the operands are unable to be added");                        
                            System.exit(0);
                        }
                    }
                    else if(EquationElements.get(1).equals("-"))
                    {
                        result = MatricesData.get(0).SubtractMatrices(MatricesData.get(1));
                        if(result != null)
                        {
                            result.getData();
                            for(int i=0; i<result.getRows(); i++)
                            {
                                for(int j=0; j<result.getColumns(); j++)
                                {                            
                                System.out.print(result.data[i][j]+" ");
                                }
                                System.out.println();
                            }
                            break;
                        }
                        else
                        {
                            System.out.println("Program exiting as the operands are unable to be subtracted");                        
                            System.exit(0);
                        }
                    }                  
                    else if(EquationElements.get(1).equals("*"))
                    {
                        if(EquationElements.get(2).matches("\\d+") || EquationElements.get(0).matches("\\d+"))
                        {
                            if(EquationElements.get(0).matches("\\d+"))
                            {
                                result = MatricesData.get(0).ScalarMultiplication(MatricesData.get(0), Integer.parseInt(EquationElements.get(0)));                                
                                result.getData();
                                for(int i=0; i<result.getRows(); i++)
                                {
                                    for(int j=0; j<result.getColumns(); j++)
                                    {                            
                                    System.out.print(result.data[i][j]+" ");
                                    }
                                    System.out.println();
                                }
                                break;    
                            }
                            else if(EquationElements.get(2).matches("\\d+"))
                            {
                                result = MatricesData.get(0).ScalarMultiplication(MatricesData.get(0), Integer.parseInt(EquationElements.get(2)));                                
                                result.getData();
                                for(int i=0; i<result.getRows(); i++)
                                {
                                    for(int j=0; j<result.getColumns(); j++)
                                    {                            
                                    System.out.print(result.data[i][j]+" ");
                                    }
                                    System.out.println();
                                }
                                break;    
                            }                            
                        }
                        else
                        {
                            result = MatricesData.get(0).MultiplyMatrices(MatricesData.get(1));
                            if(result != null)
                            {
                                result.getData();
                                for(int i=0; i<result.getRows(); i++)
                                {
                                    for(int j=0; j<result.getColumns(); j++)
                                    {                            
                                    System.out.print(result.data[i][j]+" ");
                                    }
                                    System.out.println();
                                }
                                break;
                            }
                            else
                            {
                                System.out.println("Program exiting as the operands are unable to be multiplied");                        
                                System.exit(0);
                            }                        
                        }                                                      

                    }                     
                }                    
            
            else if(EquationElements.get(0).equals("^") || EquationElements.get(1).equals("inv"))
            {
            
            }                     

            }

        }       
   }
}
