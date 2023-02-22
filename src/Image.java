import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * Classe mère Image
 * Cette classe gère les priorités d'une image de base sans spécification
 *
 *
 */
public class Image{
    private int sizeX;
    private int sizeY;
    private int max;
    private String type;

    /**
     *
     * Cette méthode permet de récupérer la largeur d'une image
     *
     * @return int
     *
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     *
     * Cette méthode permet de lire un fichier en recevant son nom
     *
     * @param fichier
     *
     */
    public void lire(String fichier){}

    /**
     *
     * Cette méthode permet de donner la largeur d'une image
     *
     * @param sizeX
     *
     */
    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    /**
     *
     * Cette méthode permet de récupérer la hauteur d'une image
     *
     * @Date 20 février 2023
     * @return int
     *
     */
    public int getSizeY() {
        return sizeY;
    }


    /**
     *
     * Cette méthode permet de donner la longueur d'une image
     *
     * @Date 20 février 2023
     * @param sizeY
     * @return void
     *
     */
    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }


    /**
     *
     * Cette méthode permet de récupérer le max d'une image
     *
     * @return int
     *
     */
    public int getMax() {
        return max;
    }


    /**
     *
     * Cette méthode permet de donner le max à une image
     *
     * @param max
     *
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     *
     * Cette méthode permet de récupérer le type d'une image
     *
     * @return String
     *
     */
    public String getType() {
        return type;
    }


    /**
     *
     * Cette méthode permet de donner le type à une image
     *
     * @param type
     *
     */
    public void setType(String type) {
        this.type = type;
    }
}
