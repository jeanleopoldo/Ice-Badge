package game;

public class Move {
	
	protected int init_x;
	protected int init_y;
	protected int end_x;
	protected int end_y;
	protected TypeMove type_;
	
	public Move(TypeMove type) {
		this.type_ = type;
	}
}
