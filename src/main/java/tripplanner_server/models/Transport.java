package tripplanner_server.models;

/**
 * Class defining the best transport mode between two points
 * 
 * @author MADHAVAN001
 *
 */
public class Transport {
	Location startPoint;
	Location endPoint;
	double duration;
	String modeOfTransport;

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

}
