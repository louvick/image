import java.io.FileReader;
import java.util.Scanner;

public class ImagePGM extends Image{
    private PixelPGM tbl_pixels[][];

    public PixelPGM[][] getPixels() {
        return this.tbl_pixels;
    }

    public void setPixels() {

    }

    public void lire(String fichier) {
        try {
            FileReader lecture = new FileReader(fichier);
            Scanner sc = new Scanner(lecture);

            sc.useDelimiter(" ");
            super.setSizeX(sc.nextInt());
            super.setSizeY(sc.nextInt());
            super.setMax(sc.nextInt());

            this.tbl_pixels = new PixelPGM[super.getSizeX() + 1][super.getSizeY() + 1];

            for (int i = 0; i < Math.floor(super.getSizeY()); i++) {
                for (int j = 0; i < Math.floor(super.getSizeX()); i++) {
                    this.tbl_pixels[i][j] = new PixelPGM(sc.nextInt());
                }
            }
        } catch (java.io.FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

