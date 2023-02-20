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

    public void create(int sizeX, int sizeY, int max) {
        super.setSizeX(sizeX);
        super.setSizeY(sizeY);
        super.setMax(max);
        super.setType("PPM");
    }

    public int getPixelAt(int x, int y) {
        return tbl_pixels[y][x].getPixel();
    }

    public void setPixelAt(int x, int y, int red, int green, int blue) {
        tbl_pixels[y][x].setColor(red,green,blue);
    }

    public void setPixels(ImagePPM image) {
        this.tbl_pixels = image.getPixels().clone();
    }

    public void pivoter90() {
        PixelPPM[][] rotatedPixels = new PixelPPM[super.getSizeX()][super.getSizeY()];

        for (int i = 0; i < super.getSizeY(); i++) {
            for (int j = 0; j < super.getSizeX(); j++) {
                rotatedPixels[j][super.getSizeY()-i] = tbl_pixels[i][j];
            }
        }
    }

    public void lire(String fichier) {
        try {
            FileReader lecture = new FileReader(fichier);
            Scanner sc = new Scanner(lecture);

            super.setType(sc.nextLine());
            super.setSizeX(sc.nextInt());
            super.setSizeY(sc.nextInt());
            super.setMax(sc.nextInt());

            this.tbl_pixels = new PixelPPM[super.getSizeX() + 1][super.getSizeY() + 1];

            for (int i = 0; i < super.getSizeY(); i++) {
                for (int j = 0; j < super.getSizeX(); j++) {
                    this.tbl_pixels[j][i] = new PixelPPM(sc.nextInt(),sc.nextInt(),sc.nextInt());
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

    public ImagePPM reduire(ImagePPM image) {
        int newWidth = this.getSizeX() / 2;
        int newHeight = this.getSizeY() / 2;
        ImagePPM newImage = new ImagePPM();
        newImage.create(newWidth, newHeight, super.getMax());

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                int sumRed = 0;
                int sumGreen =0;
                int sumBlue=0;
                for (int j = y * 2; j < (y + 1) * 2; j++) {
                    for (int i = x * 2; i < (x + 1) * 2; i++) {
                        sumRed += tbl_pixels[i][j].getRed();
                        sumGreen += tbl_pixels[i][j].getGreen();
                        sumBlue += tbl_pixels[i][j].getBlue();
                    }
                }
                int averageRed = sumRed / 4;
                int averageGreen = sumGreen / 4;
                int averageBlue = sumBlue / 4;
                newImage.setPixelAt(x,y,averageRed,averageGreen,averageBlue);
            }
        }
        return newImage;
    }
}
