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
        this.hourlyRate = (hourlyRate > 0) ? hourlyRate : 0;
        this.hoursWorked = (hoursWorked >= 0 && hoursWorked <= 168) ? hoursWorked : 0;  // Max 168 hours per week
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
        this.monthlySalary = (monthlySalary > 0) ? monthlySalary : 0;
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

class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        
        // Basic validation
        this.bonusPercentage = (bonusPercentage >= 0 && bonusPercentage <= 100) ? bonusPercentage : 0;
    }

    // Override calculateBonus to add executive bonus
    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus();
        double executiveBonus = (getMonthlySalary() * 12) * (bonusPercentage / 100);
        return baseBonus + executiveBonus;
    }

    // Method to retrieve monthly salary (for executive bonus calculation)
    public double getMonthlySalary() {
        return super.calculateWeeklySalary() * 4;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Total Bonus (including executive bonus): $" + calculateBonus());
    }
}

public class TestProgram {
    public static void main(String[] args) {
        // Displaying detailed employee information and total payroll for each type of employee
        double totalPayroll = 0;

        // Create an HourlyEmployee instance
        HourlyEmployee hourlyEmployee = new HourlyEmployee(1, "Alice Smith", "Adjunct Professor", 50, 35);
        System.out.println("Hourly Employee Details:");
        hourlyEmployee.displayInfo();
        totalPayroll += hourlyEmployee.calculateWeeklySalary();
        System.out.println();

        // Create a SalariedEmployee instance
        SalariedEmployee salariedEmployee = new SalariedEmployee(2, "Bob Johnson", "Assistant Professor", 4000);
        System.out.println("Salaried Employee Details:");
        salariedEmployee.displayInfo();
        totalPayroll += salariedEmployee.calculateWeeklySalary();
        System.out.println();

        // Create an ExecutiveEmployee instance
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(3, "Cathy Lee", "Dean", 8000, 20);
        System.out.println("Executive Employee Details:");
        executiveEmployee.displayInfo();
        totalPayroll += executiveEmployee.getMonthlySalary() / 4;
        System.out.println();

        // Display total payroll
        System.out.println("Total Payroll for all employees: $" + totalPayroll);
    }
}
