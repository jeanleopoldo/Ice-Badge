package game;

public class Action {
	protected int initX;
	protected int initY;
	protected int endX;
	protected int endY;
	protected TypeAction type_;

	public Action(TypeAction type) {

	}

	public Action(int initX, int initY, int endX, int endY) {
		this.initX = initX;
		this.initY = initY;
		this.endX = endX;
		this.endY = endY;
	}

}
