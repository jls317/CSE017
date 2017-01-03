/*
 Jeffrey Stewart
 Prog6
 CSE17
 03/04/15
 JLS317
*/
package prog6;

public abstract class Employee {
    protected String name;
    protected int hours;
    
    //Getters
    public String getName(){
        return name;
    }
    public int getHours(){
        return hours;
    }
    public abstract double totalPay();
    public abstract String getType();
    public Employee(String name, int hours){
        this.name=name;
        this.hours=hours;
    }
    public static Employee factory(String name, String type, int hours, double wage, double salary) throws IllegalArgumentException {
        String typeLower= type.toLowerCase();
        Employee emp;
        try{
        if(typeLower.equals("salaried")){
            emp = new SalariedEmployee(salary, name, hours);
            return emp;
        }
        else if(typeLower.equals("hourly")){
            emp = new HourlyEmployee(wage, name, hours); 
            return emp;
        }
        else{
            throw new IllegalArgumentException();
        }
        }
        catch(IllegalArgumentException ex){
            System.out.print(ex.getMessage());
            return null;
        }
    }
    
    
}
