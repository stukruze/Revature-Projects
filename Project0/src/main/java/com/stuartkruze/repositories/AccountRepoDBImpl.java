package com.stuartkruze.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.stuartkruze.controllers.ClientController;
import com.stuartkruze.models.Account;
import com.stuartkruze.util.JDBCConn;

public class AccountRepoDBImpl implements AccountRepo {

	public static Connection conn = JDBCConn.getConnection();
	final static Logger log = Logger.getLogger(ClientController.class);

	@Override
	public Account getAccount(int id) {

		String sql = "SELECT * FROM accounts WHERE client_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public Account getAccountById(int id, int id2) {
		
		String sql = "SELECT * FROM accounts WHERE client_id = ? AND account_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id2);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildAccount(rs);
			}

		} catch (SQLException e) {
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
			while (rs.next()) {
				accounts.add(buildAccount(rs));
			}

			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account addAccount(Account a, int id) {

		String sql = "INSERT INTO accounts(account_id, client_id, balance, account_type) VALUES (default,?,?,?) RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setDouble(2, a.getBalance());
			ps.setString(3, a.getType());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account updateAccount(Account change, int id, int id2) {

		String sql = "UPDATE accounts SET balance = ?, account_type = ? WHERE client_id = ? AND account_id = ? RETURNING *";

		
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, change.getBalance());
			ps.setString(2, change.getType());
			ps.setInt(3, id);
			ps.setInt(4, id2);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account deleteAccount(int id, int id2) {

		String sql = "DELETE FROM accounts WHERE client_id = ? AND account_id = ? RETURNING *";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id2);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public Account changeType(Account change) {

		String sql = "UPDATE accounts SET account_type = ? WHERE account_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getType());
			ps.setInt(2, change.getId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllCAccounts() {

		String sql = "SELECT * FROM Accounts WHERE type = 'checking'";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {
				accounts.add(buildAccount(rs));
			}

			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account addCAccount(Account a) {

		String sql = "INSERT INTO accounts(client_id, account_id, balance, account_type) VALUES (?,default,?,'checking') RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, a.getClientId());
			ps.setDouble(2, a.getBalance());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account addSAccount(Account a) {

		String sql = "INSERT INTO accounts(client_id, account_id, balance, account_type) VALUES (?,default,?,'savings') RETURNING *";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, a.getClientId());
			ps.setDouble(2, a.getBalance());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return buildAccount(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Account> getAllSAccounts() {

		String sql = "SELECT * FROM Accounts WHERE type = 'savings'";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {
				accounts.add(buildAccount(rs));
			}

			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllSAccountsById(int id, String amountLessThan, String amountGreaterThan) {

		int i = 0;
		int j = 0;
		
		String sql = "SELECT * FROM Accounts WHERE client_id = ?";
		
		if(amountLessThan == null && amountGreaterThan == null) {
			sql = "SELECT * FROM Accounts WHERE client_id = ?";
		} else {

			i=Integer.parseInt(amountLessThan);
			j=Integer.parseInt(amountGreaterThan);
			sql = "SELECT * FROM Accounts WHERE client_id = ? AND balance BETWEEN ? AND ?";

		}
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			if(amountLessThan != null && amountGreaterThan != null) {
				ps.setInt(2, j);
				ps.setInt(3, i);
			}
			
			ResultSet rs = ps.executeQuery();

			List<Account> accounts = new ArrayList<Account>();
			while (rs.next()) {
				accounts.add(buildAccount(rs));
			}

			return accounts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
	@Override
	public Account depositWithdraw(Account a, int id, int id2) {

		String sql = "UPDATE accounts SET balance = ?, account_type = ? WHERE client_id = ? AND account_id = ? RETURNING *";

		
		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, change.getBalance());
			ps.setString(2, change.getType());
			ps.setInt(3, id);
			ps.setInt(4, id2);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return buildAccount(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private Account buildAccount(ResultSet rs) throws SQLException {

		Account a = new Account();
		a.setId(rs.getInt("account_id"));
		a.setClientId(rs.getInt("client_id"));
		a.setBalance(rs.getInt("balance"));
		a.setType(rs.getString("account_type"));
		return a;

	}


}
