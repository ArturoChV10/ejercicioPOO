package pantallaPackage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import paintersPackage.*;
import paintersPackage.Painter;

public class PantallaLienzo {

    // Atributos para el color actual de cada tipo de pintor
    private Color currentColorO = Color.BLUE;
    private Color currentColorP = Color.RED;
    private Color currentColorR = Color.RED;

    // Instancia única de PantallaLienzo (Singleton)
    private static final PantallaLienzo instance = new PantallaLienzo();

    // Método para obtener la instancia única
    public static PantallaLienzo getInstance() {
        return instance;
    }
    
    public static void main(String[] args) {
        PantallaLienzo pantalla = new PantallaLienzo();
        pantalla.currentColorO = Color.red;
        pantalla.start();
    }

    private void start() {
        List<Painter> painters = new ArrayList<>();
        painters.add(new PPainter());
        painters.add(new RPainter());
        painters.add(new OPainter());

        List<List<int[]>> xPointsLists = new ArrayList<>();
        List<List<int[]>> yPointsLists = new ArrayList<>();
        List<List<Float>> grosorLists = new ArrayList<>();

        for (int i = 0; i < painters.size(); i++) {
            xPointsLists.add(new ArrayList<>());
            yPointsLists.add(new ArrayList<>());
            grosorLists.add(new ArrayList<>());
        }

        int maxWidth = 800;
        int maxHeight = 600;

        JFrame frame = new JFrame();
        frame.setSize(maxWidth, maxHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(Color.BLACK);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Pintar todos los pintores (línea, polígono y óvalo)
                for (int i = 0; i < painters.size(); i++) {
                    Painter painter = painters.get(i);
                    painter.paint(g2d, xPointsLists.get(i), yPointsLists.get(i), grosorLists.get(i));

                    // Actualizar los colores actuales después de pintar cada figura
                    if (painter instanceof OPainter) {
                        currentColorO = ((OPainter) painter).getCurrentColor();
                    } else if (painter instanceof PPainter) {
                        currentColorP = ((PPainter) painter).getCurrentColor();
                    } else if (painter instanceof RPainter) {
                        currentColorR = ((RPainter) painter).getCurrentColor();
                    }
                }
            }
        };

        frame.add(panel);
        frame.setVisible(true);

        Timer timer = new Timer(3000, e -> {
            Graphics2D g2d = (Graphics2D) panel.getGraphics();
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());

            // Generar la figura con el pintor actual
            for (int i = 0; i < painters.size(); i++) {
                Painter painter = painters.get(i);
                painter.generateRandom(xPointsLists.get(i), yPointsLists.get(i), grosorLists.get(i), maxWidth, maxHeight);
            }

            panel.repaint();
        });

        timer.start();
    }

    public Color getCurrentColorO() {
        return currentColorO;
    }

    public Color getCurrentColorP() {
        return currentColorP;
    }

    public Color getCurrentColorR() {
        return currentColorR;
    }
}
