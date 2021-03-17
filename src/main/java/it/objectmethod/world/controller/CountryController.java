package it.objectmethod.world.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CountryDaoImpl;
import it.objectmethod.world.model.Country;

@RestController
public class CountryController {
	@GetMapping("/country")
	public List<Country> setCountry(@RequestParam("namecountry") String namecountry,
			@RequestParam("continent") String continent) {

		List<Country> countryList = new ArrayList<>();

		ICountryDao countryDao = new CountryDaoImpl();

		countryList = countryDao.getCountryByName(namecountry, continent);
		return countryList;
	}
}
