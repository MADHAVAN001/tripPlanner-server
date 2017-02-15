/**
 * 
 */
package tripplanner_server.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tripplanner_server.models.EventObj;

import com.evdb.javaapi.APIConfiguration;
import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.data.SearchResult;
import com.evdb.javaapi.data.request.EventSearchRequest;
import com.evdb.javaapi.operations.EventOperations;

/**
 * @author MADHAVAN001
 *
 */
public class EventsManager {
	private String API_KEY = "7m2B8sjhmH2vHpt5";
	
	public List<EventObj> getEvents(String keyword,String dateRange) throws EVDBRuntimeException, EVDBAPIException {
		List<EventObj> eventsList = new ArrayList<EventObj>();

		String title;
		String venueName;
		String venueCity;
		String description;
		double price;
		Date startTime;
		Date stopTime;
		String getURL;
		double longitude;
		double latitude;
		

		 APIConfiguration.setApiKey(API_KEY);
	     APIConfiguration.setEvdbUser("AppTest");
	     APIConfiguration.setEvdbPassword("123456");
		
	 
	 	 EventOperations eo = new EventOperations();
         EventSearchRequest esr = new EventSearchRequest();
         esr.setLocation("Singapore");
         esr.setKeywords(keyword);
        // esr.setDateRange(dateRange); //format e.g 2017020000-20170420000
         
         esr.setPageSize(50); //can change depending
         esr.setPageNumber(1);
          
		 SearchResult sr = null;
	         
	     sr = eo.search(esr);
        
		   ArrayList<Event> arrayList = (ArrayList<Event>) sr.getEvents();
		
		
		  for(int i =0; i<arrayList.size();i++){
		  
			  title = arrayList.get(i).getTitle();
			  venueName = arrayList.get(i).getVenueName();
			  venueCity = arrayList.get(i).getVenueCity();
			  description = arrayList.get(i).getDescription();
			  price = Double.parseDouble(arrayList.get(i).getPrice());
			  startTime = arrayList.get(i).getStartTime();
			  stopTime  =  arrayList.get(i).getStopTime();
			  getURL = arrayList.get(i).getURL();
         	  latitude = arrayList.get(i).getVenueLatitude();
         	  longitude = arrayList.get(i).getVenueLongitude();  
         	  EventObj e = new EventObj(title,venueName,venueCity,description,price,startTime,stopTime,getURL,latitude,longitude);
			  eventsList.add(e);
			  
		  }
	     return eventsList;
	}
}
