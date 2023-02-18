public class ImageManager {
    public void copier(Image image, Image image2) {
        image2.setSizeX(image.getSizeX());
        image2.setSizeY(image.getSizeY());
        image2.setMax(image.getMax());
    }

    public void lire(Image image, String fichier) {
        if(image instanceof ImagePGM) {
            ImagePGM pgmImage = (ImagePGM) image;
            pgmImage.lire(fichier);
        } else if(image instanceof ImagePPM) {
            ImagePPM ppmImage = (ImagePPM) image;
            ppmImage.lire(fichier);
        }
    }
}
