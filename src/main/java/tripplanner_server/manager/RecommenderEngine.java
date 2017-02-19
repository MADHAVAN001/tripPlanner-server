package tripplanner_server.manager;

import java.util.List;

import tripplanner_server.models.Itinerary;
import tripplanner_server.models.Location;
import tripplanner_server.models.Trip;

public class RecommenderEngine {
	public static List<Itinerary> generateTrips(Trip trip) {
		if(trip == null)
			return null;
		Location startLocation = trip.getStartPoint();
		//PriorityQueue<>
		return null;
	}
}
