package second;

import pack.Account;

public class Customer {
    private String accountId;
    private String password;
    private String name;
    private double balance;

    public Customer(String accountId, String password, String name, int balance) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}