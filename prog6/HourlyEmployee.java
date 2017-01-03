/*
 Jeffrey Stewart
 Prog6
 CSE17
 03/04/15
 JLS317
*/
package prog6;

public class HourlyEmployee extends Employee{
    private double wage;
    
    public HourlyEmployee(double wage, String name, int hours){
        super(name, hours);
        this.wage=wage;
    }
    
    public String getType(){
        return "Hourly";
    }
    public double totalPay(){
        double total = wage*hours;
        return total;
    }
}
