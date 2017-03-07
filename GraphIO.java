import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;


/**
 * Reads file containing information of a graph and then adds the nodes and edges.
 * @author isawah-6
 *
 */
public class GraphIO {	
	private static ArrayList<int[]> input = new ArrayList<int[]>();
	private static int numberOfNodes;
	
	/**
	 * Reads from file "filename" and then adds the nodes and edges.
	 * @param g
	 * @param filename
	 * @throws IOException
	 */
	static public void readFile(Graph g, String filename) throws IOException {	
		
		try {
			Scanner scanner = new Scanner(new FileReader(filename));
			input.add(new int[]{scanner.nextInt()});		
			numberOfNodes = input.get(0)[0];
		
			while(scanner.hasNext()) {
				input.add(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
			}
			
			scanner.close();
		}catch (IOException e) {
			throw e;
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
		for(int i = numberOfNodes + 1; i < input.size(); i++) {
			g.addEdge(input.get(i)[0], input.get(i)[1], input.get(i)[2]);
		}
	}
}
