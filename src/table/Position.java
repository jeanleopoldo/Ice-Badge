package table;

import game.Character;

public class Position {

	protected int x_;
	protected int y_;
	protected Character character_;
	protected TypeTile type_;
	protected String image_;

	public Position(int x, int y, TypeTile type) {
		this.x_ = x;
		this.y_ = y;
		this.type_ = type;
	}

	public Character get_character() {
		return this.character_;
	}

	public void set_character(Character character) {
		this.character_ = character;
	}

	public TypeTile get_tile() {
		return this.type_;
	}

	public void set_tile(TypeTile type) {
		this.type_ = type;

	}

	public void remove_character() {
		this.character_ = null;

	}

}
