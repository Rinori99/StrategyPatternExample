import java.util.Scanner;

public class PhotoEditingApp {

    private final static String DEFAULT_IMAGE_PATH = "./pictures/dog-image.jpeg";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the absolute path of the Photo you want to edit, or only press Enter to take the default picture: ");
        String imagePath = scanner.nextLine();

        if (imagePath == null || imagePath.isBlank()) {
            imagePath = DEFAULT_IMAGE_PATH;
        }

        System.out.println("Press 1 for Black&White or press 2 for Vertical Flip: ");
        String editingOption = scanner.nextLine();

        if (editingOption.equals("1")) {
            Editor.editPhoto(imagePath, new BlackAndWhiteEdit());
        } else if (editingOption.equals("2")) {
            Editor.editPhoto(imagePath, new VerticalFlipEdit());
        } else {
            System.out.println("Wrong input!");
        }
    }
}