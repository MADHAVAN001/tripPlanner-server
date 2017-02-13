package tripplanner_server.models;

/**
 * Location class to determine location point in terms of latitude and longitude
 * 
 * @author MADHAVAN001
 *
 */
public class Location {
	double latitude;
	double longitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * 
	 * @return latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Setter for latitude
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Get longitude
	 * 
	 * @return longitude as double
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Set longitude
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
