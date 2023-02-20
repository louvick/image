public class ImageManager {
    public void copier(Image image, Image image2) {
        image2.setSizeX(image.getSizeX());
        image2.setSizeY(image.getSizeY());
        image2.setMax(image.getMax());
        image2.setType(image.getType());
        if(image instanceof ImagePGM) {
            ImagePGM pgmImage = (ImagePGM) image2;
            ((ImagePGM) image2).setPixels(((ImagePGM) image));
        } else if(image instanceof ImagePPM) {
            ImagePPM ppmImage = (ImagePPM) image2;
            ((ImagePPM) image2).setPixels(((ImagePPM) image));
        }
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

    public void pivoter90(Image image) {
        if(image instanceof ImagePGM) {
            ImagePGM pgmImage = (ImagePGM) image;
            pgmImage.pivoter90();
        } else if(image instanceof ImagePPM) {
            ImagePPM ppmImage = (ImagePPM) image;
            ppmImage.pivoter90();
        }
    }
}
