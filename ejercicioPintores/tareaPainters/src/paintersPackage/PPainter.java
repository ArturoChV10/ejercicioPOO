package paintersPackage;

import java.awt.*;
import java.util.List;

import pantallaPackage.PantallaLienzo;

public class PPainter implements Painter {
    private static final int MIN_VERTICES = 3;
    private static final int MAX_VERTICES = 6;

    private Color currentColor;

    public PPainter() {
        this.currentColor = Color.BLUE; // Inicializa el color como azul al principio
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

            g2d.drawPolygon(xPoints, yPoints, xPoints.length);
        }
    }

    @Override
    public void generateRandom(List<int[]> xPointsList, List<int[]> yPointsList, List<Float> grosorList, int maxWidth, int maxHeight) {
        int numVertices = MIN_VERTICES + (int) (Math.random() * (MAX_VERTICES - MIN_VERTICES + 1));
        int[] xPoints = new int[numVertices];
        int[] yPoints = new int[numVertices];
        float grosor = (float) (Math.random() * 5);

        for (int i = 0; i < numVertices; i++) {
            xPoints[i] = (int) (Math.random() * maxWidth);
            yPoints[i] = (int) (Math.random() * maxHeight);
        }

        // Actualiza el color según las reglas antes de agregar a la lista
        updateColor();

        xPointsList.add(xPoints);
        yPointsList.add(yPoints);
        grosorList.add(grosor);
    }

    private void updateColor() {
    	PantallaLienzo pantalla = PantallaLienzo.getInstance();
        if (pantalla.getCurrentColorO() == Color.BLUE) {
            currentColor = Color.GREEN;
        } else if (currentColor == Color.GREEN) {
            currentColor = Color.RED;
        }
    }
}