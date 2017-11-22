/**
 * 
 */
package org.escoladeltreball.bicing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * @author iaw47941842
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws JsonSyntaxException 
	 * @throws JsonIOException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws JsonIOException, JsonSyntaxException, IOException {
		// TODO Auto-generated method stub
		String json = "";
		BufferedReader inReader = null;		
		
		// leer fichero linia a linia
		try  {
			inReader = new BufferedReader(new FileReader("stations.json"));
			String line;
			while ((line = inReader.readLine()) != null) {
				json += line;
			}			
			
		} finally {
			if (inReader != null) {
				inReader.close();
			}
		}	
		
		Gson gson = new Gson();
		//System.out.println(json);
		
		// Parser 
		
		JsonParser jsonParser = new JsonParser();
		JsonElement element = jsonParser.parse(json);		
		JsonObject obj = element.getAsJsonObject();			
		//System.out.println(obj.get("stations").getAsJsonArray());
		JsonArray jsonArray = obj.get("stations").getAsJsonArray();
		
		
		int id = 0;
		String type = "";
		double latitude = 0;
		double longitude = 0;
		String streetName = "";
		String streetNumber = "";
		int altitude= 0;
		int slots = 0;
		int bikes= 0;
		String nearbyStations = "";
		String status = "";
		int j = 1;
		if (jsonArray.isJsonArray()) {			
			for (int i = 0; i < jsonArray.getAsJsonArray().size(); i++) {
				System.out.println("Station: " + j + "\n*********************");
				JsonObject aux = jsonArray.getAsJsonArray().get(i).getAsJsonObject();
				id = aux.get("id").getAsInt();
				type = aux.get("type").getAsString();
				latitude = aux.get("latitude").getAsDouble();
				longitude = aux.get("longitude").getAsDouble();
				streetName = aux.get("streetName").getAsString();
				streetNumber= aux.get("streetNumber").getAsString();
				altitude = aux.get("altitude").getAsInt();
				slots = aux.get("slots").getAsInt();
				bikes = aux.get("bikes").getAsInt();
				nearbyStations = aux.get("nearbyStations").getAsString();
				status = aux.get("status").getAsString();
				System.out.println("Id: " + id + "\nType: " + type + "\nLatitude: " + latitude + "\nLongitude: " + longitude + "\nStreet Name: " + streetName + "\nStreet Number: " + streetNumber + "\nAltitude: " + altitude + "\nSlots: " + slots + "\nBikes: " + "\nNearby Stations: " + nearbyStations + "\nStatus: " + status);
				System.out.println("**********************");
				j++;
			}			
			//System.out.println("array");
		} else {
			System.out.println("no array");
		}
		
	
		
//		JsonParser parser = new JsonParser();
//		Object obj = parser.parse(new FileReader("stations.json"));
//		
//		JsonObject jsonObject = (JsonObject) obj;
		
		
		
		
		

	}

}
