import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

abstract class Element {
    protected Position position;
    protected String symbol;
    protected String colour;
    public Element(int x, int y, String colour, String symbol){
        position = new Position(x, y);
        this.colour = colour;
        this.symbol = symbol;
    }
    public Position getPosition() {
        return position;
    }
    public void draw (TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString(colour));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),symbol);
    }
}
