package tripplanner_server.models;

import java.util.Date;
/**
 * 
 * @author MADHAVAN001
 *
 */
public class EventActivity extends Activity {
	EventObj event;

	public EventActivity(EventObj event, Date fromDate, Date toDate) {
		super(fromDate, toDate);
		this.event = event;
	}

	/**
	 * @return the event
	 */
	public EventObj getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(EventObj event) {
		this.event = event;
	}

}
