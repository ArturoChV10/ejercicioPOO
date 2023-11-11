package paintersPackage;

import java.awt.*;
import java.util.List;

import pantallaPackage.PantallaLienzo;

public class OPainter implements Painter {

    private boolean filled;
    private Color currentColor;

    public OPainter() {
        this.filled = Math.random() < 0.5;
        this.currentColor = Color.BLUE;
    }
    
    public Color getCurrentColor() {
        return currentColor; // Define el color actual del polígono
    }

    @Override
    public void paint(Graphics2D g2d, List<int[]> xPointsList, List<int[]> yPointsList, List<Float> grosorList) {
        for (int i = 0; i < xPointsList.size(); i++) {
            int[] xPoints = xPointsList.get(i);
            int[] yPoints = yPointsList.get(i);
            float grosor = grosorList.get(i);

            g2d.setStroke(new BasicStroke(grosor));

            // Actualiza el color según las reglas
            updateColor();

            // Configura el color actual
            g2d.setColor(currentColor);

            if (filled) {
                g2d.fillOval(xPoints[0], yPoints[0], xPoints[1] - xPoints[0], yPoints[1] - yPoints[0]);
            } else {
                g2d.drawOval(xPoints[0], yPoints[0], xPoints[1] - xPoints[0], yPoints[1] - yPoints[0]);
            }
        }
    }

    @Override
    public void generateRandom(List<int[]> xPointsList, List<int[]> yPointsList, List<Float> grosorList, int maxWidth, int maxHeight) {
        int[] xPoints = new int[2];
        int[] yPoints = new int[2];
        float grosor = (float) (Math.random() * 5);

        int ovalWidth = (int) (Math.random() * maxWidth / 2);
        int ovalHeight = (int) (Math.random() * maxHeight / 2);

        xPoints[0] = (int) (Math.random() * (maxWidth - ovalWidth));
        yPoints[0] = (int) (Math.random() * (maxHeight - ovalHeight));
        xPoints[1] = xPoints[0] + ovalWidth;
        yPoints[1] = yPoints[0] + ovalHeight;

        // Actualiza el color según las reglas antes de agregar a la lista
        updateColor();

        xPointsList.add(xPoints);
        yPointsList.add(yPoints);
        grosorList.add(grosor);
    }

    private void updateColor() {
    	PantallaLienzo pantalla = PantallaLienzo.getInstance();
        if (pantalla.getCurrentColorR() == Color.RED) {
            currentColor = Color.RED;
        } else if (pantalla.getCurrentColorR() == Color.YELLOW) {
            currentColor = Color.BLUE;
        }
    }
}

