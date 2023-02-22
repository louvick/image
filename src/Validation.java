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
     * @param x valeur de la position en x
     * @param y valeur de la position en y
     * @param maxy valeur maximum en y a ne pas dépasser
     * @param maxx valeur maximum en x a ne pas dépasser
     * @throws ExceptionValeurHorsRange exception de valeur hors range
     */
    void validePositionImage(int x, int y, int maxy, int maxx) throws ExceptionValeurHorsRange{

        if(x < 0 && x > maxx && y < 0 && y > maxy){

            throw new ExceptionValeurHorsRange("La valeur est hors range");
        }
    }
}
