import java.awt.image.BufferedImage;

public interface EditingStrategy {

    public BufferedImage applyEditing(BufferedImage image);
}
