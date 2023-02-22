/**
 *
 * Cette classe gère un pixel de type PGM (donc une valeur par pixel)
 *
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
     * @param pixel met la valeur du pixel
     *
     */
    public void setPixel(int pixel){

        this.pixel = pixel;
    }
}
