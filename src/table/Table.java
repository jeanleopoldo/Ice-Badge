package table;

public class Table {

	protected Position[][] positions_;
	protected int rowSize_;
	protected int columnSize_;

	public Table(int rowSize, int columnSize) {
		this.rowSize_ = rowSize;
		this.columnSize_ = columnSize;
		this.positions_ = new Position[rowSize_][columnSize_];
		this.createTable();
	}

	private void createTable() {
		for (int i = 0; i < rowSize_; i++) {
			for (int j = 0; j < columnSize_; j++) {
				this.positions_[i][j] = new Position(i, j, TypeTile.GRASS);
				System.out.println(this.positions_[i][j].getTile());
			}
		}
	}
	
	public void setMainBases() {
		this.positions_[0][15].setTile(TypeTile.MAIN_BASE_1);
		this.positions_[31][15].setTile(TypeTile.MAIN_BASE_2);
	}

	public Position getPosition(int x, int y) {
		if (x <= rowSize_ && y <= columnSize_) {
			return this.positions_[x][y];
		}
		return null;
	}

}
