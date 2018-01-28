package org.builder.pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.builder.pattern.Car;
import org.builder.pattern.ToyotaCorollaBuilder;
import org.builder.pattern.Transmission;

class BuilderPatternTest {

	@Test
	void testDirector() {
		System.out.println("Director now creates car with ToyotaCorollaBuilder");
		Director director = new Director();
		director.setBuilder(new ToyotaCorollaBuilder());
		Car toyota = director.buildCar();
		System.out.println(toyota);
		
		assertNotNull(toyota);
		assertThat(toyota, instanceOf(Car.class));
		assertEquals(toyota.getMake(), "Toyota Corolla");
		assertEquals(toyota.getMaxSpeed(), 200);
		assertEquals(toyota.getTransmission(), Transmission.MANUAL);
	}

}
