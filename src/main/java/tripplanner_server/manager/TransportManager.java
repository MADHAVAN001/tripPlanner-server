/**
 * 
 */
package tripplanner_server.manager;

import java.util.Date;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixRow;

import tripplanner_server.models.Location;
import tripplanner_server.models.TransportActivity;

/**
 * @author MADHAVAN001
 *
 */
public class TransportManager {
	public TransportActivity getTransportationDetails(Location startPoint, Location endPoint, Date fromDate) {
		if (startPoint == null || endPoint == null || fromDate == null)
			return null;
		TransportActivity activity = null;
		String origin[] = new String[1];
		String destinations[] = new String[1];
		origin[0] = startPoint.getLatitude() + "," + startPoint.getLongitude();
		destinations[0] = endPoint.getLatitude() + "," + endPoint.getLongitude();
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAhyuU1NC1ZKuHAN9xKJh58vgl4GQJYrGw");
		DistanceMatrixApiRequest request = DistanceMatrixApi.getDistanceMatrix(context, origin, destinations);
		try {
			DistanceMatrix matrix = request.await();
			DistanceMatrixRow row[] = matrix.rows;
			for (DistanceMatrixElement element : row[0].elements) {
				// System.out.println("Result: "+ element.duration);
				@SuppressWarnings("deprecation")
				Date toDate = new Date(fromDate.getYear(), fromDate.getMonth(), fromDate.getDay(), fromDate.getHours(),
						fromDate.getMinutes());
				/*
				activity = new TransportActivity(startPoint, endPoint, Double.parseDouble(element.duration.toString()),
"TAXI", fromDate, toDate);
*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return activity;
	}
}
