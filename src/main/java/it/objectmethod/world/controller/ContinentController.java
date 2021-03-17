package it.objectmethod.world.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.dao.impl.CountryDaoImpl;

@RestController
public class ContinentController {
	@GetMapping("/continents")
	public List<String> setContinent() {

		List<String> continents = new ArrayList<>();

		ICountryDao countryDao = new CountryDaoImpl();

		continents = countryDao.getContinent();
		return continents;
	}
}