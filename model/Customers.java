package model;

import java.util.ArrayList;

public class Customers {
	
	 private ArrayList<Customer> customers ;
	 
	 public Customers() {
		 this.customers = new ArrayList <Customer> ();
	 }
	 public Customer getCustomerNumber (int nr) {
		 return customers.get(nr) ;
	 }
	 public void removeCustomerNr (int nr) {
		 customers.remove(nr);
	 }
	 public void addCustomer(Customer c) {
		 customers.add(c);
	 }
	 public int getSize () {
		 if ( this.customers.isEmpty()) return 0;
		 return this.customers.size();
	 }

}
