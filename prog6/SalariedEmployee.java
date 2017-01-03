/*
 Jeffrey Stewart
 Prog6
 CSE17
 03/04/15
 JLS317
*/
package prog6;

public class SalariedEmployee extends Employee{
    private double salary;
    public SalariedEmployee(double salary, String name, int hours){
        super(name, hours);
        this.salary=salary;
    }
    
    public String getType(){
        return "Salaried";
    }
    public double totalPay(){
        double total = salary/52;
        return total;
    }
}
