package tripplanner_server.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author MADHAVAN001
 *
 */
public class Itinerary {
	Map<Integer, List<Object>> activityList;

	public Itinerary(Map<Integer, List<Object>> activityList) {
		activityList = new HashMap<Integer, List<Object>>(activityList);
	}

	/**
	 * @return the activityList
	 */
	public Map<Integer, List<Object>> getActivityList() {
		return activityList;
	}

	/**
	 * @param activityList
	 *            the activityList to set
	 */
	public void setActivityList(Map<Integer, List<Object>> activityList) {
		this.activityList = activityList;
	}

}
