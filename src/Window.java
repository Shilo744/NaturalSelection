import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //window parameters
    public static final int WINDOW_WIDTH=1300;
    public static final int WINDOW_HEIGHT=700;
    Window(){
        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Environment environment=new Environment();
        this.add(environment);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Window window=new Window();
    }
}
