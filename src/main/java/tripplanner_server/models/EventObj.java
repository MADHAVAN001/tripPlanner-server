/**
 * 
 */
package tripplanner_server.models;

import java.util.Date;

/**
 * @author MADHAVAN001
 *
 */
public class EventObj {
	String title;
	String venueName;
	String venueCity;
	String description;
	double price;
	Date startTime;
	Date stopTime;
	String getURL;
	double latitude;
	double longitude;

	public EventObj(String title, String venueName, String venueCity, String description, double price, Date startTime,
			Date stopTime, String getURL,double latitude,double longitude) {
		this.title = title;
		this.venueName = venueName;
		this.venueCity = venueCity;
		this.price = price;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.getURL = getURL;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the venueName
	 */
	public String getVenueName() {
		return venueName;
	}

	/**
	 * @param venueName
	 *            the venueName to set
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	/**
	 * @return the venueCity
	 */
	public String getVenueCity() {
		return venueCity;
	}

	/**
	 * @param venueCity
	 *            the venueCity to set
	 */
	public void setVenueCity(String venueCity) {
		this.venueCity = venueCity;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the stopTime
	 */
	public Date getStopTime() {
		return stopTime;
	}

	/**
	 * @param stopTime
	 *            the stopTime to set
	 */
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	/**
	 * @return the getURL
	 */
	public String getGetURL() {
		return getURL;
	}

	/**
	 * @param getURL
	 *            the getURL to set
	 */
	public void setGetURL(String getURL) {
		this.getURL = getURL;
	}
	
	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param get Latitude
	 *            the latitude to set
	 */
	public void setlatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return latitude;
	}
	/**
	 * @param setLongitude
	 *            the longitude to set
	 */
	public void setlongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
