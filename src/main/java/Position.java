


public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void incrementPosition(int increment_x, int increment_y){
        x += increment_x;
        y += increment_y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
