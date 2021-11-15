import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private Position position;
    private String symbol;
    public Wall(int x, int y){
        position = new Position(x, y);
        symbol = "X";
    }
    public Position getPosition(){
        return position;
    }
    public void draw(@org.jetbrains.annotations.NotNull TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#BD8142"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),symbol);
    }
}
