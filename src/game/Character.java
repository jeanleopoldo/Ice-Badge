package game;

public class Character {

	protected int life_;
	protected int power_attack_;
	protected int range_attack_;
	protected int range_move_;
	protected boolean moved_;
	protected boolean attacked_;
	protected TypeCharacter type_;

	public Character(int life, int power_attack, int range_attack, int range_move, TypeCharacter type) {
		this.life_ = life;
		this.power_attack_ = power_attack;
		this.range_attack_ = range_attack;
		this.range_move_ = range_move;
		this.type_ = type;
		this.moved_ = false;
		this.attacked_ = false;

	}
	
	public int get_life() {
		return this.life_;
	}

	public TypeCharacter get_type() {
		return this.type_;
	}

	public boolean get_moved() {
		return this.moved_;
	}

	public boolean get_attacked() {
		return this.attacked_;
	}

}
