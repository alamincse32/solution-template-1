/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tigerit.exam;

import static com.tigerit.exam.IO.readLine;

/**
 *
 * @author Md. Al-Amin
 */
public class Query 
{
    private String Line_1;
    private String Line_2;
    private String Line_3;
    private String Line_4;
    
    public Query()
    {
        this.Line_1 = null;
        this.Line_2 = null;
        this.Line_3 = null;
        this.Line_4 = null;
        
        Read_Query();
    }

    private void Read_Query() 
    {
        Read_Line_1();
        Read_Line_2();
        Read_Line_3();
        Read_Line_4();  
    }

    private void Read_Line_1() 
    {
        this.Line_1 = readLine();
    }
    public String Get_Line_1()
    {
        return  this.Line_1;
    }
    private void Read_Line_2() 
    {
        this.Line_2 = readLine();
    }
    public String Get_Line_2()
    {
        return  this.Line_2;
    }
    private void Read_Line_3() 
    {
        this.Line_3 = readLine();
    }
    public String Get_Line_3()
    {
        return  this.Line_3;
    }
    private void Read_Line_4() 
    {
        this.Line_4 = readLine();
    }
    public String Get_Line_4()
    {
        return  this.Line_4;
    }
    
}
