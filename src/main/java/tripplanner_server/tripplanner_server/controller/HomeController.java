package tripplanner_server.tripplanner_server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tripplanner_server.manager.EventsManager;
import tripplanner_server.manager.PlaceManager;
import tripplanner_server.manager.TransportManager;
import tripplanner_server.manager.UserAccountManager;
import tripplanner_server.models.PlaceActivity;
import tripplanner_server.models.TransportActivity;
import tripplanner_server.models.UserAccount;
import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class HomeController {
	 @RequestMapping(value ="/event")
	   
		   public void getEvent(HttpServletResponse response,HttpServletRequest request) throws IOException{
		  //get receive JSON data from request
		   BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		   String json ="";
		   if(br!=null){
			   json = br.readLine();
		   }	  
		   String[] eventRequest = new String[600000];
		   //set response type to JSON
		   response.setContentType("application/json");
		   
		   
		   EventsManager em = new EventsManager();
		   String keyword = request.getParameter("keyword");
		   String dateRange = request.getParameter("DateRange");
			 
			 System.out.println(keyword);
			 System.out.println(dateRange);
			 
			 try {
				eventRequest = em.handleEventRequestJSON(keyword, dateRange);
				
				 for(int i=0;i<eventRequest.length;i++){
						System.out.println(eventRequest[i]);
						response.getWriter().println(eventRequest[i]);
						
					 }
					 
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EVDBRuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EVDBAPIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	   }
	  
	 @RequestMapping(value ="/transport") 
	   public void getTransport(HttpServletResponse response,HttpServletRequest request) throws IOException{
	  //get receive JSON data from request
	   BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	   String json ="";
	   if(br!=null){
		   json = br.readLine();
	   }      
	   System.out.println(json);
	  
	   TransportActivity ta;
	   //set response type to JSON
	   response.setContentType("application/json");
	   
	   //parameters required to run transport manager
	   String origin = request.getParameter("origin");
	   String destination = request.getParameter("destination");
	   String fromDate = request.getParameter("fromDate");
	   
		 try {
			 TransportManager tm = new TransportManager();
			 /*call method from transport manager to
		   
			ta = tm.getTransportationDetails(origin,destination,fromDate);//should return a JSONString
				
			 response.getWriter().println(ta); //pass to client
			 
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			 
		 } */
		 }
			 catch(Exception e){
				 e.printStackTrace();
			 }
			
	 }


		 
		 @RequestMapping(value ="/Login") 
		   public void authenticateUser(HttpServletResponse response,HttpServletRequest request) throws IOException{
		  //get receive JSON data from request
		   BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		   String json ="";
		   if(br!=null){
			   json = br.readLine();
		   }  
		   UserAccount ua;
		   //set response type to JSON
		   response.setContentType("application/json");
		   //user's credential, log in using email and password
		   String email = request.getParameter("email");
		   String password = request.getParameter("password");
		   
		   
			 try {
				UserAccountManager uam = new UserAccountManager();
				 /*call method from UserAccountManager to validate email and password
			   
				ua = tm.handleTransportRequestJSON();//should return a JSONString
					
				 response.getWriter().println(ua); //pass to client
				 
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			 }
			 */
			 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
			 }
		 
		 
		 @RequestMapping(value ="/place") 
		   public void getPlace(HttpServletResponse response,HttpServletRequest request) throws IOException{
		  //get receive JSON data from request
		   BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		   String json ="";
		   if(br!=null){
			   json = br.readLine();
		   }  
		   PlaceActivity pa;
		   //set response type to JSON
		   response.setContentType("application/json"); 
		   //deserialze JSONString and convert to //list<String> keywords or thru parameters

		   		   
			 try {
				PlaceManager pm = new PlaceManager();
				 /*call method from PlaceManager to retrieve list of place
			   
				pa = pm.handlePlaceRequestJSON(location,radius,keywords);//should return a JSONString		
				 response.getWriter().println(pa); //pass to client
				 
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			 }
			 */
			 }
				 catch(Exception e){
					 e.printStackTrace();
				 }
			 }
		 
		 
}
			
	 



