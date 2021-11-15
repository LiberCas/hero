import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int height;
    private int width;
    private Hero hero;
    public Arena(int h, int w){
        height = h;
        width = w;
        hero = new Hero(10, 10);
    }
    public void draw(Screen screen){
        hero.draw(screen);
    }
    public void moveHero(Position position){
        hero.setPosition(position);
    }
    public int processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());
        else if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        else if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());
        else if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());
        else if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || (key.getKeyType() == KeyType.EOF)) {
            return 0;
        }
        return 1;
    }




}
