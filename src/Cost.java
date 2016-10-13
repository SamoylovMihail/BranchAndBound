
public class Cost {

	private short[][] costMatrix;

	public Cost(int numRows, int numCols) {
		costMatrix = new short[numRows + 1][numCols + 1];
	}

	public void assignCost(short s, int row, int col) {
		costMatrix[row][col] = s;
	}

	public short cost(int row, int col) {
		return costMatrix[row][col];
	}

}
