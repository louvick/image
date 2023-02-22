import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * Cette classe agit comme une extension de la classe mère Image
 * Elle va gérer les images de type PPM (donc les images avec des pixels rgb)
 *
 * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
 *
 */
public class ImagePPM extends Image
{
    private PixelPPM tbl_pixels[][];

    /**
     * constructeur par défaut
     * @return PixelPPM[][] retourne un tableau de pixel
     */
    public PixelPPM[][] getPixels() {
        return this.tbl_pixels;
    }

    /**
     *
     * This method creates an empty image of PPM type
     *
     * @param sizeY valeur de la grandeur de y
     * @param sizeX valeur de la grandeur de x
     * @param max valeur du maximum
     *
     */
    public void create(int sizeX, int sizeY, int max) {
        super.setSizeX(sizeX);
        super.setSizeY(sizeY);
        super.setMax(max);
        this.tbl_pixels = new PixelPPM[sizeX + 1][sizeY+1];
        super.setType("P3");
    }

    /**
     *
     * Cette méthode va chercher un pixel précis sur l'image selon des coordonnées
     *
     * @param x variable des x
     * @param y variable des y
     * @return PixelPPM
     *
     */
    public PixelPPM getPixelAt(int x, int y) {
        return tbl_pixels[x][y];
    }

    /**
     *
     * Cette méthode va mettre une valeur précise à un certain point sur l'image
     *
     * @param x variable des x
     * @param y variable des y
     * @param red variable de la valeur du rouge
     * @param green variable de la valeur du vert
     * @param blue variable de la valeur du bleur
     *
     */
    public void setPixelAt(int x, int y, int red, int green, int blue) {
        tbl_pixels[x][y].setColor(red,green,blue);
    }

    /**
     *
     * Cette méthode va mettre une valeur précise à un certain point sur l'image
     *
     * @param image passe une image
     *
     */
    public void setPixels(ImagePPM image) {
        this.tbl_pixels = image.getPixels().clone();
    }
    public void setPixels() {
        for (int i = 0; i < super.getSizeY(); i++) {
            for (int j = 0; j < super.getSizeX(); j++) {
                this.tbl_pixels[j][i] = new PixelPPM();
            }
        }
    }
    /**
     *
     * Cette méthode va pivoter l'image de 90 degrées
     *
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
     * @param fichier passe une fichier
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
     * Cette méthode va ouvrir un fichier et écrire 
     *
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
     **/
     public void reduire() {
        int newWidth = this.getSizeX() / 2;
        int newHeight = this.getSizeY() / 2;
        ImagePPM newImage = new ImagePPM();

        newImage.create(newWidth, newHeight, super.getMax());
        newImage.setPixels();

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

        this.create(newWidth, newHeight, 255);
        this.tbl_pixels = newImage.getPixels().clone();
    }

    /**
     *
     * Cette méthode va chercher une image à partir de deux points sur l'image
     *
     * @param x1 variable x du coin à gauche
     * @param x2 variable x du coin à droite
     * @param y1 variable y du coin à gauche
     * @param y2 variable y du coin à droite
     *
     */
    public void extraire(int x1, int y1, int x2, int y2) {
        ImagePPM newImage = new ImagePPM();
        int newWidth = x2-x1;
        int newHeight = y2-y1;

        newImage.create(newWidth,newHeight,255);
        newImage.setPixels();

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                newImage.setPixelAt(j,i,this.getPixelAt(x1+j,y1+i).getRed(),this.getPixelAt(x1+j,y1+i).getGreen(),this.getPixelAt(x1+j,y1+i).getBlue());
            }
        }

        this.create(newWidth,newHeight,super.getMax());

        this.tbl_pixels = newImage.getPixels().clone();

    }

    /**
     *
     * Cette méthode va éclaircir ou noircir la valeur selon la valeur en paramètre. Une valeur négative va éclaricir l'image, alors qu'une valeur positive va noircir l'image
     *
     * @param valeur valeur a ajouter
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
     * @param image1 passe une image
     * @return boolean
     *
     */
    public boolean sont_identiques(ImagePPM image1){

        boolean ver = false;
        if(image1.getType().equals(this.getType()) && image1.getSizeY() == this.getSizeY() && image1.getSizeX() == this.getSizeX() && image1.getMax() == this.getMax()){
            for(int i = 0; i < image1.getSizeY(); i++){
                for(int j = 0; j < image1.getSizeX(); j++){
                    if(image1.getPixels()[j][i].getRed() == this.getPixels()[j][i].getRed() &&
                            image1.getPixels()[j][i].getGreen() == this.getPixels()[j][i].getGreen() &&
                            image1.getPixels()[j][i].getBlue() == this.getPixels()[j][i].getBlue()){
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

    /**
     * permet de sortir la couleur qui revient le plus souvant
     * @return String
     */

    public String couleur_preponderante() {

        HashMap<String, String> listOccuPixels = new HashMap<String, String>();

        for (int i = 0; i < this.getSizeX(); i++) {
            for (int j = 0; j < this.getSizeY(); j++) {
                if(listOccuPixels.containsKey(Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue()))) {
                    listOccuPixels.put(Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue()),Integer.toString(Integer.parseInt(listOccuPixels.get(Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue())))+1));
                } else {
                    listOccuPixels.put(Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue()),"1");
                }
            }
        }
        int min =0;
        String min2="";
        for (int i = 0; i < this.getSizeX(); i++) {
            for (int j = 0; j < this.getSizeY(); j++) {
                if(Integer.parseInt(listOccuPixels.get(Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue())))>=min) {
                    min=Integer.parseInt(listOccuPixels.get(Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue())));
                    min2=Integer.toString(tbl_pixels[i][j].getRed())+" "+Integer.toString(tbl_pixels[i][j].getGreen())+" "+Integer.toString(tbl_pixels[i][j].getBlue());
                }
            }
        }
        return min2;

    }


}