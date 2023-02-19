import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImagePPM extends Image
{
    private PixelPPM tbl_pixels[][];
    public PixelPPM[][] getPixels() {

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

            this.tbl_pixels = new PixelPPM[super.getSizeX() + 1][super.getSizeY() + 1];

            for (int i = 0; i < Math.floor(super.getSizeY()/3); i++) {
                for (int j = 0; i < Math.floor(super.getSizeX()/3); i++) {
                    this.tbl_pixels[i][j] = new PixelPPM(sc.nextInt(),sc.nextInt(),sc.nextInt());
                }
            }
        } catch (java.io.FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void ecrire(String fichier, ImagePPM image) throws FileNotFoundException {

        PrintWriter wr = new PrintWriter(fichier);

        //try{

            PixelPPM tbl[][] = image.getPixels();

            wr.println(image.getType());
            wr.print(image.getSizeX());
            wr.print(" ");
            wr.println(image.getSizeY());
            wr.println(image.getMax());

            for(int i = 0; i < image.getSizeX(); i++){

                for(int j = 0; j < image.getSizeY(); j++){

                    wr.print(tbl[i][j].getRed());
                    wr.print(tbl[i][j].getGreen());
                    wr.print(tbl[i][j].getBlue());
                }
            }
        //} catch (java.io.FileNotFoundException exception) {
        //    System.out.println(exception.getMessage());
        //}

        wr.close();
    }
}
