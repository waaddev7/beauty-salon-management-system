package Beauty;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable  {
private Customer  customer;
private  Service service;
private Date date ;
private double totalPrice;
 public Appointment(Customer customer, Service service, Date date, double totalPrice)
{
	this.customer=customer;
	this.service=service;
	this.date=date;
	this.totalPrice=totalPrice;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Service getService() {
	return service;
}
public void setService(Service service) {
	this.service = service;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
@Override
public String toString() {
  return" customer	"+ customer + " service - " + service + " date- " + date + " - $" + totalPrice;
}
}
