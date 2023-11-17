import java.awt.image.BufferedImage;

public class VerticalFlipEdit implements EditingStrategy {

    @Override
    public BufferedImage applyEditing(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();

        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int originalRGB = image.getRGB(x, y);

                int inverseY = height - y - 1;
                flippedImage.setRGB(x, inverseY, originalRGB);
            }
        }

        return flippedImage;
    }
}
