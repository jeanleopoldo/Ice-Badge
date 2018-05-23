package game;

import java.util.ArrayList;

import table.Position;

public class Player {
	protected String name_;
	protected boolean turn_;
	protected Position selectedPosition_;
	protected ArrayList<Character> listCharacter_;
	
	public Player(String name) {
		this.name_ = name;
		this.listCharacter_ = new ArrayList<>();
		this.turn_ = false;
	}
	
	public Player() {
		this.listCharacter_ = new ArrayList<>();
		this.turn_ = false;
		this.name_ = "Opponent";
	}

	public String getName() {
		return this.name_;
	}
	public void setName(String name) {
		this.name_ = name;
	}

	public boolean isTurn() {
		return this.turn_;
	}
	
	public void setTurn(boolean turn) {
		this.turn_ = turn;
	}
	
	public void setSelectedPosition(Position position) {
		this.selectedPosition_ = position;
	}
	
	public Position getSelectedPosition() {
		return this.selectedPosition_;
	}
	
	public void addCharacter(Character character) {
		this.listCharacter_.add(character);
	}
	
	public void removeCharacter(Character character) {
		this.listCharacter_.remove(character);
	}
	
	public ArrayList<Character> getListCharacter() {
		return this.listCharacter_;
	}
	
	public boolean checkPlayerCharacter(Character character) {
		if (this.listCharacter_.contains(character))
			return true;
		return false;
	}

}
