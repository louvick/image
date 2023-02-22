/**
 *
 * Cette classe gère un pixel de type PGM (donc une valeur par pixel)
 *
 * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
 * @Date 20 février 2023
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
     * @Date 20 février 2023
     * @param pixel
     * @return void
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
     * @Date 20 février 2023
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
     * @Date 20 février 2023
     * @param pixel
     * @return int
     *
     */
    public void setPixel(int pixel){
        this.pixel = pixel;
    }
}
