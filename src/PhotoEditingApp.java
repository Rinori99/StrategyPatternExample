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

        System.out.println("Press 1 for Black&White, press 2 for Vertical Flip, or press 3 for increasing Contrast: ");
        String editingOption = scanner.nextLine();

        switch (editingOption) {
            case "1" -> Editor.editPhoto(imagePath, new BlackAndWhiteEdit());
            case "2" -> Editor.editPhoto(imagePath, new VerticalFlipEdit());
            case "3" -> Editor.editPhoto(imagePath, new ContrastEdit());
            default -> System.out.println("Wrong input!");
        }
    }
}