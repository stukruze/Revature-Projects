package com.stuartkruze.repositories;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.stuartkruze.models.Client;
import com.stuartkruze.util.JDBCConn;

public class ClientRepoDBImpl implements ClientRepo {

	public static Connection conn = JDBCConn.getConnection();


	@Override
	public Client getClient(int id) {

		String sql = "SELECT * FROM clients WHERE client_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Client> getAllClients() {

		String sql = "SELECT * FROM Clients";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Client> clients = new ArrayList<Client>();
			while (rs.next()) {
				clients.add(buildClient(rs));
			}

			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Client addClient(Client c) {

		String sql = "INSERT INTO clients(client_id, first_name, last_name, address1, address2, city, state, zip) VALUES (default,?,?,?,?,?,?,?) RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getAddress1());
			ps.setString(4, c.getAddress2());
			ps.setString(5, c.getCity());
			ps.setString(6, c.getState());
			ps.setString(7, c.getZip());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Client deleteClient(int id) {

		String sql = "DELETE FROM clients WHERE client_id = ? RETURNING *";
		
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			
			if (rs.next()) {
				
				return buildClient(rs);
				
			} 
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public Client updateClient(Client change, int id) {

		String sql = "UPDATE clients SET first_name = ?, last_name = ?, address1 = ?, address2 = ?, city = ?, state = ?, zip = ? WHERE client_id = ? RETURNING *";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, change.getFirstName());
			ps.setString(2, change.getLastName());
			ps.setString(3, change.getAddress1());
			ps.setString(4, change.getAddress2());
			ps.setString(5, change.getCity());
			ps.setString(6, change.getState());
			ps.setString(7, change.getZip());
			ps.setInt(8, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildClient(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	private Client buildClient(ResultSet rs) throws SQLException {

		Client c = new Client();
		c.setId(rs.getInt("client_id"));
		c.setFirstName(rs.getString("first_name"));
		c.setLastName(rs.getString("last_name"));
		c.setAddress1(rs.getString("address1"));
		c.setAddress2(rs.getString("address2"));
		c.setCity(rs.getString("city"));
		c.setState(rs.getString("state"));
		c.setZip(rs.getString("zip"));
		return c;

	}
	

}

