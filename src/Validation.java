/**
 *
 * Cette classe gère les exceptions des images
 * @author Antoine plouffe, Louvick D'Arcy, Jean-François Labbé
 */

public class Validation {

    /**
     *
     * Cette méthode valide la position d'un pixel. S'il est en dehors de l'image, il lance le message d'erreur
     *
     * @param x
     * @param y
     * @param maxy
     * @param maxx
     * @throws ExceptionValeurHorsRange
     */
    void validePositionImage(int x, int y, int maxy, int maxx) throws ExceptionValeurHorsRange{

        if(x < 0 && x > maxx && y < 0 && y > maxy){

            throw new ExceptionValeurHorsRange("La valeur est hors range");
        }
    }
}
