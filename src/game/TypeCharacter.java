package game;

public enum TypeCharacter {
	SWORDSMAN(40, 20, 0, 5, 5),
	CLERIG(10, 0, 15, 3, 5),
	ARCHER(30, 20, 0, 8, 2),
	BARD(20, 20, 0, 2, 6);

	TypeCharacter(int life, int power_attack, int power_healing, int range_attack, int range_move) {
	}

}
