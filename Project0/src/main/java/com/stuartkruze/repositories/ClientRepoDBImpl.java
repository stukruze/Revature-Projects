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
		
		String sql = "SELECT * FROM clients WHERE id = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return buildClient(rs);
			}
			
		} catch(SQLException e) {
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
			while(rs.next()) {
				clients.add(buildClient(rs));
			}
			
			return clients;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public Client addClient(Client c) {
		// edit sql to DB
		String sql = "INSERT INTO movies VALUES (default,?,?,?,?) RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			//ps.setString(1, m.getTitle());
			//ps.setDouble(2, m.getPrice());
			//...
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildClient(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Client updateClient(Client change) {
		
		return null;
	}

	@Override
	public Client deleteClient(int id) {
		
		return null;
	}
	
	private Client buildClient(ResultSet rs) throws SQLException {
		Client c = new Client();
		c.setId(rs.getInt("id"));
//	c.setId(rs.getInt("address"));
		return c;
	}

}
