
public interface IATSPParser {
	
	public String getName();
	public String getType();
	public String getComment();
	public int getDimension();
	public String getEdgeWeightType();
	public String getEdgeWeightFormat();
	public int getEdgeWeight(short row, short col);
	public short[][] getCostMatrix();
}
