package tripplanner_server.manager;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.commons.lang3.tuple.Pair;

import net.sf.sprockets.google.Place;
import tripplanner_server.models.ActivitiesComparator;
import tripplanner_server.models.Itinerary;
import tripplanner_server.models.Location;
import tripplanner_server.models.PlaceActivity;
import tripplanner_server.models.Tree;
import tripplanner_server.models.Trip;

public class RecommenderEngine {

	public static int NUM_TRIPS = 5;
	static final long ONE_MINUTE_IN_MILLIS = 60000;

	public static List<Itinerary> generateTrips(Trip trip) {
		if (trip == null)
			return null;
		Location startLocation = trip.getStartPoint();
		Comparator<Place> comparator = new ActivitiesComparator();

		int numDays = RecommenderEngine.betweenDates(trip.getFromDate(), trip.getToDate());

		for (int i = 0; i < numDays; i++) {
			Tree<Pair<Object, Integer>> tree = new Tree(Pair.of(startLocation, 0));
			Queue<Object> treeQueue = new LinkedList<Object>();
			treeQueue.add(startLocation);
			long time = trip.getFromDate().getTime() + 1440 * ONE_MINUTE_IN_MILLIS;

			Date currentDate = new Date(time);
			currentDate.setHours(8);
			Tree<Pair<Object, Integer>> node = new Tree(Pair.of(startLocation, 0));
			while (treeQueue.size() > 0) {
				Object obj = treeQueue.remove();
			
				if (obj instanceof Location) {
					PriorityQueue<Place> queue = new PriorityQueue<Place>(5, comparator);
					List<String> listInterests = new ArrayList<String>();
					listInterests.add("Breakfast");
					listInterests.add("bakery");
					queue.addAll(PlaceManager.getListAttractionPlaces(startLocation, 5000, listInterests));

					for (int j = 0; j < Math.min(3, queue.size()); j++)
					{
						treeQueue.add(new PlaceActivity(queue.remove().getPlaceId().toString(), currentDate,
								new Date(currentDate.getTime() + 60 * ONE_MINUTE_IN_MILLIS)));
					}
				} else if (obj instanceof PlaceActivity) {
					
				}
			}
		}
		return null;
	}

	public static int betweenDates(Date firstDate, Date secondDate) {
		return (int) ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}
}
