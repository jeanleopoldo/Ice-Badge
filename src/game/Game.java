package game;

import table.Position;
import table.Table;

public class Game {

	protected Table table_;
	protected Player player_;
	protected Player opponent_;

	public Game(int width, int height) {
		this.table_ = new Table(height, width);
		this.opponent_ = new Player();
	}

	public Position getPosition(int x, int y) {
		return this.table_.getPosition(x, y);

	}

	public void setPlayersOnTable(int i, Player player) {
		this.table_.createTable(2);
		Position mainBases[] = this.table_.getMainBases();

		this.player_ = player;

		if (i == 1) {
			this.player_.setTurn(true);
			this.player_.addBase(mainBases[0]);
			this.opponent_.addBase(mainBases[1]);
		} else {
			this.player_.addBase(mainBases[1]);
			this.opponent_.addBase(mainBases[0]);
		}
	}

	public String getPlayerName() {
		return this.player_.getName();
	}

	public Action selectPosition(Position clickedPosition) {
		if (this.player_.getSelectedPosition() == null)
			this.player_.setSelectedPosition(clickedPosition);
		return new Action(null, null, TypeAction.SELECT_CHARACTER);
	}

	public Action attack(Position clickedPosition) {
		System.out.println("attack");
		return null;
	}

	public Action move(Position clickedPosition) {
		Position selectedPosition = this.player_.getSelectedPosition();
		Character character = selectedPosition.getCharacter();

		clickedPosition.setCharacter(character);
		selectedPosition.removeCharacter();

		return new Action(selectedPosition, clickedPosition, TypeAction.MOVE);
	}

	public Action changeTurn() {
		this.player_.setTurn(false);
		this.opponent_.setTurn(true);

		return new Action(null, null, TypeAction.CHANGE_TURN);
	}

	public void selectCharacter(Player player, TypeCharacter type) {
		Character character;

		switch (type) {

		case SWORDSMAN:

			character = new Character(100, 50, 3, 4, TypeCharacter.SWORDSMAN);
			player.addCharacter(character);
			this.table_.setCharacterOnTable(player, character);
			break;

		case ARCHER:
			character = new Character(100, 35, 7, 3, TypeCharacter.ARCHER);
			player.addCharacter(character);
			this.table_.setCharacterOnTable(player, character);
			break;

		case BARD:

			character = new Character(100, 30, 5, 5, TypeCharacter.BARD);
			player.addCharacter(character);
			this.table_.setCharacterOnTable(player, character);
			break;

		case CLERIG:

			character = new Character(100, 25, 2, 8, TypeCharacter.CLERIG);
			player.addCharacter(character);
			this.table_.setCharacterOnTable(player, character);
			break;

		}
	}

	public Player getOpponent() {
		return this.opponent_;
	}

	public Table getTable() {
		return this.table_;
	}

}
