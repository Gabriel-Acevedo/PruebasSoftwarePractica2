package lasdamassindamas.models;

class Square {

    private Piece piece;
    private Color color;
    private Coordinate coordinate;
    
    
    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    void put(Piece piece) {
        this.piece = piece;
    }

    Piece remove() {
        Piece piece = this.piece;
        this.piece = null;
        return piece;
    }

    Piece getPiece() {
        return this.piece;
    }

	public boolean isEmpty() {
		return this.piece == null;
	}

	public Color getColor() {
        if (piece == null){
            return null;
        }
		return this.piece.getColor();
	}

}