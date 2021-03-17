package it.objectmethod.world.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.world.model.City;
import it.objectmethod.world.dao.ICityDao;
import it.objectmethod.world.dao.impl.CityDaoImpl;

@RestController
public class CityController {
	@GetMapping("/city")
	public City setNameCity(@RequestParam("namecity") String namecity) {

		ICityDao cityDao = new CityDaoImpl();
		City city = null;

		city = cityDao.getCityByName(namecity);

		return city;
	}
	
	@GetMapping("/citylist/{codecountry}")
	public List<City> setCityList(@PathVariable("codecountry") String codecountry) {

		List<City> cityList = new ArrayList<>();
		ICityDao cityDaoList = new CityDaoImpl();
		cityList = cityDaoList.getCityByCountry(codecountry);

		return cityList;
	}
}
