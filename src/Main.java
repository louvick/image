import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /*
        ImageManager im = new ImageManager();
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();
        String chemin2= "image1.ppm";
        String chemin = "image1.pgm";
        //imagecouleur.lire(chemin2);
        imagegrise.lire(chemin);
        imagegrise.eclaircir_noircir(255);
        //imagecouleur.pivoter90();
        //im.ecrire("output.ppm",imagecouleur);
        im.ecrire("outputpgm.pgm",imagegrise);
*/

        ImageManager im = new ImageManager();
        ImagePGM image1 = new ImagePGM();
        ImagePGM image2 = new ImagePGM();

        String chemin = "image1.pgm";
        image1.lire(chemin);
        image2.lire(chemin);

        if(im.sont_identiques(image1, image2)){
            System.out.print("go");
        }
        else{
            System.out.print("no");
        }
    }
}