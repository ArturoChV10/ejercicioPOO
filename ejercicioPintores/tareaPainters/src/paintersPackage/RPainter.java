
package paintersPackage;

import java.awt.*;
import java.util.List;

import pantallaPackage.PantallaLienzo;

public class RPainter implements Painter {

    private Color currentColor;

    public RPainter() {
        this.currentColor = Color.RED; // Inicializa el color como rojo al principio
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

            g2d.drawLine(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        }
    }

    @Override
    public void generateRandom(List<int[]> xPointsList, List<int[]> yPointsList, List<Float> grosorList, int maxWidth, int maxHeight) {
        int[] xPoints = new int[2];
        int[] yPoints = new int[2];
        float grosor = (float) (Math.random() * 5);

        for (int i = 0; i < 2; i++) {
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
        if (pantalla.getCurrentColorP() == Color.RED) {
            currentColor = Color.YELLOW;
        } else if (pantalla.getCurrentColorO() == Color.RED) {
            currentColor = Color.RED;
        }
    }
}
