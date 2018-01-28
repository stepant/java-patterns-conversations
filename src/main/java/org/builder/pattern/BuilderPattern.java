package org.builder.pattern;

public class BuilderPattern {

	public static void main(String... args) {
		Director director = new Director();
		director.setBuilder(new ToyotaCorollaBuilder());
		Car car = director.buildCar();
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

abstract class CarBuilder{
	Car car;
	void createCar() {
		car = new Car();
	}
	
	abstract void buildMake(); // Every type of builder will implement own parts
	abstract void buildTransmission();
	abstract void buildMaxSpeed();
	
	Car getCar() {
		return car;
	}
}

class ToyotaCorollaBuilder extends CarBuilder{

	void buildMake() {
		car.setMake("Toyota Corolla");
	}

	void buildTransmission() {
		car.setTransmission(Transmission.MANUAL);
	}

	void buildMaxSpeed() {
		car.setMaxSpeed(200);
	}
} 

class VolkswagenPassatBuilder extends CarBuilder{

	void buildMake() {
		car.setMake("Volkswagen Passat");
	}

	void buildTransmission() {
		car.setTransmission(Transmission.MANUAL);
	}

	void buildMaxSpeed() {
		car.setMaxSpeed(220);
	}
} 

/**
 * Director has link to builder and use it to build different objects.
 * buildCar method is universal, but builder can be changed with setBuilder method
 */
class Director{
	CarBuilder builder;
	void setBuilder(CarBuilder b) {
		builder = b;
	}
	
	Car buildCar() {
		builder.createCar();
		builder.buildMake();
		builder.buildTransmission();
		builder.buildMaxSpeed();
		Car car = builder.getCar();
		return car;
	}
}