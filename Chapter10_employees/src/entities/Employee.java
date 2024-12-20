package entities;

public class Employee {
	
	private String id;
	private String name;
	private Double salary;
	
	public Employee() {
		
	}
	
	public Employee(String id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}
	
//	public void setSalary(Double salary) {
//		this.salary = salary;
//	}

	public void increaseSalary(double increasePercentage) {
//		double salaryPercent = (increasePercentage/100) * getSalary();
//		setSalary(getSalary() + salaryPercent);
		salary += salary * (increasePercentage/100);
	}
	
	public String toString() {
		return id + ", " + name + ", $" + String.format("%.2f", salary);
	}
	
}
