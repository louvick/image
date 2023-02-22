/**
 *
 */
public class ImageManager {
    /**
     * Permet de copier des images
     * @param image premiere image
     * @param image2 deuxième image
     */
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

    /**
     *
     * Permet de lire une image avec un fichier
     * @param image une image (liste pixels)
     * @param fichier le nom d'un fichier
     */
    public void lire(Image image, String fichier) {
        if(image instanceof ImagePGM) {
            ImagePGM pgmImage = (ImagePGM) image;
            pgmImage.lire(fichier);
        } else if(image instanceof ImagePPM) {
            ImagePPM ppmImage = (ImagePPM) image;
            ppmImage.lire(fichier);
        }
    }

    /**
     * permet de tourner une image à 90 degree
     * @param image une image (liste pixels)
     */
    public void pivoter90(Image image) {
        if(image instanceof ImagePGM) {
            ImagePGM pgmImage = (ImagePGM) image;
            pgmImage.pivoter90();
        } else if(image instanceof ImagePPM) {
            ImagePPM ppmImage = (ImagePPM) image;
            ppmImage.pivoter90();
        }
    }

    /**
     * permet de savoir si deux images sont identiques
     * @param image1 premiere image
     * @param image2 deuxième image
     * @return boolean
     */
    public boolean sont_identiques(Image image1, Image image2){

        if(image1 instanceof ImagePGM && image2 instanceof ImagePGM){
            ImagePGM pgmImage1 = (ImagePGM) image1;
            ImagePGM pgmImage2 = (ImagePGM) image2;
            return pgmImage2.sont_identiques(pgmImage1);
        }
        else if(image1 instanceof ImagePPM && image2 instanceof ImagePPM){
            ImagePPM ppmImage1 = (ImagePPM) image1;
            ImagePPM ppmImage2 = (ImagePPM) image2;
            return ppmImage2.sont_identiques(ppmImage1);
        }

        return false;
    }

    /**
     * permet d'écrire une image dans un fichier
     * @param fichier nom du fichier
     * @param image image (liste de pixels)
     */
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

    /**
     * permet d'éclaircir ou de noircir des images
     * @param image image (liste de pixels)
     * @param valeur valeur 0-255
     */
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

    /**
     *
     * Cette méthode sert à extraire une plus petite image dans l'image mère. Cette méthode dans le manager gère les deux types d'images
     *
     * @param image image (liste pixels)
     * @param x1 position de coin premier x
     * @param y1 position de coin premier y
     * @param x2 position de coin deuxieme x
     * @param y2 position de coin deuxieme y
     */
    public void extraire(Image image, int x1, int y1, int x2, int y2) {
        if(image instanceof ImagePGM){
            ImagePGM pgmImage = (ImagePGM) image;
            ((ImagePGM) image).extraire(x1, y1, x2, y2);
        }
        else if(image instanceof ImagePPM){
            ImagePPM ppmImage = (ImagePPM) image;
            ((ImagePPM) image).extraire(x1, y1, x2, y2);
        }
    }

    /**
     *
     * Cette méthode va réduire l'image par 4. Ceci veut dire qu'il va prendre des bloques de pixel (2 x 2) calculer la moyenne de la valeur des pixels et en faire une (un pixel avec les moyennes comme valeur
     *
     * @param image image (liste pixels)
     */
    public void reduire(Image image) {
        if(image instanceof ImagePGM){
            ImagePGM pgmImage = (ImagePGM) image;
            ((ImagePGM) image).reduire();
        }
        else if(image instanceof ImagePPM){
            ImagePPM ppmImage = (ImagePPM) image;
            ((ImagePPM) image).reduire();
        }
    }

    /**
     *
     * Cette méthode regarde tous les pixels d'une image et donne la couleur la plus présente dans celle-ci. Cette méthode dans le manager gère les deux types d'images
     *
     * @param image image (liste pixels)
     */
    public void couleur_preponderante(Image image) {
        if(image instanceof ImagePGM){
            ImagePGM pgmImage = (ImagePGM) image;
            System.out.println(((ImagePGM) image).couleur_preponderante());
        }
        else if(image instanceof ImagePPM){
            ImagePPM ppmImage = (ImagePPM) image;
            System.out.println(((ImagePPM) image).couleur_preponderante());
        }
    }
}
