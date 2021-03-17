package it.objectmethod.world.dao;

import java.util.List;

import it.objectmethod.world.model.City;

public interface ICityDao {

	public City getCityByName(String nameCity);
	
	public List<City> getCityByCountry(String code);

}