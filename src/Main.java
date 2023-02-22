import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        String chemin = "image1.pgm";
        String chemin3 = "sadsadsadd.pgm";
        String chemin2 = "image1.ppm";
        String cheminextraire = "extraire.pgm";
        String cheminextraire2 = "extraire.ppm";


        ImageManager im = new ImageManager();


        ImagePGM imagegrise = new ImagePGM();
        ImagePGM imagegrise2 = new ImagePGM();

        ImagePPM imagecouleur = new ImagePPM();
        ImagePPM imagecouleur2 = new ImagePPM();

        im.lire(imagegrise,chemin);
        imagegrise.extraire(0,0,10,10);
        im.ecrire(cheminextraire, imagegrise);

        im.lire(imagecouleur, chemin2);
        imagecouleur.reduire();
        im.ecrire(cheminextraire2, imagecouleur);
/*
        im.lire(imagegrise,chemin);
        im.lire(imagegrise2,chemin);
        im.lire(imagecouleur,chemin2);
        im.lire(imagecouleur2,chemin2);

        if(im.sont_identiques(imagecouleur2,imagegrise)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

        im.ecrire("sadsadsadd.ppm",imagecouleur);
        im.ecrire("sadsadsadd.pgm",imagegrise);

*/


    }
}