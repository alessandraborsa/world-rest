package it.objectmethod.world.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.world.model.City;
import it.objectmethod.world.dao.ICityDao;


@RestController
public class CityController {
	
	@Autowired
	private ICityDao cityDao;
	
	@GetMapping("/city")
	public City setNameCity(@RequestParam("namecity") String namecity) {

		City city = null;
		city = cityDao.getCityByName(namecity);

		return city;
	}
	
	@GetMapping("/citylist/{codecountry}/list")
	public List<City> setCityList(@PathVariable("codecountry") String codecountry) {

		List<City> cityList = new ArrayList<>();
		cityList = cityDao.getCityByCountry(codecountry);

		return cityList;
	}
}
