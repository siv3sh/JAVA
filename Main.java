class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    // Getters
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDesignation() { return designation; }

    // Bonus calculation (overridden in derived classes)
    public double calculateBonus() {
        return 0;
    }

    // Display employee info
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        
        // Basic validation
        if(hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("Hourly rate must be positive. Setting to 0.");
            this.hourlyRate = 0;
        }
        
        if(hoursWorked >= 0 && hoursWorked <= 168) {
            this.hoursWorked = hoursWorked;
        } else {
            System.out.println("Hours worked must be between 0 and 168. Setting to 0.");
            this.hoursWorked = 0;
        }
    }

    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateBonus() {
        return calculateWeeklySalary() * 0.10;  // 10% bonus
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Bonus: $" + calculateBonus());
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        
        // Basic validation
        if(monthlySalary > 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Monthly salary must be positive. Setting to 0.");
            this.monthlySalary = 0;
        }
    }

    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.15;  // 15% bonus
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Monthly Salary: $" + monthlySalary);
        System.out.println("Weekly Salary: $" + calculateWeeklySalary());
        System.out.println("Bonus: $" + calculateBonus());
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an Hourly Employee
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Alice Smith", "Adjunct Professor", 50, 35);
        hourlyEmployee.displayInfo();
        System.out.println();

        // Create a Salaried Employee
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Bob Johnson", "Assistant Professor", 4000);
        salariedEmployee.displayInfo();
    }
}
