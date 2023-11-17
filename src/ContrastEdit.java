import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class ContrastEdit implements EditingStrategy {

    @Override
    public BufferedImage applyEditing(BufferedImage image) {
        float scaleFactor = 1.7f; // You can experiment with this value
        float offset = 0.0f;
        RescaleOp rescaleOp = new RescaleOp(scaleFactor, offset, null);

        return rescaleOp.filter(image, null);
    }
}
