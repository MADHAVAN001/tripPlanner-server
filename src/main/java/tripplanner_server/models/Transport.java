package tripplanner_server.models;

public class Transport {
	Location startPoint;
	Location endPoint;
	double duration;
	double distance;
	String modeOfTransport;
	int id;

	public Transport(Location startPoint, Location endPoint, double distance, double duration, String modeOfTransport) {
		this.distance = distance;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.duration = duration;
		this.modeOfTransport = modeOfTransport;
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
	 * @return the endPoint
	 */
	public Location getEndPoint() {
		return endPoint;
	}

	/**
	 * @param endPoint
	 *            the endPoint to set
	 */
	public void setEndPoint(Location endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
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
	 * @return the modeOfTransport
	 */
	public String getModeOfTransport() {
		return modeOfTransport;
	}

	/**
	 * @param modeOfTransport
	 *            the modeOfTransport to set
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
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
