import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String chemin = "image1.pgm";
        String chemin3 = "sadsadsadd.pgm";
        String chemin2 = "image1.ppm";

        ImageManager im = new ImageManager();

        ImagePGM imagegrise = new ImagePGM();
        ImagePGM imagegrise2 = new ImagePGM();

        ImagePPM imagecouleur = new ImagePPM();
        ImagePPM imagecouleur2 = new ImagePPM();

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


    }
}