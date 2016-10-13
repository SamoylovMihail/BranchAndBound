
public class Main {

	public static int maxWorkTime;
	
	public static void main(String[] args) {
		ATSPParser atspParser = new ATSPParser(args[0]);
		maxWorkTime = Integer.parseInt(args[1]);
		TSP tsp = new TSP(atspParser.getCostMatrix(), atspParser.getDimension());
		tsp.generateSolution();
	}

}
