package entities;

public class Account {
	
	private String accNum;
	private String name;
	private double deposit;
	private double balance;
	
	
	public Account() {
		
	}
	
	public Account(String accNum, String name, double deposit) {
		this.accNum = accNum;
		this.name = name;
		this.deposit = deposit;
	}
	
	public Account(String accNum, String name) {
		this.accNum = accNum;
		this.name = name;
	}

	
	
	public String getAccNum() {
		return accNum;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDeposit() {
		return deposit;
	}
	
	public void getBalance(double balance) {
		this.balance = balance;
	}
	
	
	public void increaseBalance(double deposit) {
		this.deposit = deposit;
		balance += deposit;
	}
	
	public void withdraw(double withdraw) {
		balance = balance - (withdraw + 5);
	}
	
	
	public String toString() {
		return accNum
		+ ", Holder: "
		+ name
		+ ", Balance: $ "
		+ String.format("%.2f", balance);
		}

}
