import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PhotoEditingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the absolute path of the Photo you want to edit, or only press Enter to take the default picture: ");
        String imagePath = scanner.nextLine();

        if (imagePath == null || imagePath.isBlank()) {
            imagePath = "./pictures/dog-image.jpeg";
        }

        BufferedImage dogImageEdited = null;
        System.out.println("Press 1 for Black&White or press 2 for Vertical Flip: ");
        String editingOption = scanner.nextLine();

        try {
            File dogImageFile = new File(imagePath);
            BufferedImage dogImage = ImageIO.read(dogImageFile);

            if (editingOption.equals("1")) {
                dogImageEdited = applyBlackAndWhiteFilterToImage(dogImage);
            } else if (editingOption.equals("2")) {
                dogImageEdited = flipImage(dogImage);
            } else {
                System.out.println("Wrong input!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            String editedPhotoFileName = editingOption.equals("1") ? "dog-image-black-and-white" : "dog-image-flipped";

            File outputFile = new File("./edited-pictures/" + editedPhotoFileName + ".png");

            if (dogImageEdited != null) {
                ImageIO.write(dogImageEdited, "png", outputFile);
                String editingType = editingOption.equals("1") ? "Black&White" : "vertical flip";
                System.out.println("Edited the photo to " + editingType + " successfully");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static BufferedImage applyBlackAndWhiteFilterToImage(BufferedImage image) {
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

    private static BufferedImage flipImage(BufferedImage image) {
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