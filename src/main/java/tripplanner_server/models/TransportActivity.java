package tripplanner_server.models;

import java.util.Date;

/**
 * Class defining the best transport mode between two points
 * 
 * @author MADHAVAN001
 *
 */
public class TransportActivity extends Activity {
	Location startPoint;
	Location endPoint;
	double duration;
	double distance;
	String modeOfTransport;
	int id;

	public TransportActivity(Location startPoint, Location endPoint, double distance, double duration,
			String modeOfTransport, Date fromDate, Date toDate) {
		super(fromDate, toDate);
		this.distance = distance;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.duration = duration;
		this.modeOfTransport = modeOfTransport;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * Starting point
	 * 
	 * @return Location startPoint
	 */
	public Location getStartPoint() {
		return startPoint;
	}

	/**
	 * Setter for StartPoint
	 * 
	 * @param startPoint
	 */
	public void setStartPoint(Location startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * Getter for endPoint
	 * 
	 * @return Location endPoint
	 */
	public Location getEndPoint() {
		return endPoint;
	}

	/**
	 * Setter for endPoint
	 * 
	 * @param endPoint
	 */
	public void setEndPoint(Location endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * return duration in minutes
	 * 
	 * @return double duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Setter for duration
	 * 
	 * @param duration
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * returns mode of transport
	 * 
	 * @return String modeOfTransport
	 */
	public String getModeOfTransport() {
		return modeOfTransport;
	}

	/**
	 * Sets the mode of transport
	 * 
	 * @param modeOfTransport
	 */
	public void setModeOfTransport(String modeOfTransport) {
		this.modeOfTransport = modeOfTransport;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	

}
