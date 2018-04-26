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

	public Position get_position(int x, int y) {
		return this.table_.get_position(x, y);

	}

	public void set_players_on_table(int i, Player player) {
		this.player_ = player;
		if (i == 1) {
			this.player_.set_turn(true);
		}
	}

	public String get_player_name() {
		return this.player_.get_name();
	}

	public Move select_position(Position clicked_position) {
		if (this.player_.get_selected_position() == null)
			this.player_.set_selected_position(clicked_position);
		System.out.println("select");
		return null;
	}

	public Move attack(Position clicked_position) {
		System.out.println("attack");
		return null;
	}

	public Move move(Position clicked_position) {
		Position selected_position = this.player_.get_selected_position();
		Character character = selected_position.get_character();
		
		clicked_position.set_character(character);
		selected_position.remove_character();
		

		return null;
	}

	public Move change_turn() {
		this.player_.set_turn(false);
		this.opponent_.set_turn(true);

		return new Move(TypeMove.CHANGE_TURN);
	}

	// ##########################
	// teste

	public Player get_opponent() {
		return this.opponent_;
	}

}
