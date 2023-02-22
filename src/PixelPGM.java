/**
 *
 * Cette classe gère un pixel de type PGM (donc une valeur par pixel)
 *
 * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
 *
 */
public class PixelPGM {

    private int pixel;

/**
*  Constructeur par défaut avec aucun paramètre
*/
    PixelPGM(){

        this.pixel = 0;
    }

    /**
     *
     * Cette méthode est un constructeur d'un pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @param pixel valeur du pixel
     *
     */
    PixelPGM(int pixel){

        this.pixel = pixel;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur d'un objet pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @return int
     *
     */
    public int getPixel(){

        return this.pixel;
    }

    /**
     *
     * Cette méthode permet de donner une valeur à un pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @param pixel met la valeur du pixel
     *
     */
    public void setPixel(int pixel){

        this.pixel = pixel;
    }
}
