import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BubbleSortVisualization extends JPanel {
    private int[] array;
    private int delay = 40;
    private Image bubbleImage;
    private Image backgroundImage;
    public BubbleSortVisualization(int size) {
        this.array = new int[size];
        generateRandomArray();
        loadImage();
    }
    public void loadImage(){
        ImageIcon bubbleIcon= new ImageIcon("sakura.png");
        bubbleImage=bubbleIcon.getImage();

        ImageIcon backgroundIcon= new ImageIcon("background_theme.png");
        backgroundImage=backgroundIcon.getImage();
    }

    public void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(400) + 20;
        }
    }
    public void bubbleSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    repaint();
                    Thread.sleep(delay);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),this);


        for (int i = 0; i < array.length; i++) {

            g.drawImage(bubbleImage,i * 20, getHeight() - array[i], 20, 20,this);

        }
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Bubble Sort Visualization");
        BubbleSortVisualization visualizer = new BubbleSortVisualization(60);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 400);
        frame.add(visualizer);
        frame.setVisible(true);

        visualizer.bubbleSort();
    }
}
