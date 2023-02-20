import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImagePGM extends Image{
    private PixelPGM tbl_pixels[][];

    public PixelPGM[][] getPixels() {
        return this.tbl_pixels;
    }

    public void setPixels(ImagePGM image) {
        this.tbl_pixels = image.getPixels().clone();
    }

    public void setPixelAt(int x, int y, int value) {
        tbl_pixels[y][x].setPixel(value);
    }

    public int getPixelAt(int x, int y) {
        return tbl_pixels[y][x].getPixel();
    }

    public void lire(String fichier) {
        try {
            FileReader lecture = new FileReader(fichier);
            Scanner sc = new Scanner(lecture);

            super.setType(sc.nextLine());
            super.setSizeX(sc.nextInt());
            super.setSizeY(sc.nextInt());
            super.setMax(sc.nextInt());

            this.tbl_pixels = new PixelPGM[super.getSizeX() + 1][super.getSizeY() + 1];

            for (int i = 0; i < super.getSizeY(); i++) {
                for (int j = 0; j < super.getSizeX(); j++) {
                    this.tbl_pixels[j][i] = new PixelPGM(sc.nextInt());
                }
            }
        } catch (java.io.FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void ecrire(String fichier, ImagePGM image) throws FileNotFoundException {

        PrintWriter wr = new PrintWriter(fichier);

        //try{

        PixelPGM tbl[][] = image.getPixels();

        wr.println(image.getType());
        wr.print(image.getSizeX());
        wr.print(" ");
        wr.println(image.getSizeY());
        wr.println(image.getMax());

        for(int i = 0; i < image.getSizeX(); i++){

            for(int j = 0; j < image.getSizeY(); j++){

                wr.print(tbl[i][j].getPixel());
            }
        }
        //} catch (java.io.FileNotFoundException exception) {
        //    System.out.println(exception.getMessage());
        //}

        wr.close();
    }

    public void pivoter90() {
        PixelPGM[][] rotatedPixels = new PixelPGM[super.getSizeX()][super.getSizeY()];

        for (int i = 0; i <= super.getSizeY(); i++) {
            for (int j = 0; j <= super.getSizeX(); j++) {
                rotatedPixels[j][super.getSizeY()-i] = tbl_pixels[i][j];
            }
        }
    }
}

