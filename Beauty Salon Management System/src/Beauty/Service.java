package Beauty;

import java.io.Serializable;

public class Service implements Serializable {

	private String name;
	private String duration;
	private double price ;
	public Service(String name, String duration, double price){
		this.name=name;
		this.duration=duration;
		this.price=price;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDuration() {
		return duration;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	@Override
	//****************************************
	public String toString() {
		return  "NAME ser" +name + " - " + duration + " - $" + price;
	}
	
	
}
