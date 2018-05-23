package game;

import table.Position;

public class Control {

	protected Game game_;
	protected Player player_;

	public void create_player(String name) {
		player_ = new Player(name);
	}

	public void receive_begin_message(int i) {
		this.game_ = new Game(32, 32);
		this.game_.set_players_on_table(i, this.player_);
	}

	public Move change_turn() {
		if (this.player_.is_turn()) {
			return this.game_.change_turn();
		}
		return null;
	}

	public Move move(int x, int y) {
		Position clicked_position = null;
		Character character;
		
		if (this.player_.is_turn()) {
			clicked_position = this.game_.get_position(x, y);
			character = clicked_position.get_character();

			if (clicked_position.get_character() != null) {

				if (this.player_.check_player_character(character)) {
					return this.game_.select_position(clicked_position);
				}

				return this.game_.attack(clicked_position);
			}

			return this.game_.move(clicked_position);
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
