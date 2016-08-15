package com.tigerit.exam;


import static com.tigerit.exam.IO.*;
import java.util.Vector;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {

    private int Test = 0;
    private int k = -1;
    private int Table_Number = 0;
    private int Query_Nubmer = 0;
    Vector<Table> tables = new Vector<Table>();
    Vector<Query> querys = new Vector<Query>();
    Vector<String> Table_Name = new Vector<String>();
    Vector<String> Short_Table_Name = new Vector<String>();
    Vector<String> First_Table_Column_Name = new Vector<String>();
    Vector<String> Second_Table_Column_Name = new Vector<String>();
    Vector<String> Conditional_Column = new Vector<String>();
    Vector<Integer> First_Table_Column_number = new Vector<Integer>();
    Vector<Integer> Second_Table_Column_number = new Vector<Integer>();

    private void Set_Test(int a) {
        this.Test = a;
    }

    public int get_Test() {
        return this.Test;
    }

    private void Set_Table_Number(int a) {
        this.Table_Number = a;
    }

    public int get_Table_Number() {
        return this.Table_Number;
    }

    private void Set_Query_Number(int a) {
        this.Query_Nubmer = a;
    }

    public int Get_Query_Number() {
        return this.Query_Nubmer;
    }

    @Override
    public void run() {
        // your application entry point


        //System.out.println("Enter the number of Test case");
        Set_Test(readLineAsInteger());
        // System.out.println(get_Test());
        for (int i = 1; i <= get_Test(); i++) {
//             System.out.println("Enter the number of Table");
            Set_Table_Number(readLineAsInteger());
            for (int j = 1; j <= get_Table_Number(); j++) {
                Table t = new Table();
                tables.add(t);
            }
//             System.out.println("Enter the number of Query");
            Set_Query_Number(readLineAsInteger());
            for (int j = 1; j <= Get_Query_Number(); j++) {
                Query q = new Query();
                querys.add(q);
                System.out.println();
            }

            System.out.println("Test: " + i);
            for (int j = 0; j < querys.size(); j++) {
                Split_Querys(j);
                Run_Query_Operation();
                Clear_Vectors();
                System.out.println();
            }
            FRee_Main_Vector();


//             
//            for(int l = 0; l < Conditional_Column.size();l++ )
//                System.out.println(Conditional_Column.get(l).toString());

            /////JOIN OPERATION///////


        }

        // sample input process
      /*  String string = readLine();
        

        Integer integer = readLineAsInteger();

        // sample output process
        printLine(string);
        printLine(integer);*/
    }

    private void print_Table() {
        for (int i = 0; i < tables.size(); i++) {
            System.out.println(tables.get(i).Get_Table_Name().toString());
            System.out.print(tables.get(i).Get_Records_Number() + " " + tables.get(i).Get_Column_Number());
            System.out.println();
            for (int j = 0; j < tables.get(i).Get_Column_Name().size(); j++) {

                System.out.print(tables.get(i).Get_Column_Name().get(j) + " ");
            }
            System.out.println("");
            for (int k = 0; k < tables.get(i).Get_Records_Number(); k++) {
                for (int j = 0; j < tables.get(i).Get_Column_Number(); j++) {
                    System.out.print(tables.get(i).Get_Records()[k][j] + " ");
                }
                System.out.println("");
            }
            System.out.println(" ");

        }
    }


    private void Print_Query() {
        for (int j = 0; j < querys.size(); j++) {
            System.out.println(querys.get(j).Get_Line_1());
            System.out.println(querys.get(j).Get_Line_2());
            System.out.println(querys.get(j).Get_Line_3());
            System.out.println(querys.get(j).Get_Line_4());

        }


    }

    private void Split_Querys(int j) {
        String line_2 = querys.get(j).Get_Line_2();
        line_2 = line_2.substring(line_2.indexOf(" ") + 1).toString();
        if (line_2.contains(" ")) {
            String a;
            a = line_2.substring(line_2.lastIndexOf(" ") + 1);
            Short_Table_Name.add(a);
            line_2 = line_2.substring(0, line_2.indexOf(" ")).toString();
        }
        Table_Name.add(line_2);


        String line_3 = querys.get(j).Get_Line_3();
        line_3 = line_3.substring(line_3.indexOf(" ") + 1).toString();
        if (line_3.contains(" ")) {
            String a;
            a = line_3.substring(line_3.lastIndexOf(" ") + 1);
            Short_Table_Name.add(a);
            line_3 = line_3.substring(0, line_3.indexOf(" ")).toString();
        }
        Table_Name.add(line_3);

        String line_1 = querys.get(j).Get_Line_1();
        if (line_1.contains("*")) {
            First_Table_Column_Name.add("*");
            Second_Table_Column_Name.add("*");
        } else {
            String s = null;
            String p = null;
            line_1 = line_1.substring(line_1.indexOf(" ")).trim().toString();
            while (line_1.contains(",")) {
                p = line_1.substring(0, line_1.indexOf(","));
                if (p.contains(Short_Table_Name.get(0))) {
                    s = p.substring(p.indexOf(".") + 1);
                    First_Table_Column_Name.add(s);
                } else if (p.contains(Short_Table_Name.get(1))) {
                    s = p.substring(p.indexOf(".") + 1);
                    Second_Table_Column_Name.add(s);
                }
                line_1 = line_1.substring(line_1.indexOf(" ") + 1).trim().toString();
            }

            if (line_1.contains(Short_Table_Name.get(0))) {
                s = line_1.substring(line_1.indexOf(".") + 1);
                First_Table_Column_Name.add(s);
            } else if (line_1.contains(Short_Table_Name.get(1))) {
                s = line_1.substring(line_1.indexOf(".") + 1);
                Second_Table_Column_Name.add(s);
            }
        }

        //  System.out.println(Table_Name.get(0));


        // System.out.println(Table_Name.get(1));


        String line_4 = querys.get(j).Get_Line_4();
        line_4 = line_4.substring(line_4.indexOf(" ") + 1);
        String m = line_4.substring(line_4.indexOf(".") + 1, line_4.indexOf(" ")).trim().toString();
        Conditional_Column.add(m);
        line_4 = line_4.substring(line_4.lastIndexOf(" ") + 1).trim().toString();
        m = line_4.substring(line_4.indexOf(".") + 1).trim();
        Conditional_Column.add(m);


    }


    private void Run_Query_Operation() {
        int First_Table_Number = Get_Table_Number(Table_Name.get(0));
        int Second_Table_Number = Get_Table_Number(Table_Name.get(1));
        // System.out.println(Second_Table_Number);
        int First_Table_Column_Numer = Get_Column_Number(First_Table_Number, Conditional_Column.get(0));
        int Second_Table_Column_Number = Get_Column_Number(Second_Table_Number, Conditional_Column.get(1));

        if (First_Table_Column_Name.get(0).equals("*") && Second_Table_Column_Name.get(0).equals("*")) {
            for (int i = 0; i < tables.get(First_Table_Number).Get_Column_Name().size(); i++) {
                System.out.print(tables.get(First_Table_Number).Get_Column_Name().get(i) + " ");
            }
            for (int i = 0; i < tables.get(Second_Table_Number).Get_Column_Name().size(); i++) {
                System.out.print(tables.get(Second_Table_Number).Get_Column_Name().get(i) + " ");
            }
            System.out.println();
            for (int i = 0; i < tables.get(First_Table_Number).Get_Records_Number(); i++) {
                for (int j = 0; j < tables.get(Second_Table_Number).Get_Records_Number(); j++) {
                    if (tables.get(First_Table_Number).Get_Records()[i][First_Table_Column_Numer] == tables.get(Second_Table_Number).Get_Records()[j][Second_Table_Column_Number]) {
                        for (int k = 0; k < tables.get(First_Table_Number).Get_Column_Number(); k++) {
                            System.out.print(tables.get(First_Table_Number).Get_Records()[i][k] + " ");
                        }
                        for (int k = 0; k < tables.get(Second_Table_Number).Get_Column_Number(); k++) {
                            System.out.print(tables.get(Second_Table_Number).Get_Records()[j][k] + " ");
                        }
                        System.out.println();
                    }

                }
            }
        } else {
            for (int i = 0; i < First_Table_Column_Name.size(); i++) {
                System.out.print(First_Table_Column_Name.get(i) + " ");
            }
            for (int i = 0; i < Second_Table_Column_Name.size(); i++) {
                System.out.print(Second_Table_Column_Name.get(i) + " ");
            }
            System.out.println();

            Get_First_Table_Column_Number(First_Table_Number);
            Get_Second_Table_Column_Number(Second_Table_Number);


            for (int i = 0; i < tables.get(First_Table_Number).Get_Records_Number(); i++) {
                for (int j = 0; j < tables.get(Second_Table_Number).Get_Records_Number(); j++) {
                    if (tables.get(First_Table_Number).Get_Records()[i][First_Table_Column_Numer] == tables.get(Second_Table_Number).Get_Records()[j][Second_Table_Column_Number]) {
                        for (int k = 0; k < First_Table_Column_number.size(); k++) {
                            System.out.print(tables.get(First_Table_Number).Get_Records()[i][First_Table_Column_number.get(k)] + " ");
                        }
                        for (int k = 0; k < Second_Table_Column_number.size(); k++) {
                            System.out.print(tables.get(Second_Table_Number).Get_Records()[j][Second_Table_Column_number.get(k)] + " ");
                        }
                        System.out.println();
                    }

                }
            }


        }


    }

    private int Get_Table_Number(String get) {

        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).Get_Table_Name().equals(get)) {
                k = i;
            }

        }
        return this.k;
    }

    private int Get_Column_Number(int Table_Number, String get) {
        for (int i = 0; i < tables.get(Table_Number).Get_Column_Name().size(); i++) {
            if (tables.get(Table_Number).Get_Column_Name().get(i).equals(get)) {
                k = i;
            }
        }
        return this.k;
    }

    private void Clear_Vectors() {

        Table_Name.clear();
        First_Table_Column_Name.clear();
        Second_Table_Column_Name.clear();
        Conditional_Column.clear();
        this.k = -1;
    }

    private void FRee_Main_Vector() {
        tables.clear();
        querys.clear();
        Table_Number = 0;
        Query_Nubmer = 0;
    }

    private void Get_First_Table_Column_Number(int a) {
        for (int i = 0; i < First_Table_Column_Name.size(); i++) {
            for (int j = 0; j < tables.get(a).Get_Column_Number(); j++) {
                if (First_Table_Column_Name.get(i).equals(tables.get(a).Get_Column_Name().get(j))) {
                    First_Table_Column_number.add(j);
                }
            }
        }
//        for(int i =0; i  < First_Table_Column_number.size(); i++)
//            System.out.print(First_Table_Column_number.get(i));
    }

    private void Get_Second_Table_Column_Number(int Sec_Table_Number) {
        for (int i = 0; i < Second_Table_Column_Name.size(); i++) {
            for (int j = 0; j < tables.get(Sec_Table_Number).Get_Column_Number(); j++) {
                if (Second_Table_Column_Name.get(i).equals(tables.get(Sec_Table_Number).Get_Column_Name().get(j)))
                {
                    Second_Table_Column_number.add(j);
                }
            }
        }
    }
}


