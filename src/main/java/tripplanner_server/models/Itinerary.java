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
