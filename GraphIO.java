import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {
	private ArrayList<String> 
	
	static public void readFile(Graph g, String filename) throws IOException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			scanner.next().toString();
			break;
		}
	}	
}
