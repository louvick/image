import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        String chemin = "image1.pgm";
        String chemin2 = "image1.ppm";
        String originalPPM = "originalPPM.ppm";
        String originalPGM = "originalPGM.pgm";
        String cheminextraire = "extraire.pgm";
        String cheminextraire2 = "extraire.ppm";


        ImageManager im = new ImageManager();


        ImagePGM imagegrise = new ImagePGM();
        ImagePGM imagegrise2 = new ImagePGM();

        ImagePPM imagecouleur = new ImagePPM();
        ImagePPM imagecouleur2 = new ImagePPM();



        //im.lire(imagecouleur, originalPPM);
        //im.lire(imagegrise, originalPGM);

        //test copier

        //im.copier(imagegrise,imagegrise2);
        //im.copier(imagecouleur, imagecouleur2);


        //Test sont_identique
/*
        im.lire(imagegrise,chemin);
        im.lire(imagegrise2,chemin);
        im.lire(imagecouleur,chemin2);
        im.lire(imagecouleur2,chemin2);

        if(im.sont_identiques(imagegrise2,imagegrise)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

        im.ecrire("sadsadsadd.ppm",imagecouleur);
        im.ecrire("sadsadsadd.pgm",imagegrise);
*/


        //Test pivoter90()

        //im.pivoter90(imagecouleur);
        //im.pivoter90(imagegrise);

        //Test noircir_eclaircir

        //im.eclaircir_noircir(imagecouleur, 100);
        //im.eclaircir_noircir(imagegrise, 100);


        //Test reduire

        //im.reduire(imagecouleur);
        //im.reduire(imagegrise);


        //Test extraire

        //im.extraire(imagecouleur,30,30,100,100);
        //im.extraire(imagegrise,40,40,75,75);


        //Test couleur_preponderante

       // im.couleur_preponderante(imagecouleur);
        //im.couleur_preponderante(imagegrise);



        //Écriture
        im.ecrire(chemin2, imagecouleur);
        im.ecrire(chemin, imagegrise);


    }
}