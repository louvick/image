public class ImageManager {


    public void copier(Image image, Image image2) {
        image2.setSizeX(image.getSizeX());
        image2.setSizeY(image.getSizeY());
        image2.setMax(image.getMax());
        image2.setArray(image.getArray(),image2.getSizeX(),image2.getSizeY());
    }

    public void lire(Image image, String fichier) {
        image.lire(fichier);
    }
}
