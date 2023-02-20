import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();
        String chemin2= "fuckyou.ppm";
        String chemin = "fuckyou.pgm";
        imagecouleur.lire(chemin2);
        imagegrise.lire(chemin);
    }
}