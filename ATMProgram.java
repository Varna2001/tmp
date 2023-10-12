package second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMProgram {
    public static void main(String[] args) {
        // Create a list of Customer objects
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("12", "12", "John Doe",1000));
        customers.add(new Customer("23", "23", "fslds Smith",2000));
        customers.add(new Customer("34", "23", "Jane sfls",2000));
        customers.add(new Customer("45", "23", "Jane Smith",4000));
        customers.add(new Customer("56", "234", "Jane asdf",2000));
        customers.add(new Customer("67", "233", "Jaasdfne Smith",2000));
        customers.add(new Customer("78", "2354", "Jane af Smith",2000));
        customers.add(new Customer("89", "2323", "Jane asdf",2000));
        customers.add(new Customer("90", "238", "Jane asf",2000));
        customers.add(new Customer("35", "23", "Jane Smisdfth",2000));
        showAccounts(customers);
        //System.out.println();
        
        Scanner scanner = new Scanner(System.in);

        boolean authenticated = false;	
        boolean quit = false;
        Customer currentCustomer = null;	
        double cusBalance = 0.0;

        while (!authenticated) {
            System.out.print("Enter your account ID: ");
            String enteredAccountId = scanner.nextLine();
            for (Customer customer : customers) {
                if (customer.getAccountId().equals(enteredAccountId)) {
                    //authenticated = true;
                    currentCustomer = customer;
                    while(!authenticated) {
                    	System.out.print("Enter your password: ");
                        String enteredPassword = scanner.nextLine();
                            if (customer.getPassword().equals(enteredPassword)) {
                                authenticated = true;
                                currentCustomer = customer;
                                break;
                            }

                        if (!authenticated) {
                            System.err.println("Wrong Password!");
                        }
                    }
                    break;
                }
            }
            
            if (!authenticated) {
                System.err.println("Invalid ID!");
            }
        }
        cusBalance = currentCustomer.getBalance();
        System.out.println("Name: " + currentCustomer.getName());
        System.out.println("Balance: " + cusBalance);
        
        authenticated = false;
        
        while (!authenticated) {
        	if (quit) {
        		//scanner.close();
        		break;
        	}
            
        	System.out.println("Would you like to withdraw? Yes/No");
            String inp = scanner.next();

            for (Customer customer : customers) {
                if (inp.toLowerCase().equals("yes")) {
                	authenticated = true;
                    currentCustomer = customer;
                    break;
                }else if (inp.toLowerCase().equals("no")) {
                	System.out.println("Thank you for using our service.");
                	quit = true;
                	break;
                }
            }
            if(!authenticated) {
            	if (quit) {
            		//scanner.close();
            		break;
            	}
            	System.err.println("Invalid input.");
            }
        }
        authenticated = false;
        while (!authenticated) {
        	if (quit) {
        		//scanner.close();
        		break;
        	}
        //double cusBalance = currentCustomer.getBalance();
        System.out.println(cusBalance);
        System.out.print("Enter the amount to withdraw: $");
        double withdrawalAmount = scanner.nextDouble();

        //currentCustomer.withdraw(withdrawalAmount);
        if(cusBalance >= withdrawalAmount && withdrawalAmount > 0) {
        	cusBalance -= withdrawalAmount;
        	//System.out.println("Withdraw successful!");
            System.out.println("Withdraw amount: " + withdrawalAmount);
            System.out.println("New Balance is: " + cusBalance);
            System.out.println("Thank you for using our service");
            break;
        }else           
      	 System.err.println("Insufience balance!");
         authenticated = false;
        }
        scanner.close();
    }
    
    public static void showAccounts(List<Customer> customers) {
        // Define column headers 	
    	int cusNumber = 1;
        System.out.println("+---------+----------------+---------- ----+---------------------+------------------+");
        System.out.println("|No.      |Name            |ID             |Password             |Balance           |");
        System.out.println("+---------+----------------+---------- ----+---------------------+------------------+");

        // Print table rows
        for (Customer customer : customers) {
        	//System.out.printf("|%-10s|%-10d|%-17s|%n", person.getName(), person.getAge(), person.getCity());
        	System.out.printf("|%-9s|%-16s|%-15s|%-21s|%-18s|%n",cusNumber, customer.getName(), customer.getAccountId(), customer.getPassword(), customer.getBalance());
            cusNumber++;
            System.out.println("+---------+----------------+---------- ----+---------------------+------------------+");
        }
    }
}
