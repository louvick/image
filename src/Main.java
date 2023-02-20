import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String chemin = "image1.pgm";
        ImageManager im = new ImageManager();
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();

        im.lire(imagegrise,chemin);
        im.pivoter90(imagegrise);


        im.ecrire(chemin, imagegrise);

    }
}