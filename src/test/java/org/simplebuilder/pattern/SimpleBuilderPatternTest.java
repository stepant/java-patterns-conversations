package org.simplebuilder.pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.simplebuilder.pattern.Car;
import org.simplebuilder.pattern.CarBuilder;
import org.simplebuilder.pattern.Transmission;

class SimpleBuilderPatternTest {

	@Test
	void testCarBuilder() {
		System.out.println("Create cars with CarBuilder");
		Car toyota = new CarBuilder()
					.buildMake("Toyota")
					.buildTransmission(Transmission.AUTO)
					.buildSpeed(250)
					.build();
		
		assertNotNull(toyota);
		assertThat(toyota, instanceOf(Car.class));
		assertEquals(toyota.getMake(), "Toyota");
		assertEquals(toyota.getMaxSpeed(), 250);
		assertEquals(toyota.getTransmission(), Transmission.AUTO);
	}

}
