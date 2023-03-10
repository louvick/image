/**
 *
 * Cette classe gère un pixel de type PPM (donc trois valeur par pixel, soit rouge, vert et bleu)
 *
 *
 */
public class PixelPPM {

    private int red;
    private int green;
    private int blue;

    /**
     *
     * Cette méthode est un constructeur d'un pixel avec ses trois valeurs
     *
     * @param red valeur pixel rouge
     * @param green valeur pixel vert
     * @param blue valeur pixel bleu
     *
     */
    public PixelPPM(int red,int green,int blue) {
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    /**
     * permet de construire le pixel avec rien comme paramètre
     */
    public PixelPPM() {
        this.red=0;
        this.green=0;
        this.blue=0;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur rouge d'un objet pixel
     *
     * @return int
     *
     */
    public int getRed() {
        return red;
    }

    /**
     *
     * Cette méthode permet de donner une valeur rouge à un pixel
     *
     * @param red valeur pixel rouge
     *
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur verte d'un objet pixel
     *
     * @return int
     *
     */
    public int getGreen() {
        return green;
    }

    /**
     *
     * Cette méthode permet de donner une valeur verte à un pixel
     *
     * @param green valeur pixel vert
     *
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur bleue d'un objet pixel
     *
     * @return int
     *
     */
    public int getBlue() {
        return blue;
    }

    /**
     *
     * Cette méthode permet de donner une valeur bleue à un pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @param blue valeur pixel bleu
     *
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     *
     * Cette méthode permet de donner trois valeurs, soit rouge vert et bleu à un pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @param red valeur pixel rouge
     * @param green valeur pixel vert
     * @param blue valeur pixel bleu
     *
     */
    public void setColor(int red, int green, int blue){
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
}
