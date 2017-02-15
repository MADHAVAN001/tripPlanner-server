/**
 * Model for Trip request
 */
package tripplanner_server.models;

import java.util.Date;
import java.util.List;

/**
 * @author MADHAVAN001
 *
 */
public class Trip {
	int id;
	String userName;
	double budget;
	List<String> listInterests;
	Date fromDate;
	Date toDate;
	String city;
	Location startPoint;

	public Trip(int id, double budget, List<String> listInterests, Date fromDate, Date toDate, String city) {
		this.id = id;
		this.budget = budget;
		this.listInterests = listInterests;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.city = city;
	}

	public Trip(double budget, List<String> listInterests, Date fromDate, Date toDate, String city) {
		this.budget = budget;
		this.listInterests = listInterests;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.city = city;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the startPoint
	 */
	public Location getStartPoint() {
		return startPoint;
	}

	/**
	 * @param startPoint
	 *            the startPoint to set
	 */
	public void setStartPoint(Location startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * @param budget
	 *            the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * @return the listInterests
	 */
	public List<String> getListInterests() {
		return listInterests;
	}

	/**
	 * @param listInterests
	 *            the listInterests to set
	 */
	public void setListInterests(List<String> listInterests) {
		this.listInterests = listInterests;
	}

	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * @param toDate
	 *            the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
