package com.stuartkruze.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stuartkruze.models.Account;
import com.stuartkruze.models.Client;
import com.stuartkruze.util.JDBCConn;

public class AccountRepoDBImpl implements AccountRepo {
	
	public static Connection conn = JDBCConn.getConnection();

	@Override
	public Account getAccount(int id) {
		
		String sql = "SELECT * FROM accounts WHERE account_id = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return buildAccount(rs);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		
		String sql = "SELECT * FROM Accounts";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			List<Account> accounts = new ArrayList<Account>();
			while(rs.next()) {
				accounts.add(buildAccount(rs));
			}
			
			return accounts;
		} catch(SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

	@Override
	public Account addAccount(Account a) {
		
		String sql = "INSERT INTO accounts(client_id, account_id, balance) VALUES (?,default,?) RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, a.getClientId());
			ps.setDouble(2, a.getBalance());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Account updateAccount(Account change) {
		
		String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?" ;
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, change.getBalance());			
			ps.setInt(2, change.getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return buildAccount(rs);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account deleteAccount(int id) {
		
		String sql = "DELETE * FROM accounts WHERE account_id = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				return buildAccount(rs);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Account buildAccount(ResultSet rs) throws SQLException {
		
		Account a = new Account();
		a.setId(rs.getInt("account_id"));
		a.setBalance(rs.getInt("balance"));
		return a;
			
	}

}
