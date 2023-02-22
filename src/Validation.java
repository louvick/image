public class Validation {

    void validePositionImage(int x, int y, int max) throws ExceptionValeurHorsRange{

        if(x < 0 && x > max && y < 0 && y > max){

            throw new ExceptionValeurHorsRange("La valeur est hors range");
        }
    }
}
