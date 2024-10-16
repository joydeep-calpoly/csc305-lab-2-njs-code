import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

final class Dignitary {
	private String name = "";
	private ArrayList<Award> awards = new ArrayList<Award>();
	private ArrayList<String> accomplishments = new ArrayList<String>();
	
	public Dignitary (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getAccomplishments(){
		return this.accomplishments;
	}
	
	public ArrayList<Award> getAwards(){
		return this.awards;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.name);
		str.append("\n\nKnown For");
		for (String accomplishment : this.accomplishments) {
			str.append("\n\t");
			str.append(accomplishment);
		}
		str.append("\nAwards:");
		for (Award award : this.awards) {
			str.append("\n\t");
			str.append(award);
		}
		return str.toString();
	}
	
	
 	public void setAwards(JSONArray input) throws JSONException {
		for (int i=0;i<input.length();i++) {
			JSONObject awardInfo = input.getJSONObject(i);
			String awardName = awardInfo.getString("name");
			int awardYear = awardInfo.getInt("year");
			Award thisAward = new Award(awardName, awardYear);
			this.awards.add(thisAward);
		}
	}
	
	public void setAccomplishments(JSONArray input) {
		for (int i=0; i < input.length(); i++) {
			try {
				String accomplishment = input.getString(i);
				this.accomplishments.add(accomplishment);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	// represents an award with a name and year
	private class Award {
		private String name = "";
		private int year = 0;
		
		public Award(String name, int year){
			this.name = name;
			this.year = year;
		}
		
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append(this.name);
			str.append(", ");
			str.append(this.year);
			return str.toString();
		}
	}
}
	
