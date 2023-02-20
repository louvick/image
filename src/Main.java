import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImageManager im = new ImageManager();
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();
        String chemin2= "image1.ppm";
        String chemin = "image1.pgm";
        imagecouleur.lire(chemin2);
        //imagecouleur.pivoter90();
        im.ecrire("image1.pgm",imagegrise);

        imagegrise.lire(chemin);
    }
}