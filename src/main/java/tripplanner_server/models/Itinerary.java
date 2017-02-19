package tripplanner_server.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author MADHAVAN001
 *
 */
public class Itinerary {
	int tripRequestId;
	List<Map<Integer, List<Object>>> activityList;

	public Itinerary(int tripRequestId, List<Map<Integer, List<Object>>> activityList) {
		activityList = new ArrayList<Map<Integer, List<Object>>>(activityList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityList == null) ? 0 : activityList.hashCode());
		result = prime * result + tripRequestId;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Itinerary))
			return false;
		Itinerary other = (Itinerary) obj;
		if (activityList == null) {
			if (other.activityList != null)
				return false;
		} else if (!activityList.equals(other.activityList))
			return false;
		if (tripRequestId != other.tripRequestId)
			return false;
		return true;
	}

	/**
	 * @return the tripRequestId
	 */
	public int getTripRequestId() {
		return tripRequestId;
	}

	/**
	 * @param tripRequestId
	 *            the tripRequestId to set
	 */
	public void setTripRequestId(int tripRequestId) {
		this.tripRequestId = tripRequestId;
	}

	/**
	 * @return the activityList
	 */
	public List<Map<Integer, List<Object>>> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityList
	 *            the activityList to set
	 */
	public void setActivityList(List<Map<Integer, List<Object>>> activityList) {
		this.activityList = activityList;
	}

}
