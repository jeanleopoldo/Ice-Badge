package game;

import netgames.ActorNetGames;
import table.Position;

public class Control {

	protected ActorNetGames netgames_;
	protected Game game_;
	protected Player player_;

	public Control() {
		this.player_ = new Player();
		this.netgames_ = new ActorNetGames(this);
	}

	public void connect() {
		// this.netgames_.connect();
	}

	public void startGame() {
		this.netgames_.startGame();
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

	public Action makeAction(int x, int y) {
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

	public void selectCharacter(TypeCharacter type) {
		System.out.println(this.player_.isTurn());
		if (this.player_.isTurn()) {
			this.game_.selectCharacter(this.player_, type);

		}
	}

	// #############################################
	// TESTS

	public Game getGame() {
		return this.game_;
	}

	public Player getPlayer() {
		return this.player_;
	}
}