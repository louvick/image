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

    public boolean sont_identiques(Image image1, Image image2){

        if(image1 instanceof ImagePGM && image2 instanceof ImagePPM){
            ImagePGM pgmImage1 = (ImagePGM) image1;
            ImagePGM pgmImage2 = (ImagePGM) image2;
            return sont_identiques(pgmImage1,pgmImage2);
        }
        else if(image1 instanceof ImagePPM && image2 instanceof ImagePPM){
            ImagePPM ppmImage1 = (ImagePPM) image1;
            ImagePPM ppmImage2 = (ImagePPM) image2;
            return sont_identiques(ppmImage1, ppmImage2);
        }

        return false;
    }

    public void ecrire(String fichier, Image image) {
        if(image instanceof ImagePGM){
            ImagePGM pgmImage = (ImagePGM) image;
            try {
                pgmImage.ecrire(fichier);
            }  catch (java.io.FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
        }
        else if(image instanceof ImagePPM){
            ImagePPM ppmImage = (ImagePPM) image;
            try {
                ppmImage.ecrire(fichier);
            }  catch (java.io.FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void eclaircir_noircir(Image image, int valeur) {
        if(image instanceof ImagePGM){
            ImagePGM pgmImage = (ImagePGM) image;
            ((ImagePGM) image).eclaircir_noircir(valeur);
        }
        else if(image instanceof ImagePPM){
            ImagePPM ppmImage = (ImagePPM) image;
            ((ImagePPM) image).eclaircir_noircir(valeur);
        }
    }
}
