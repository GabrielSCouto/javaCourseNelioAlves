package entities;

public class NaturalPerson extends Person{
	
	private Double healthExpanses;
	
	public NaturalPerson() {
		super();
	}
	
	public NaturalPerson(String name, Double annualEarnings, Double healthExpanses) {
		super(name, annualEarnings);
		this.healthExpanses = healthExpanses;
	}

	public Double getHealthExpanses() {
		return healthExpanses;
	}

	public void setHealthExpanses(Double healthExpanses) {
		this.healthExpanses = healthExpanses;
	}

	@Override
	public Double taxes() {
		double taxes;
		if (getAnnualEarnings() < 20000) {
			taxes = getAnnualEarnings() * 0.15;
		} else {
			taxes = getAnnualEarnings() * 0.25;
		}
		
		return taxes - (healthExpanses/2);
	}

//	@Override
//	public String toString() {
//		return super.toString();
//	}

}
