/**
 * 
 */
package tripplanner_server.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import tripplanner_server.models.EventActivity;
import tripplanner_server.models.EventObject;
import tripplanner_server.models.Itinerary;
import tripplanner_server.models.Location;
import tripplanner_server.models.PlaceActivity;
import tripplanner_server.models.TransportActivity;
import tripplanner_server.models.Trip;
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

	public boolean addItinerary(Itinerary itinerary, int responseId) {
		if (itinerary == null)
			return false;

		boolean result = true;
		for (int i = 0; i < itinerary.getActivityList().size(); i++) {
			Iterator<Integer> itr = itinerary.getActivityList().get(i).keySet().iterator();
			while (itr.hasNext()) {
				Integer key = new Integer(itr.next());
				if (itinerary.getActivityList().get(i).get(key) instanceof EventActivity) {
					EventActivity activity = (EventActivity) itinerary.getActivityList().get(i).get(key);
					String sql = "INSERT INTO \"" + schemaName
							+ "\".itinerary(triprequest, day, orderid, starttime, endtime, activitytype, activityid) VALUES ("
							+ itinerary.getTripRequestId() + ", " + i + ", " + key.toString() + ", \'"
							+ activity.getFromDate() + "\', \'" + activity.getToDate() + "\', 1, "
							+ activity.getEvent().getId() + ");";
					result = result & this.executeUpdate(sql);
				} else if (itinerary.getActivityList().get(i).get(key) instanceof TransportActivity) {
					TransportActivity activity = (TransportActivity) itinerary.getActivityList().get(i).get(key);
					String sql = "INSERT INTO \"" + schemaName
							+ "\".itinerary(triprequest, day, orderid, starttime, endtime, activitytype, activityid) VALUES ("
							+ itinerary.getTripRequestId() + ", " + i + ", " + key.toString() + ", \'"
							+ activity.getFromDate() + "\', \'" + activity.getToDate() + "\', 1, " + activity.getId()
							+ ");";
					result = result & this.executeUpdate(sql);
				} else if (itinerary.getActivityList().get(i).get(key) instanceof PlaceActivity) {
					PlaceActivity activity = (PlaceActivity) itinerary.getActivityList().get(i).get(key);
					String sql = "INSERT INTO \"" + schemaName
							+ "\".itinerary(triprequest, day, orderid, starttime, endtime, activitytype, activityid) VALUES ("
							+ itinerary.getTripRequestId() + ", " + i + ", " + key.toString() + ", \'"
							+ activity.getFromDate() + "\', \'" + activity.getToDate() + "\', 1, "
							+ activity.getPlaceId() + ");";
					result = result & this.executeUpdate(sql);
				}
			}
		}
		return result;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeTransport(int id) {
		if (id <= 0)
			return false;
		String sql = "DELETE FROM \"" + schemaName + "\".transport WHERE id=" + id;
		return this.executeUpdate(sql);
	}

	/**
	 * 
	 * @param transport
	 * @return
	 */
	public int addTransport(TransportActivity transport) {
		if (transport == null)
			return -1;
		String sql = "INSERT INTO \"" + schemaName
				+ "\".transport(distance, duration, startlatitude, startlongitude, endlatitude, endlongitude, modeoftransport) VALUES("
				+ transport.getDistance() + ", " + transport.getDuration() + ", "
				+ transport.getStartPoint().getLatitude() + ", " + transport.getStartPoint().getLongitude() + ", "
				+ transport.getEndPoint().getLatitude() + ", " + transport.getEndPoint().getLongitude() + ", \'"
				+ transport.getModeOfTransport() + "\');";
		this.executeUpdate(sql);

		sql = "SELECT * FROM \"" + schemaName + "\".transport ORDER BY id;";

		int id = -1;
		Statement statement = null;
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
	 * @param eventId
	 * @return
	 */
	public EventObject getEventbyId(int eventId) {
		if (eventId <= 0)
			return null;

		String sql = "SELECT * FROM \"" + schemaName + "\".events WHERE id = " + eventId + ";";

		Statement statement = null;
		EventObject event = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				event = new EventObject(resultSet.getString("title"), resultSet.getString("venueName"),
						resultSet.getString("venueCity"), resultSet.getString("description"),
						resultSet.getDouble("price"), df.parse(resultSet.getString("startdate")),
						df.parse(resultSet.getString("enddate")), resultSet.getString("url"),
						new Location(resultSet.getDouble("latitude"), resultSet.getDouble("longitude")));
			}
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

	/**
	 * 
	 * @param event
	 * @return
	 */
	public boolean addEvent(EventObject event) {
		if (event == null)
			return false;
		String sql = "INSERT INTO \"" + schemaName
				+ "\".events(title, venuename, description, venuecity, latitude, longitude, url, startdate, enddate)	VALUES (\'"
				+ event.getTitle() + "\', \'" + event.getVenueName() + "\', \'" + event.getDescription() + "\', \'"
				+ event.getVenueCity() + "\', " + event.getLocation().getLongitude() + ", "
				+ event.getLocation().getLongitude() + ", \'" + event.getGetURL() + "\', \'" + event.getStartTime()
				+ "\', \'" + event.getStopTime() + "\');";
		return this.executeUpdate(sql);
	}

	/**
	 * 
	 * @param userName
	 * @param tripId
	 * @return
	 */
	public boolean deleteTrip(String userName, int tripId) {
		if (userName == null || tripId <= 0)
			return false;
		String sql = "DELETE FROM \"" + schemaName + "\".triprequests WHERE username = \'" + userName + "\' AND id="
				+ tripId + ";";
		return this.executeUpdate(sql);
	}

	/**
	 * 
	 * @param trip
	 * @return
	 */
	public int addTrip(Trip trip) {
		if (trip == null)
			return -1;

		String sql = "INSERT INTO \"" + schemaName
				+ "\".triprequests(username, listinterests, fromdate, todate, startlatitude, startlongitude, city, budget) VALUES (\'"
				+ trip.getUserName() + "\', [";

		for (int i = 0; i < trip.getListInterests().size(); i++) {
			if (i != trip.getListInterests().size() - 1)
				sql += "\'" + trip.getListInterests().get(i) + "\',";
			else
				sql += "\'" + trip.getListInterests().get(i) + "\'";
		}
		sql += "], \'" + trip.getFromDate().toString() + "\', \'" + trip.getToDate().toString() + "\', "
				+ trip.getStartPoint().getLatitude() + ", " + trip.getStartPoint().getLongitude() + ", \'"
				+ trip.getCity() + "\'', " + trip.getBudget() + ");";
		this.executeUpdate(sql);

		sql = "SELECT id FROM \"" + schemaName + "\".triprequests WHERE username = \'" + trip.getUserName()
				+ "\' ORDER BY id DESC";

		int id = -1;
		Statement statement = null;
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
				sql += "\'" + recommendedList.get(i) + "\',";
			else
				sql += "\'" + recommendedList.get(i) + "\'";
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
