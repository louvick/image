import java.io.FileReader;
import java.util.Scanner;
public class Image{
    private int sizeX;
    private int sizeY;
    private int max;
    private String type;

    public Image() {};
    public int getSizeX() {
        return sizeX;
    }

    public void lire(String fichier){}

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
