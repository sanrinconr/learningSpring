package com.mercadolibre.romanos_bootcamp.unit.beans;

import com.mercadolibre.romanos_bootcamp.dtos.SampleDTO;
import com.mercadolibre.romanos_bootcamp.beans.RandomSampleBean;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomSampleBeanTest {

	@Test
	public void randomPositiveTestOK() {
		RandomSampleBean randomSample = new RandomSampleBean();

		SampleDTO sample = randomSample.random();
		
		assertTrue(sample.getRandom() >= 0);
	}
}
