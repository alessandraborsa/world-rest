package it.objectmethod.world.dao;

import java.util.List;
import it.objectmethod.world.model.Country;

public interface ICountryDao {

	public List<Country> getCountryByName(String nameCountry, String nameContinent);
	
	public List<String> getContinent();

}
