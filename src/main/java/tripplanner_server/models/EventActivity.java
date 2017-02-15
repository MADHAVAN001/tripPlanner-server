package tripplanner_server.models;

import java.util.Date;
/**
 * 
 * @author MADHAVAN001
 *
 */
public class EventActivity extends Activity {
	EventObject event;

	public EventActivity(EventObject event, Date fromDate, Date toDate) {
		super(fromDate, toDate);
		this.event = event;
	}

	/**
	 * @return the event
	 */
	public EventObject getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(EventObject event) {
		this.event = event;
	}

}
