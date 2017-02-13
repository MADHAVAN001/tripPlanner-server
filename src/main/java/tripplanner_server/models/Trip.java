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
	double budget;
	List<String> listInterests;
	Date fromDate;
	Date toDate;
	String city;

	public Trip(double budget, List<String> listInterests, Date fromDate, Date toDate, String city) {
		this.budget = budget;
		this.listInterests = listInterests;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.city = city;
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
}
