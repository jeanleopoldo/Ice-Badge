package game;

import java.util.ArrayList;

import table.Position;

public class Player {
	protected String name_;
	protected boolean turn_;
	protected Position selected_position_;
	protected ArrayList<Character> list_character_;
	
	public Player(String name) {
		this.name_ = name;
		this.list_character_ = new ArrayList<>();
		this.turn_ = false;
	}
	
	public Player() {
		this.list_character_ = new ArrayList<>();
		this.turn_ = false;
		this.name_ = "Opponent";
	}

	public String get_name() {
		return this.name_;
	}
	public void set_name(String name) {
		this.name_ = name;
	}

	public boolean is_turn() {
		return this.turn_;
	}
	
	public void set_turn(boolean turn) {
		this.turn_ = turn;
	}
	
	public void set_selected_position(Position position) {
		this.selected_position_ = position;
	}
	
	public Position get_selected_position() {
		return this.selected_position_;
	}
	
	public void add_character(Character character) {
		this.list_character_.add(character);
	}
	
	public void remove_character(Character character) {
		this.list_character_.remove(character);
	}
	
	public ArrayList<Character> get_list_character() {
		return this.list_character_;
	}
	
	public boolean check_player_character(Character character) {
		if (this.list_character_.contains(character))
			return true;
		return false;
	}

}
