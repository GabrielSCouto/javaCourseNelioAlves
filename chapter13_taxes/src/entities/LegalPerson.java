package entities;

public class LegalPerson extends Person {

	private int employeeNumber;
	
	public LegalPerson() {
		super();
	}
	
	public LegalPerson(String name, Double annualEarnings, int employeeNumber) {
		super(name, annualEarnings);
		this.employeeNumber = employeeNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public Double taxes() {
		double taxes;
		if (employeeNumber > 10) {
			taxes = getAnnualEarnings() * 0.14;
		} else {
			taxes = getAnnualEarnings() * 0.16;
		}
		return taxes;
	}

//	@Override
//	public String toString() {
//		return super.toString();
//	}

}
