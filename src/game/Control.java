package game;

import table.Position;

public class Control {

	protected Game game_;
	protected Player player_;

	public void createPslayer(String name) {
		player_ = new Player(name);
	}

	public void receiveBeginMessage(int i) {
		this.game_ = new Game(32, 32);
		this.game_.setPlayersOnTable(i, this.player_);
	}

	public Action changeTurn() {
		if (this.player_.isTurn()) {
			return this.game_.changeTurn();
		}
		return null;
	}

	public Action makeActions(int x, int y) {
		Position clickedPosition = null;
		Character character;
		
		if (this.player_.isTurn()) {
			clickedPosition = this.game_.getPosition(x, y);
			character = clickedPosition.getCharacter();

			if (clickedPosition.getCharacter() != null) {

				if (this.player_.checkPlayerCharacter(character)) {
					return this.game_.selectPosition(clickedPosition);
				}

				return this.game_.attack(clickedPosition);
			}

			return this.game_.move(clickedPosition);
		}
		return null;
	}

	// #############################################
	// TESTS

	public Game get_game() {
		return this.game_;
	}

	public Player get_player() {
		return this.player_;
	}
}
