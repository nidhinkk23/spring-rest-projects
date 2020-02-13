package com.tyss.carinformationmaintenance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.tyss.carinformationmaintenance.dto.CarInfoBean;
import com.tyss.carinformationmaintenance.service.CarService;
import com.tyss.carinformationmaintenance.service.CarServiceImpl;


class CarTest {

	@Test
	void addCarTest() {
		CarService carService = new CarServiceImpl();
		boolean actual = carService.addCar(null);
		assertEquals(false, actual);
	}
	
	@Test
	void addCarNullTest() {
		CarService carService = new CarServiceImpl();
		CarInfoBean bean =new CarInfoBean();
		
		assertThrows(Exception.class, ()->{
			carService.addCar(bean);
		});
	}
	

}
