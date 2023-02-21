import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * Cette classe agit comme une extension de la classe mère Image
 * Elle va gérer les images de type PGM (donc les images avec des pixels à une seule valeur)
 *
 * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
 * @Date 20 février 2023
 *
 */
public class ImagePGM extends Image{
    private PixelPGM tbl_pixels[][];

    /**
     *
     * Cette méthode retourne un tableau avec tous les pixels d'une image
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param tbl_pixels
     * @return PixelPGM[][]
     *
     */
    public PixelPGM[][] getPixels() {
        return this.tbl_pixels;
    }

    /**
     *
     * Cette méthode set dans une image, tous les pixels à partir d'un tableau de pixels
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param tbl_pixels
     * @return void
     *
     */
    public void setPixels(ImagePGM image) {
        this.tbl_pixels = image.getPixels().clone();
    }

    /**
     *
     * Cette méthode créer une image de type PGM
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param sizeY
     * @param sizeX
     * @param max
     * @return void
     *
     */
    public void create(int sizeX, int sizeY, int max) {
        super.setSizeX(sizeX);
        super.setSizeY(sizeY);
        super.setMax(max);
        super.setType("P2");
    }

    /**
     *
     * Cette méthode set un la valeur d'un pixel déterminer en x et en y à partir d'un tableau de pixels
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param x
     * @param y
     * @param value
     * @return void
     *
     */
    public void setPixelAt(int x, int y, int value) {
        tbl_pixels[y][x].setPixel(value);
    }

    /**
     *
     * Cette méthode retourne la valeur d'un pixel déterminer en x et en y à partir d'un tableau de pixels
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param x
     * @param y
     * @return int
     *
     */
    public int getPixelAt(int x, int y) {
        return tbl_pixels[y][x].getPixel();
    }

    /**
     *
     * Cette méthode permet de lire une image dans un fichier
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param fichier
     * @return void
     *
     */
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


    /**
     *
     * Cette méthode permet d'écrire dans un fichier
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param fichier
     * @exception FileNotFoundException
     * @return void
     *
     */
    public void ecrire(String fichier) throws FileNotFoundException {

        PrintWriter wr = new PrintWriter(fichier);

        //try{

        PixelPGM tbl[][] = this.getPixels();

        wr.println(this.getType());
        wr.print(this.getSizeX());
        wr.print(" ");
        wr.println(this.getSizeY());
        wr.println(this.getMax());

        for(int i = 0; i < this.getSizeY(); i++){

            for(int j = 0; j < this.getSizeX(); j++){

                wr.print(tbl[j][i].getPixel());
                wr.print(" ");
            }
        }
        //} catch (java.io.FileNotFoundException exception) {
        //    System.out.println(exception.getMessage());
        //}

        wr.close();
    }

    /**
     *
     * Cette méthode permet de pivoter une image à 90 degré
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @return void
     *
     */
    public void pivoter90() {
        PixelPGM[][] rotatedPixels = new PixelPGM[super.getSizeY()][super.getSizeX()];

        for (int i = 0; i < super.getSizeY(); i++) {
            for (int j = 0; j < super.getSizeX(); j++) {
                rotatedPixels[i][j] = tbl_pixels[super.getSizeX()-j-1][i];
            }
        }
        this.create(super.getSizeY(),super.getSizeX(),255);
        this.tbl_pixels = rotatedPixels.clone();

    }

    /**
     *
     * Cette méthode permet de réduire une image par deux
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param image
     * @return ImagePGM
     *
     */
    public ImagePGM reduire(ImagePGM image) {
        int newWidth = this.getSizeX() / 2;
        int newHeight = this.getSizeY() / 2;
        ImagePGM newImage = new ImagePGM();
        newImage.create(newWidth, newHeight, super.getMax());

        for (int y = 0; y < newHeight; y++) {
            for (int x = 0; x < newWidth; x++) {
                int sum = 0;
                for (int j = y * 2; j < (y + 1) * 2; j++) {
                    for (int i = x * 2; i < (x + 1) * 2; i++) {
                        sum += tbl_pixels[i][j].getPixel();
                    }
                }
                int average = sum / 4;
                newImage.setPixelAt(x,y,average);
            }
        }
        return newImage;
    }

    /**
     *
     * Cette méthode permet d'extraire une partie de l'image et d'en faire une autre avec celle-ci
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return void
     *
     */
    public void extraire(int x1, int y1, int x2, int y2) {
        ImagePGM newImage = new ImagePGM();
        int newWidth = x2-x1;
        int newHeight = y2-y1;

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                newImage.setPixelAt(i,j,this.getPixelAt(y1+i,x1+j));
            }
        }

        newImage.create(newWidth,newHeight,this.getMax());
        this.tbl_pixels = newImage.getPixels().clone();

    }


    /**
     *
     * Cette méthode permet d'éclaircir ou de noircir une image à partir d'une valeur
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param valeur
     * @return void
     *
     */
    public void eclaircir_noircir(int valeur){

        for(int i = 0; i < this.getSizeY(); i++){
            for(int j = 0; j < this.getSizeX(); j++){
                if(tbl_pixels[j][i].getPixel() + valeur>=0&&tbl_pixels[j][i].getPixel() + valeur<=super.getMax()) {
                    this.tbl_pixels[j][i].setPixel(tbl_pixels[j][i].getPixel() + valeur);
                }
                else if(tbl_pixels[j][i].getPixel() + valeur<=0){
                    this.tbl_pixels[j][i].setPixel(0);
                }
                else if(tbl_pixels[j][i].getPixel() + valeur>=super.getMax()) {
                    this.tbl_pixels[j][i].setPixel(super.getMax());
                }
            }
        }
    }


    /**
     *
     * Cette méthode permet de vérifier si deux images sont identiques ou différentes
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param image1
     * @return boolean
     *
     */
    public boolean sont_identiques(ImagePGM image1){
        if(image1.getType().equals(this.getType()) && image1.getSizeX() == this.getSizeX() && image1.getMax() == this.getMax()){
            for(int i = 0; i < image1.getSizeY(); i++){
                for(int j = 0; j < image1.getSizeX(); j++){
                    if(image1.getPixels()[j][i].getPixel() != this.getPixels()[j][i].getPixel()){
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }

        return true;
    }

}

