package task2_take2;

import java.util.List;
import com.fasterxml.jackson.annotation.*;

public class Dignitary {
	private List<Award> awards;
	private List<String> knownFor;
	private String name;
	
	@JsonCreator
	public Dignitary(@JsonProperty("awards") List<Award> awards,
			  @JsonProperty("knownFor") List<String> knownFor,
			  @JsonProperty("name") String name
			) 
	{
		this.name = name;
		this.knownFor = knownFor;
		this.awards = awards;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.name);
		str.append("\n\nKnown For");
		for (String accomplishment : this.knownFor) {
			str.append("\n\t");
			str.append(accomplishment);
		}
		str.append("\nAwards:");
		for (Award award : this.awards) {
			str.append("\n\t");
			str.append(award);
		}
		str.append("\n\n");
		return str.toString();
		}
	
	private static class Award {
		@JsonProperty("name")
		private String name;
		@JsonProperty("year")
		private int year;
		
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append(this.name);
			str.append(", ");
			str.append(this.year);
			return str.toString();
		}
	}
}
