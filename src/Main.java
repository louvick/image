import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String chemin = "image1.ppm";
        ImageManager im = new ImageManager();
        ImagePGM imagegrise = new ImagePGM();
        ImagePPM imagecouleur = new ImagePPM();

        im.extraire(imagegrise, 30,30,300,300);

        im.ecrire(chemin, imagegrise);

    }
}