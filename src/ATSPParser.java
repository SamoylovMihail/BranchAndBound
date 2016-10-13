import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ATSPParser implements IATSPParser {
	
	//^(\d+\s+){16}\d+$
	
	private String name;
	private String type;
	private String comment;
	private int dimension;
	private String edgeWeightType;
	private String edgeWeightFormat;
	private short[][] costMatrix;
	
	public ATSPParser(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String temp = br.readLine();
			String regexp = "^NAME:\\s+(.*)$";
			name = find(regexp, temp);
			temp = br.readLine();
			regexp = "^TYPE:\\s+(.*)$";
			type = find(regexp, temp);
			temp = br.readLine();
			regexp = "^COMMENT:\\s+(.*)$";
			comment = find(regexp, temp);
			temp = br.readLine();
			regexp = "^DIMENSION:\\s+(.*)$";
			dimension = Integer.parseInt(find(regexp, temp));
			temp = br.readLine();
			regexp = "^EDGE_WEIGHT_TYPE:\\s+(.*)$";
			edgeWeightType = find(regexp, temp);
			temp = br.readLine();
			regexp = "^EDGE_WEIGHT_FORMAT:\\s+(.*)$";
			edgeWeightFormat = find(regexp, temp);
			
			int i = 1;
			int j = 1;
			costMatrix = new short[dimension + 1][dimension + 1];
			br.readLine();
			temp = br.readLine();
			while (temp != null) {
				if (j >= dimension + 1) {
					i++;
					j = 1;
				}
				
				Pattern pattern = Pattern.compile("(\\d+)\\s*");
				Matcher matcher = pattern.matcher(temp);
				while (matcher.find()) {
					int edgeWeight = Integer.parseInt(matcher.group(1));
					if (edgeWeight == 9999) edgeWeight = 0;
					costMatrix[i][j] = (short) edgeWeight;
					j++;
				}
				temp = br.readLine();
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String find(String regexp, String temp) {
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(temp);
		matcher.find();
		return matcher.group(1);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getComment() {
		return comment;
	}

	@Override
	public int getDimension() {
		return dimension;
	}

	@Override
	public String getEdgeWeightType() {
		return edgeWeightType;
	}

	@Override
	public String getEdgeWeightFormat() {
		return edgeWeightFormat;
	}

	@Override
	public int getEdgeWeight(short row, short col) {
		return costMatrix[row][col];
	}

	@Override
	public short[][] getCostMatrix() {
		return costMatrix;
	}
}
