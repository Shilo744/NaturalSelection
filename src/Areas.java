import java.awt.*;

public class Areas{
    private int numOfAreas;
    private Color[]colors;
    private int x;

    Areas(){
        colorfulRandom();
    }
    private void colorfulRandom(){
        numOfAreas=(int)(Math.random()*6)+2;
        colors=new Color[numOfAreas];
        for (int i = 0; i < colors.length; i++) {
            colors[i]=Cell.randomColor();
        }
    }
    public void paint(Graphics graphics) {
        x=0;
        int distanceBetweenAreas=Window.WINDOW_WIDTH/numOfAreas;
        for (int i = 0; i <numOfAreas; i++) {
            graphics.setColor(colors[i]);
            graphics.fillRect(x, 0, distanceBetweenAreas, Window.WINDOW_HEIGHT);
            x+=distanceBetweenAreas;
        }

    }
}
