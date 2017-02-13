package tripplanner_server.models;

import java.util.Date;

/**
 * 
 * @author MADHAVAN001
 *
 */
public class PlaceActivity extends Activity {
	int placeId;

	public PlaceActivity(Date fromDate, Date toDate, int placeId) {
		super(fromDate, toDate);
		this.placeId = placeId;
	}

	/**
	 * @return the placeId
	 */
	public int getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId
	 *            the placeId to set
	 */
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
}
