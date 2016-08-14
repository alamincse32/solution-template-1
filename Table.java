/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tigerit.exam;

import static com.tigerit.exam.IO.readLine;
import static com.tigerit.exam.IO.readLineAsInteger;
import java.util.Vector;
import javax.print.DocFlavor;

/**
 *
 * @author Md. Al-Amin
 */
public class Table
{
      
        private  int Column_Number;
        private  int Record_Number;
        private  String Tabble_Name;
        Vector<String> Column_Name; 
        private  long Records[][];
        
        public Table()
        {
            this.Column_Number = 0;
            this.Record_Number = 0;
            this.Tabble_Name = null;
            this.Column_Name = new Vector<String>();
            this.Records = new long[100][100];
            
            Get_Table_Information();
        }

    private void Get_Table_Information() 
    {
        // System.out.println("Enter the name of Table");
         Set_Table_Name(readLine());
        // System.out.println("Enter the number of columns");
        Set_Column_Number_Record_number(readLine());
         //System.out.println("Enter the number of Records");
        // Set_Records_Number(readLineAsInteger());
        // System.out.println("Enter the name of columns");
         Set_Columns_Name();
         //System.out.println("Enter the records of the table");
         Set_Records();
    }

    private void Set_Table_Name(String readLine) 
    {
       this.Tabble_Name = readLine;
    }
    public String Get_Table_Name()
    {
        return this.Tabble_Name;
    }

    private void Set_Column_Number_Record_number(String read)
    {
        String a[] = read.split(" ");
        this.Column_Number = Integer.parseInt(a[0]);
        this.Record_Number = Integer.parseInt(a[1]);

    }
    public int Get_Column_Number()
    {
        return this.Column_Number;
    }

    private void Set_Records_Number(Integer readLineAsInteger)
    {
        this.Record_Number = readLineAsInteger;
    }
    public  int Get_Records_Number()
    {
        return this.Record_Number;
    }

    private void Set_Columns_Name()
    {
//        for(int i = 0; i<Get_Column_Number(); i++)
//        {
//            Column_Name.add(readLine());
//        }
        String columnNames = readLine();
        String[] colNames = columnNames.split(" ");
        for(String col : colNames)
        {
            Column_Name.add(col);
        }

    }
    public Vector<String> Get_Column_Name()
    {
        return this.Column_Name;
    }

    private void Set_Records()
    {
       for(int i = 0; i < this.Record_Number; i++)
       {
           String record = readLine();
           String a[] = record.split(" ");
           for(int j = 0; j < a.length; j++)
           {
               Records[i][j] = Integer.parseInt(a[j]);
           }
       }
    }
    
    public  long[][] Get_Records()
    {
        return this.Records;
    }
}
