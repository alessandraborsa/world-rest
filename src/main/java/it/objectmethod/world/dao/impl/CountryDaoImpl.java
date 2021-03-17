package it.objectmethod.world.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.objectmethod.world.config.ConnectionFactory;
import it.objectmethod.world.dao.ICountryDao;
import it.objectmethod.world.model.Country;

@Component

public class CountryDaoImpl implements ICountryDao {

	public List<Country> getCountryByName(String nameCountry, String nameContinent) {
		Connection conn = ConnectionFactory.getConnection();
		List<Country> countries = new ArrayList<Country>();

		String sql = "SELECT * FROM country AS c WHERE ( '' LIKE ? OR c.Name LIKE ? ) AND ( '' = ? OR c.Continent = ?);";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nameCountry);
			stmt.setString(2, nameCountry);
			stmt.setString(3, nameContinent);
			stmt.setString(4, nameContinent);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Country country = new Country();
				country.setCode(rs.getString("code"));
				country.setName(rs.getString("name"));
				country.setContinent(rs.getString("continent"));
				country.setPopulation(rs.getInt("population"));
				country.setSurfaceArea(rs.getInt("surfaceArea"));
				countries.add(country);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return countries;
	}

	public List<String> getContinent() {
		Connection conn = ConnectionFactory.getConnection();
		List<String> continents = new ArrayList<String>();
		String sql = "SELECT DISTINCT c.continent FROM country AS c";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				continents.add(rs.getString("continent"));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return continents;
	}
}
