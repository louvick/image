import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();
        String chemin2= "image1.ppm";
        String chemin = "image1.pgm";
        imagecouleur.lire(chemin2);
        imagecouleur.pivoter90();
        imagecouleur.ecrire("image1.ppm",);
        imagegrise.lire(chemin);
    }
}