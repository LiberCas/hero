import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{
    public Hero(int x, int y){
        super(x, y, "FF0C0C", "O");
    }
    //Movement methods
    //-------------------------------------
    public void setPosition(Position position){
        this.position = position;
    }
    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }
    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }
    //------------------------------------
    @Override
    public void draw(TextGraphics graphics){
        graphics.enableModifiers(SGR.BOLD);
        super.draw(graphics);
    }
}
