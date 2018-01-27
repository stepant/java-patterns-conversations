package javapatterns;

public class SimpleBuilderPattern {

	public static void main(String... args) {
		Car toyota = new CarBuilder()
					.buildMake("Toyota") //build properties of car
					.buildTransmission(Transmission.AUTO)
					.buildSpeed(250)
					.build(); 
		
		System.out.println(toyota);
		
		Car car = new Car();
		System.out.println(car);
	}
}

enum Transmission {
	MANUAL, AUTO
}

class Car {
	private String make;
	private Transmission transmission;
	private int maxSpeed;

	public void setMake(String make) {
		this.make = make;
	};

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public String getMake() {
		return make;
	}

	public Transmission getTransmission() {
		return transmission;
	}
	
	public String toString() {
		return "Car [make=" + make + ", transmission=" + transmission + ", maxSpeed=" + maxSpeed + "]";
	}
}

class CarBuilder {
	//Set buyilder's default values
	private String make = "DefaultModel";
	private Transmission transmission = Transmission.MANUAL;
	private int speed = 100;

	CarBuilder buildMake(String make) {
		this.make = make;
		return this; //return of this makes possible chaining in construction of car 
	}

	CarBuilder buildTransmission(Transmission transmission) {
		this.transmission = transmission;
		return this;
	}

	CarBuilder buildSpeed(int speed) {
		this.speed = speed;
		return this;
	}

	Car build() {
		Car car = new Car();
		car.setMake(make);
		car.setTransmission(transmission);
		car.setMaxSpeed(speed);
		return car;
	}

}
