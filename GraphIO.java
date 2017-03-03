import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class GraphIO {
	private static ArrayList<int[]> input = new ArrayList<int[]>();
	private static int numberOfNodes;
	
	private static BufferedReader br = null;
	
	static public void readFile(Graph g, String filename) throws IOException {
		
		
		numberOfNodes = input.get(0)[0];
		
		//File file = new File(filename);
		Scanner scanner = new Scanner(new FileReader(filename));
		
		if(scanner.hasNextLine()) {
			input.add(new int[]{scanner.nextInt()});
		}
		
		while(scanner.hasNextLine()) {
			input.add(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
			break;
		}
		
		addNodes(g);
		addEdges(g);
	}
	
	private static void addNodes(Graph g) {
		for(int i = 1; i <= numberOfNodes; i++) {
			g.addNode(input.get(i)[0], input.get(i)[1], input.get(i)[2]);
		}
	}
	
	private static void addEdges(Graph g) {
		for(int i = numberOfNodes + 1; i <= input.size(); i++) {
			g.addEdge(input.get(i)[0], input.get(i)[1], input.get(i)[2]);
		}
	}
}
