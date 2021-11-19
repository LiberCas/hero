import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    public Arena(int w, int h){
        height = h;
        width = w;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<Wall>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#1AB817"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        hero.draw(graphics);
    }
    public boolean canHeroMove(Position newPos){
        if(newPos.getX() < 0 || newPos.getY() < 0 || width <= newPos.getX() || height <= newPos.getY()) {
            return false;
        }
        for (Wall item : walls) {
            if (item.getPosition().equals(newPos))
                return false;
        }
        return true;
    }
    public void retrieveCoin(int index){
        coins.remove(index);
    }
    public void moveHero(Position position){
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
        for (int index=0; index<coins.size(); index++) {
            if (coins.get(index).getPosition().equals(position)) {
                retrieveCoin(index);
                break;
            }
        }
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
