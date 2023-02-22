public class Validation {

    void validePositionImage(int x, int y, int maxy, int maxx) throws ExceptionValeurHorsRange{

        if(x < 0 && x > maxx && y < 0 && y > maxy){

            throw new ExceptionValeurHorsRange("La valeur est hors range");
        }
    }
}
