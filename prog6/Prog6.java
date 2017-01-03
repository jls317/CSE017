/*
 Jeffrey Stewart
 Prog6
 CSE17
 03/04/15
 JLS317
 Purpose: To compile employee pay information given a text document.
          The program will show the name, type, hours, and total pay of
          each employee, as well as the grand total.
 */
package prog6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Prog6 {
    public static void main(String[] args) {
        String line;
        StringBuilder sb = new StringBuilder();
        
        List<Employee> employeeList= new ArrayList<>();
        

        try {
            BufferedReader in
                    = new BufferedReader(new FileReader(args[0]));

            while ((line = in.readLine()) != null) {
                String[] employeeData=line.split("\\s+");
                String name = employeeData[0];
                String type = employeeData[1];
                int hours = Integer.parseInt(employeeData[2]);
                double wage = Double.parseDouble(employeeData[3]);
                double salary = Double.parseDouble(employeeData[4]);
                employeeList.add(Employee.factory(name, type, hours, wage, salary));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
        double total=0;
       
        System.out.printf("%-12s %-12s %12s %12s %n","Name","Type","Hours","Total Pay");
        for(int i = 0 ; i<employeeList.size() ; i++){
           Employee var=  employeeList.get(i);
           System.out.printf("%-12s %-12s %12d %12.2f %n",var.getName(),var.getType(),var.getHours(),var.totalPay()); 
           total+=var.totalPay();
        }
        System.out.printf("%51.2f %n",total);
    }
    
}
