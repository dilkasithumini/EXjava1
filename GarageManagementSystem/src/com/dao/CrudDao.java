package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Garage;
import com.util.DBUtil;

public class CrudDao {

	private Connection connection;

	public CrudDao() {
		connection = DBUtil.getConnection();
	}

	public void addGarage(Garage garage) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into garage(id,name,category,address,owner,contact) values (?, ?, ?, ?, ?, ? )");
			// Parameters start with 1
			// preparedStatement.setInt(1, garage.getId());
			preparedStatement.setString(1, garage.getName());
			preparedStatement.setString(2, garage.getCategory());
			preparedStatement.setString(3, garage.getAddress());
			preparedStatement.setString(4, garage.getOwner());
			preparedStatement.setInt(5, garage.getContact());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteGarage(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from garage where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGarage(Garage garage) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update garage set name=?, category=?, address=?, owner=?, contact=?" + "where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, garage.getName());
			preparedStatement.setString(2, garage.getCategory());
			preparedStatement.setString(3, garage.getAddress());
			preparedStatement.setString(4, garage.getOwner());
			preparedStatement.setInt(5, garage.getContact());
			preparedStatement.setInt(5, garage.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Garage> getAllGarages() {
		List<Garage> garage = new ArrayList<Garage>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				Garage gr = new Garage();
				gr.setId(rs.getInt("id"));
				gr.setName(rs.getString("name"));
				gr.setCategory(rs.getString("category"));
				gr.setAddress(rs.getString("address"));
				gr.setOwner(rs.getString("owner"));
				gr.setContact(rs.getInt("contact"));
				garage.add(gr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return garage;
	}

	public Garage getGarageById(int id) {
		Garage garage = new Garage();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from garage where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				garage.setId(rs.getInt("id"));
				garage.setName(rs.getString("name"));
				garage.setCategory(rs.getString("category"));
				garage.setAddress(rs.getString("address"));
				garage.setOwner(rs.getString("owner"));
				garage.setContact(rs.getInt("contact"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return garage;
	}

}
