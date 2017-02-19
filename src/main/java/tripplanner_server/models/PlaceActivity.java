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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + placeId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof PlaceActivity))
			return false;
		PlaceActivity other = (PlaceActivity) obj;
		if (placeId != other.placeId)
			return false;
		return true;
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
