package tests;

import game.Control;
import game.Game;
import game.Player;
import game.TypeCharacter;
import table.Position;
import game.Character;

public class Tests {

	private Control control_;
	private Game game_;
	private Player player_;
	private Player opponent_;

	public Tests(Control control) {
		this.control_ = control;
		this.control_.create_player("Jean");
		this.control_.receive_begin_message(1);
		this.game_ = this.control_.get_game();
		this.player_ = this.control_.get_player();
		this.opponent_= this.game_.get_opponent();
		test_move();
	}

	public void test_move() {
		Character cPl = new Character(20, 20, 20, 20, TypeCharacter.SWORDSMAN);
		Character cOp = new Character(20, 20, 20, 20, TypeCharacter.SWORDSMAN);
		
		Position p1 = this.game_.get_position(10, 10);
		Position p2 = this.game_.get_position(11, 12);
		
		this.player_.add_character(cPl);
		this.opponent_.add_character(cOp);
		
		p1.set_character(cPl);
		p2.set_character(cOp);
		
		this.control_.move(10, 10);
		this.control_.move(11, 13);
		this.control_.move(11, 12);
		
		this.control_.change_turn();
		
	}

}
