package game;

public class Move {
	
	protected int init_x;
	protected int init_y;
	protected int end_x;
	protected int end_y;
	protected TypeAction type_;
	
	public Move(TypeAction type) {
		this.type_ = type;
	}
}
