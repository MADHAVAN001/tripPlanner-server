package tripplanner_server.models;

import java.util.Date;
/**
 * 
 * @author MADHAVAN001
 *
 */
public class EventActivity extends Activity {
	Event event;

	public EventActivity(Event event, Date fromDate, Date toDate) {
		super(fromDate, toDate);
		this.event = event;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

}
