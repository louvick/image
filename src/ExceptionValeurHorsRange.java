/**
 *
 * Cette gère si le programme essaye de chercher un pixel qui n'est pas dans les dimensions de l'image
 * @author Antoine Plouffe
 * @date 20 février 2023
 *
 */

public class ExceptionValeurHorsRange extends Exception{

    /**
     *
     * @Author Antoine Plouffe
     * @date 20 février 2023
     * @param messageErreur
     * No return
     */
    public ExceptionValeurHorsRange(String messageErreur){

        super(messageErreur);
    }
}
