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

	public Character getCharacter() {
		return this.character_;
	}

	public void setCharacter(Character character) {
		this.character_ = character;
	}

	public TypeTile getTile() {
		return this.type_;
	}

	public void setTile(TypeTile type) {
		this.type_ = type;

	}

	public void removeCharacter() {
		this.character_ = null;

	}

	public int getX() {
		return this.x_;
	}
	public int getY() {
		return this.y_;
	}

}
