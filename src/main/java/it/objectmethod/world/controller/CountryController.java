package it.objectmethod.world.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.model.Country;

@RestController
public class CountryController {
	
	@Autowired
	private ICountryDao countryDao;
	
	@GetMapping("/country")
	public List<Country> setCountry(@RequestParam("namecountry") String namecountry,
			@RequestParam("continent") String continent) {

		List<Country> countryList = new ArrayList<>();

		countryList = countryDao.getCountryByName(namecountry, continent);
		return countryList;
	}
	
	@GetMapping("/continents")
	public List<String> setContinent() {

		List<String> continents = new ArrayList<>();

		continents = countryDao.getContinent();
		return continents;
	}
}
