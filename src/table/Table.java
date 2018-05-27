package table;

import game.Character;
import game.Player;

public class Table {

	protected Position[][] positions_;
	protected int rowSize_;
	protected int columnSize_;
	protected Position mainBases_[];

	public Table(int rowSize, int columnSize) {
		this.rowSize_ = rowSize;
		this.columnSize_ = columnSize;
		this.positions_ = new Position[rowSize_][columnSize_];
	}

	public void createTable(int numberOfPlayers) {

		for (int i = 0; i < rowSize_; i++) {
			for (int j = 0; j < columnSize_; j++) {
				this.positions_[i][j] = new Position(i, j, TypeTile.GRASS);
				System.out.println(this.positions_[i][j].getTile());
			}
		}
		this.mainBases_ = new Position[numberOfPlayers];
		this.setMainBases();
	}

	private void setMainBases() {
		Position mainBase1 = this.getPosition(0, 15);
		mainBase1.setTile(TypeTile.MAIN_BASE_1);
		this.mainBases_[0] = mainBase1;

		Position mainBase2 = this.getPosition(31, 15);
		mainBase2.setTile(TypeTile.MAIN_BASE_2);
		
		this.mainBases_[1] = mainBase2;

	}

	public Position getPosition(int x, int y) {
		if (x <= rowSize_ && y <= columnSize_) {
			return this.positions_[x][y];
		}
		return null;
	}

	public Position[] getMainBases() {
		return this.mainBases_;
	}

	public void setCharacterOnTable(Player player, Character character) {
		
	}

}
