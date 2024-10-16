import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Driver
{
	public static void main(String[] args) 
	{
		String[] filepaths = {"input1.json", "input2.json", "input3.json"};
		for (String file : filepaths) {
			File jsonInput = new File(file);
			try {
				//load File into String
				Scanner scanner = new Scanner(jsonInput, "UTF-8" );
			    String content = scanner.useDelimiter("\\A").next();
			    scanner.close();
			    
			    //Build JsonObjects/Arrays from json input
			    JSONObject json = new JSONObject(content);
			    JSONArray knownFor = json.getJSONArray("knownFor");
			    JSONArray awards = json.getJSONArray("awards");
			    String name = json.getString("name");
			    
			    //construct Dignitary object from name, awards, knownFor
			    Dignitary person = new Dignitary(name);
			    person.setAwards(awards);
			    person.setAccomplishments(knownFor);
			    System.out.println(person);
			    System.out.println("\n----------------------\n");
			} catch (FileNotFoundException | JSONException e) {
				System.out.println("Error: File or JSON not found.");
			}
		}
			
		
	}
}

//class article
//