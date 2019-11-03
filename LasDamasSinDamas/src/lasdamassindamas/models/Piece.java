package lasdamassindamas.models;

public class Piece {

	private Color color;

	public Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isBlack() {
		return this.color == Color.BLACK;
	}
        
        public boolean isWhite() {
		return this.color == Color.WHITE;
	}

	public boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		if (color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
	}

}