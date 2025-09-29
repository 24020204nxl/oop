import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomWalk extends JPanel {
    private int n;
    private int x, y;
    private int steps;
    private int scale = 20;
    private Random rand = new Random();

    public RandomWalk(int n) {
        this.n = n;
        this.x = 0;
        this.y = 0;
        this.steps = 0;
        setPreferredSize(new Dimension((2 * n + 1) * scale, (2 * n + 1) * scale));
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        g.setColor(Color.BLUE);
        g.fillRect(cx + x * scale, cy - y * scale, scale, scale);
    }

    public void step() {
        double r = rand.nextDouble();
        if      (r < 0.25) x--;
        else if (r < 0.50) x++;
        else if (r < 0.75) y--;
        else               y++;
        steps++;
    }

    public boolean inBounds() {
        return Math.abs(x) < n && Math.abs(y) < n;
    }

    public int getSteps() {
        return steps;
    }

    public static void main(String[] args) throws InterruptedException {
        int n;
        if (args.length == 0) {
            n = 20;
            System.out.println("Không có tham số, mặc định n = 20");
        } else {
            n = Integer.parseInt(args[0]);
        }

        JFrame frame = new JFrame("Random Walk");
        RandomWalk walk = new RandomWalk(n);
        frame.add(walk);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (walk.inBounds()) {
            walk.step();
            walk.repaint();
            Thread.sleep(100);
        }

        System.out.println("Total steps = " + walk.getSteps());
    }
}
