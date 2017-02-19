package tripplanner_server.models;

import java.util.Date;

/**
 * Class defining the best transport mode between two points
 * 
 * @author MADHAVAN001
 *
 */
public class TransportActivity extends Activity {

	Transport transport;

	public TransportActivity(Transport transport, Date fromDate, Date toDate) {
		super(fromDate, toDate);
		this.transport = transport;
	}

	/**
	 * @return the transport
	 */
	public Transport getTransport() {
		return transport;
	}

	/**
	 * @param transport
	 *            the transport to set
	 */
	public void setTransport(Transport transport) {
		this.transport = transport;
	}

}
