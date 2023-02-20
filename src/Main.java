import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImageManager im = new ImageManager();
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();
        String chemin2= "image1.ppm";
        String chemin = "image1.pgm";
        //imagecouleur.lire(chemin2);
        imagegrise.lire(chemin);
        //imagecouleur.pivoter90();
        //im.ecrire("output.ppm",imagecouleur);
        im.ecrire("outputpgm.pgm",imagegrise);

    }
}