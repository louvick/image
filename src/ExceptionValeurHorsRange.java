/**
 *
 * Cette gère si le programme essaye de chercher un pixel qui n'est pas dans les dimensions de l'image
 *
 */

public class ExceptionValeurHorsRange extends Exception{

    /**
     *
     * @param messageErreur passage du message d'erreur
     * No return
     */
    public ExceptionValeurHorsRange(String messageErreur){

        super(messageErreur);
    }
}
