import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * Cette classe agit comme une extension de la classe mère Image
 * Elle va gérer les images de type PPM (donc les images avec des pixels rgb)
 *
 * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
 * @Date 20 février 2023
 *
 */
public class ImagePPM extends Image
{
    private PixelPPM tbl_pixels[][];
    public PixelPPM[][] getPixels() {
        return this.tbl_pixels;
    }

    /**
     *
     * This method creates an empty image of PPM type
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
        super.setType("P3");
    }

    /**
     *
     * Cette méthode va chercher un pixel précis sur l'image selon des coordonnées
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param x
     * @param y
     * return PixelPPM
     *
     */
    public PixelPPM getPixelAt(int x, int y) {
        return tbl_pixels[y][x];
    }

    /**
     *
     * Cette méthode va mettre une valeur précise à un certain point sur l'image
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param x
     * @param y
     * @param red
     * @param green
     * @param blue
     * @return void
     *
     */
    public void setPixelAt(int x, int y, int red, int green, int blue) {
        tbl_pixels[y][x].setColor(red,green,blue);
    }

    /**
     *
     * Cette méthode va mettre une valeur précise à un certain point sur l'image
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param image
     * @return void
     *
     */
    public void setPixels(ImagePPM image) {
        this.tbl_pixels = image.getPixels().clone();
    }

    /**
     *
     * Cette méthode va pivoter l'image de 90 degrées
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param
     * @return void
     *
     */
    public void pivoter90() {
        PixelPPM[][] rotatedPixels = new PixelPPM[super.getSizeY()][super.getSizeX()];

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
     * Cette méthode va ouvrir un fichier selon le nom mis en paramètre et l'insérer dans une image du même type
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

    /**
     *
     * Cette méthode va ouvrir un fichier et écrire les valeurs de l'image ainsi que les valeurs des pixels
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février
     * @param fichier
     * @return void
     *
     */
    public void ecrire(String fichier) throws FileNotFoundException {

        PrintWriter wr = new PrintWriter(fichier);

        PixelPPM tbl[][] = this.getPixels();

        wr.println(this.getType());
        wr.print(this.getSizeX());
        wr.print(" ");
        wr.println(this.getSizeY());
        wr.println(this.getMax());

        for(int i = 0; i < this.getSizeY(); i++){

            for(int j = 0; j < this.getSizeX(); j++){
                wr.print(tbl[j][i].getRed());
                wr.print(" ");
                wr.print(tbl[j][i].getGreen());
                wr.print(" ");
                wr.print(tbl[j][i].getBlue());
                wr.print(" ");
            }
        }

        wr.close();
    }

    /**
     *
     * Cette méthode va réduire l'image originale, Elle va prendre la valeur de quatre pixel, calculer la moyenne de celles-ci
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février
     * @param image
     * @return ImagePPM
     **/
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

    /**
     *
     * Cette méthode va chercher une image à partir de deux points sur l'image
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février
     * @param image
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return ImagePPM
     *
     */
    public ImagePPM extraire(ImagePPM image, int x1, int y1, int x2, int y2) {
        ImagePPM newImage = new ImagePPM();
        int newWidth = x2-x1;
        int newHeight = y2-y1;

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                newImage.setPixelAt(i,j,image.getPixelAt(y1+i,x1+j).getRed(),image.getPixelAt(y1+i,x1+j).getGreen(),image.getPixelAt(y1+i,x1+j).getBlue());
            }
        }

        newImage.create(newWidth,newHeight,image.getMax());

        return newImage;
    }

    /**
     *
     * Cette méthode va éclaircir ou noircir la valeur selon la valeur en paramètre. Une valeur négative va éclaricir l'image, alors qu'une valeur positive va noircir l'image
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février
     * @param valeur
     * @return void
     *
     */
    public void eclaircir_noircir(int valeur){
        for(int i = 0; i < this.getSizeY(); i++){

            for(int j = 0; j < this.getSizeX(); j++){

                if(this.getPixels()[j][i].getRed()+valeur>=0&&this.getPixels()[j][i].getRed()+valeur<=super.getMax()){
                    this.getPixels()[j][i].setRed(this.getPixels()[j][i].getRed() +valeur);
                }
                else if(this.getPixels()[j][i].getRed()+valeur>=0) {
                    this.getPixels()[j][i].setRed(0);
                }
                else if(this.getPixels()[j][i].getRed()+valeur>=super.getMax()) {
                    this.getPixels()[j][i].setRed(super.getMax());
                }

                if(this.getPixels()[j][i].getGreen()+valeur>=0&&this.getPixels()[j][i].getGreen()+valeur<=super.getMax()){
                    this.getPixels()[j][i].setGreen(this.getPixels()[j][i].getGreen() +valeur);
                }
                else if(this.getPixels()[j][i].getGreen()+valeur>=0) {
                    this.getPixels()[j][i].setGreen(0);
                }
                else if(this.getPixels()[j][i].getGreen()+valeur>=super.getMax()) {
                    this.getPixels()[j][i].setGreen(super.getMax());
                }

                if(this.getPixels()[j][i].getBlue()+valeur>=0&&this.getPixels()[j][i].getBlue()+valeur<=super.getMax()){
                    this.getPixels()[j][i].setBlue(this.getPixels()[j][i].getBlue() +valeur);
                }
                else if(this.getPixels()[j][i].getBlue()+valeur>=0) {
                    this.getPixels()[j][i].setBlue(0);
                }
                else if(this.getPixels()[j][i].getBlue()+valeur>=super.getMax()) {
                    this.getPixels()[j][i].setBlue(super.getMax());
                }

            }
        }
    }

    /**
     *
     * Cette méthode va comparer les valeurs de deux images en paramètre. Si elles sont identiques, le retour est true, sinon, elle est fausse
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février
     * @param image1
     * @return boolean
     *
     */
    public boolean sont_identiques(ImagePPM image1){

        boolean ver = false;

        if(image1.getType() == this.getType() && image1.getSizeY() == this.getSizeY() && image1.getSizeX() == this.getSizeX() && image1.getMax() == this.getMax()){

            for(int i = 0; i < image1.getSizeY(); i++){

                for(int j = 0; j < image1.getSizeY(); j++){

                    if(image1.getPixels()[i][j].getRed() == this.getPixels()[i][j].getRed() &&
                            image1.getPixels()[i][j].getGreen() == this.getPixels()[i][j].getGreen() &&
                            image1.getPixels()[i][j].getBlue() == this.getPixels()[i][j].getBlue()){
                        ver = true;
                    }
                    else{
                        return false;
                    }

                }
            }
        }
        else{
            return false;
        }

        return ver;
    }


}