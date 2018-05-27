package game;

public class Character {

	protected int life_;
	protected int powerAttack_;
	protected int rangeAttack_;
	protected int rangeMove_;
	protected boolean moved_;
	protected boolean attacked_;
	protected TypeCharacter type_;

	public Character(int life, int powerAttack, int rangeAttack, int rangeMove, TypeCharacter type) {
		this.life_ = life;
		this.powerAttack_ = powerAttack;
		this.rangeAttack_ = rangeAttack;
		this.rangeMove_ = rangeMove;
		this.type_ = type;
		this.moved_ = false;
		this.attacked_ = false;

	}
	
	public int getLife() {
		return this.life_;
	}

	public TypeCharacter getType() {
		return this.type_;
	}

	public boolean get_moved() {
		return this.moved_;
	}

	public boolean getAttacked() {
		return this.attacked_;
	}

}
