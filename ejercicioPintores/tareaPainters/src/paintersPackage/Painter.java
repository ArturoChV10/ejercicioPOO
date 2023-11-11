package paintersPackage;

import java.awt.*;
import java.util.List;

public interface Painter {
    void paint(Graphics2D g2d, List<int[]> xPointsList, List<int[]> yPointsList, List<Float> grosorList);
    void generateRandom(List<int[]> xPointsList, List<int[]> yPointsList, List<Float> grosorList, int maxWidth, int maxHeight);
}
