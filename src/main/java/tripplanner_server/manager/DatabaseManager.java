/**
 * 
 */
package tripplanner_server.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tripplanner_server.models.UserAccount;

/**
 * @author MADHAVAN001
 *
 */
public class DatabaseManager {
	Connection connection = null;
	String schemaName = "TripPlanner";

	public DatabaseManager() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * @param placeId
	 * @param interest
	 * @param recommendedList
	 * @return
	 */
	public boolean addRecommenderItem(String placeId, String interest, List<String> recommendedList) {
		if (placeId == null || interest == null || recommendedList == null)
			return false;
		if (checkRecommendationExists(placeId, interest))
			return false;
		String sql = "INSERT INTO \"" + schemaName + "\".recommender(placeid, interest, listinterests) VALUES (\'"
				+ placeId + "\', \'" + interest + "\',[";
		for (int i = 0; i < recommendedList.size(); i++) {
			if (i != recommendedList.size() - 1)
				sql += recommendedList.get(i) + ",";
			else
				sql += recommendedList.get(i);
		}
		sql += "]);";
		return this.executeUpdate(sql);
	}

	/**
	 * 
	 * @param placeId
	 * @param interest
	 * @return
	 */
	public boolean checkRecommendationExists(String placeId, String interest) {
		if (placeId == null || interest == null)
			return false;

		String sql = "SELECT * FROM \"" + schemaName + "\".recommender WHERE placeid = \'" + placeId
				+ "\' AND interest = \'" + interest + "\';";
		Statement statement;
		boolean result = false;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				String placeIdCheck = resultSet.getString("placeid");
				String interestCheck = resultSet.getString("interest");
				result = (placeIdCheck.equals(placeId) & interestCheck.equals(interest)) ? true : false;
			}
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkAccount(String email) {
		if (email == null || email.length() == 0)
			return false;
		String sql = "SELECT * FROM \"" + "TripPlanner" + "\".useraccount WHERE email = \'" + email + "\';";
		Statement statement;
		boolean result = false;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				String emailCheck = resultSet.getString("email");
				result = emailCheck.equals(email) ? true : false;
			}
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public int getAccountId(String email) {
		if (email == null || email.length() == 0)
			return -1;
		String sql = "SELECT * FROM \"" + "TripPlanner" + "\".useraccount WHERE email = \'" + email + "\';";
		Statement statement;
		int id = -1;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				id = resultSet.getInt("id");
			}
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 
	 * @param account
	 * @return
	 */
	public boolean addUserAccount(UserAccount account) {
		if (account == null)
			return false;
		String sql = "INSERT INTO \"" + schemaName + "\".useraccount(username, password, email, date)	VALUES (\'"
				+ account.getUserName() + "\', \'" + account.getPassword() + "\', \"" + account.getEmail() + "\', \""
				+ account.getDate() + "\');";
		return this.executeUpdate(sql);
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean deleteAccount(String email) {
		if (email == null || email.length() == 0)
			return false;

		String sql = "DELETE FROM \"" + schemaName + "\"s.useraccount	WHERE email = \'" + email + "\';";
		return this.executeUpdate(sql);

	}

	/**
	 * 
	 * @param query
	 * @return
	 */
	public boolean executeUpdate(String query) {
		Statement statement;
		try {
			statement = getConnection().createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
