package table;

public class Table {

	protected Position[][] positions_;
	protected int row_size_;
	protected int column_size_;

	public Table(int row_size, int column_size) {
		this.row_size_ = row_size;
		this.column_size_ = column_size;
		this.positions_ = new Position[row_size_][column_size_];
		this.create_table();
	}

	private void create_table() {
		for (int i = 0; i < row_size_; i++) {
			for (int j = 0; j < column_size_; j++) {
				this.positions_[i][j] = new Position(i, j, TypeTile.GRASS);
				System.out.println(this.positions_[i][j].get_tile());
			}
		}
	}

	public Position get_position(int x, int y) {
		if (x <= row_size_ && y <= column_size_) {
			return this.positions_[x][y];
		}
		return null;
	}

}
