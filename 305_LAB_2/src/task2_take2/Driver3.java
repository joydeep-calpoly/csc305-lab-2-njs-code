package task2_take2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.*;

public class Driver3 {

	public static void main(String[] args) throws IOException {
		String[] filepaths = {"input1.json", "input2.json", "input3.json"};
		
		ObjectMapper mapper = new ObjectMapper();

		for (String filename : filepaths) {
			byte[] jsonData = Files.readAllBytes(Paths.get(filename));
			Dignitary person = mapper.readValue(jsonData, Dignitary.class);
			System.out.println(person);
			System.out.println("----------------");
		}		
	}
}
