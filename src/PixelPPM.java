/**
 *
 * Cette classe gère un pixel de type PPM (donc trois valeur par pixel, soit rouge, vert et bleu)
 *
 * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
 * @Date 20 février 2023
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
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param red
     * @param green
     * @param blue
     * @return void
     *
     */
    public PixelPPM(int red,int green,int blue) {
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    public PixelPPM() {
        this.red=0;
        this.green=0;
        this.blue=0;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur rouge d'un objet pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
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
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param red
     * @return int
     *
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur verte d'un objet pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
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
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
     * @param green
     * @return int
     *
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     *
     * Cette méthode permet d'avoir la valeur bleue d'un objet pixel
     *
     * @author Antoine Plouffe, Louvick D'Arcy, Jean-François Labbé
     * @Date 20 février 2023
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
     * @Date 20 février 2023
     * @param blue
     * @return int
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
     * @Date 20 février 2023
     * @param red
     * @param green
     * @param blue
     *
     */
    public void setColor(int red, int green, int blue){
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
}
