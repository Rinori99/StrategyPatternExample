import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Editor {

    public static void editPhoto(String imagePath, EditingStrategy editingStrategy) {
        BufferedImage dogImageEdited = null;

        try {
            File dogImageFile = new File(imagePath);
            BufferedImage dogImage = ImageIO.read(dogImageFile);

            dogImageEdited = editingStrategy.applyEditing(dogImage);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            File outputFile = new File("./edited-pictures/edited-photo.png");

            if (dogImageEdited != null) {
                ImageIO.write(dogImageEdited, "png", outputFile);
                System.out.println("Photo edited successfully!");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
