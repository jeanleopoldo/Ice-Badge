package game;

public enum TypeCharacter {
	
	SWORDSMAN(40, 20, 5, 5),
	CLERIG(10, 25, 3, 5),
	ARCHER(30, 20, 8, 2),
	BARD(20, 20, 2, 6);

	protected int life_;
	protected int powerAttack_;
	protected int rangeAttack_;
	protected int rangeMove_;

	TypeCharacter(int life, int powerAttack, int rangeAttack, int rangeMove) {
		this.life_ = life;
		this.powerAttack_ = powerAttack;
		this.rangeAttack_ = rangeAttack;
		this.rangeMove_ = rangeMove;
	}

	public int getLife() {
		return life_;
	}

	public int getPowerAttack_() {
		return powerAttack_;
	}

	public int getRangeAttack_() {
		return rangeAttack_;
	}

	public int getRangeMove_() {
		return rangeMove_;
	}

}
