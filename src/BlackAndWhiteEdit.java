import java.awt.*;
import java.awt.image.BufferedImage;

public class BlackAndWhiteEdit implements EditingStrategy {

    @Override
    public BufferedImage applyEditing(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();

        BufferedImage blackAndWhiteImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(image.getRGB(x, y));

                // Calculate the grayscale value by averaging the RGB values
                int grayValue = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

                // Create a new Color object with the grayscale value
                Color newColor = new Color(grayValue, grayValue, grayValue);

                // Set the new color to the corresponding pixel in the black and white image
                blackAndWhiteImage.setRGB(x, y, newColor.getRGB());
            }
        }

        return blackAndWhiteImage;
    }
}
