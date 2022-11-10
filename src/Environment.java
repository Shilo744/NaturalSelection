import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Environment extends JPanel {
    //Environment parameters
    public static final int START_POSITION_ZERO=0;
    public static final int ENVIRONMENT_WIDTH=Window.WINDOW_WIDTH;
    public static final int ENVIRONMENT_HEIGHT=Window.WINDOW_HEIGHT;
    Cell cell=new Cell(0,Window.WINDOW_WIDTH);
    Areas areas=new Areas();
    private int counterCount=2;
    private int maxCells=1000;
    private int counter=counterCount;
    private LinkedList<Cell> cells=new LinkedList();
    private final int NUMBER_COUNTER_TO_RESET=1000;
    private int counterToReset=NUMBER_COUNTER_TO_RESET;
    Environment(){
        this.setBounds(START_POSITION_ZERO,START_POSITION_ZERO,ENVIRONMENT_WIDTH,ENVIRONMENT_HEIGHT);
        this.setLayout(null);
        this.setBackground(null);
        this.setDoubleBuffered(true);
        cells.push(cell);
        new Thread(()->{
            while (true){
                System.out.println(cells.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        for (int i = 0; i < areas.getAreas().length; i++) {
//            this.add(areas.getAreas()[i]);
//        }
    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        areas.paint(graphics);
        cellsActions(graphics);

    }
    public void cellsActions(Graphics graphics){
        areas.paint(graphics);
        for (Cell cell:cells){
            cell.paint(graphics);
            counter--;
        }
        int size=cells.size();
        for (int i = 0; i < size; i++) {
            if(cells.size()<maxCells){
                if(counter<=0){
                    counter=counterCount;
                    duplicate(cells.get(i));
                }else break;}else break;{
            }
        }
        move();
    }
    public void duplicate(Cell cell){
        if(cell.duplicate){
            cells.push(cell.duplicate());
        }
        cells.push(cell.duplicate());
    }
    public void move(){
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Cell cell:cells) {
            if(cell.duplicate){
            }
            cell.move();
        }
        int size=cells.size();
        for (int i = 0; i < size; i++) {
            if(cells.get(i).isDead()){
                cells.remove(cells.get(i));
                i--;
                size--;
            }
        }
//        counterToReset--;
//        if(counterToReset==0){
//            counterToReset=NUMBER_COUNTER_TO_RESET;
//            resetLocations();
//        }
        repaint();
    }
    public void resetLocations(){
        for (Cell cell:cells) {
            cell.reset();
        }
    }
}
