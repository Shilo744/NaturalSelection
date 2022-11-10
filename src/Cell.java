import java.awt.*;
import java.util.Random;

public class Cell {
    //cell parameters
    public static final int START_POSITION_X = Window.WINDOW_WIDTH / 2;
    public static final int START_POSITION_Y = Window.WINDOW_HEIGHT / 2;
    public static final int CELL_WIDTH_AND_HEIGHT = 15;
    private Random random = new Random();
    private int speed = 2;
    private NaturalEnvironment area;
    private Color rightEnvironment;
    private Color cellColor;
    private int x = START_POSITION_X;
    private int y = START_POSITION_Y;
    private boolean dead = false;
    private int maxLife = 2000;
    private int numOfCycles = 0;
    private int changeDistanceAmount = 30;
     public boolean duplicate=false;
     private boolean randomColor=false;
    public Cell(int from, int to,int x,int y){
        this.x=x;
        this.y=y;
        startingHelper(from,to);
    }
    public Cell(int from, int to) {
       startingHelper(from,to);
    }
    private void startingHelper(int from, int to){
        if (from < 0) {
            from = 0;
        }
        if (to > Window.WINDOW_WIDTH) {
            to = Window.WINDOW_WIDTH;
        }
        if (to < from) {
            int switchIt = to;
            to = from;
            from = switchIt;
        }
        area = new NaturalEnvironment(from, to);
        if(randomColor){
        cellColor = randomColor();}
        else {
            boolean isBlack=random.nextBoolean();
            if(isBlack){
                cellColor=Color.black;
            }else cellColor=Color.white;
        }
        maxLife = (int) (Math.random() * maxLife);
    }
    public Cell duplicate() {
        int changer = (int) (Math.random() * changeDistanceAmount - Math.random() * changeDistanceAmount);
        Cell cell = new Cell(changeLocation(area.getFrom() + changer, random.nextBoolean()), changeLocation(area.getTo() + changer, random.nextBoolean()),x,y);
        return cell;
    }
    public void limit(){
        if(x<300||x>700){
            dead=true;
        }
    }
    public void move() {
//        limit();
//        if(x<700&&x>600){
//           duplicate=true; }
//        else duplicate=false;
        boolean plusX = random.nextBoolean();
        boolean plusY = random.nextBoolean();
        if (x < area.getFrom()) {
            x++;
        } else if (x > area.getTo()) {
            x--;
        }
        x = changeLocation(x, plusX);
        y = changeLocation(y, plusY);
        if (plusY) {
            y++;
        } else {
            y--;
        }
        numOfCycles++;
        if (numOfCycles >= maxLife) {
            dead = true;
        }
        if (y < 0 || y > Window.WINDOW_HEIGHT) {
            dead=true;
        }
    }
    private int changeLocation(int o, boolean plus) {
        if (plus) {
            o += speed;
        } else {
            o -= speed;
        }
        return o;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(cellColor);
        graphics.fillOval(x, y, CELL_WIDTH_AND_HEIGHT, CELL_WIDTH_AND_HEIGHT);
    }

    public static Color randomColor() {
        Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        return color;
    }

    public NaturalEnvironment getArea() {
        return area;
    }

    public boolean isDead() {
        return dead;
    }

    public void reset() {
        x = START_POSITION_X;
        y = START_POSITION_Y;
    }
}
