public class Main {
    public static void main(String[] args) {
        ImagePGM imagegrise = new ImagePGM();
        String chemin = "Sherbrooke_Frontenac_nuit.pgm";
        imagegrise.lire(chemin);
        PixelPGM[] pixels;
        System.out.println(imagegrise.getPixels());
    }
}