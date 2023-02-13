import java.io.FileReader;
import java.util.Scanner;
public class Image extends ImageManager{
    private int sizeX;
    private int sizeY;
    private int max;

    private int image[][];

    public Image() {};
    public void lire(String image) {
        try {
            FileReader lecture = new FileReader(image);

            Scanner sc = new Scanner(lecture);

            sc.useDelimiter(" ");
            this.sizeX = sc.nextInt();
            this.sizeY = sc.nextInt();
            this.max = sc.nextInt();
            this.image = new int[sizeX + 1][sizeY + 1];
            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; i < sizeX; i++) {
                    this.image[i][j] = sc.nextInt();
                }
            }
        } catch (java.io.FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (java.io.IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public int getSizeX() {
        return sizeX;
    }

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

    public int[][] getArray() {
        return image;
    }

    public void setArray(int[][] array, int sizeX, int SizeY) {
        this.image = new int[sizeX+1][SizeY+1];
        for(int i=0; i<sizeY; i++) {
            for(int j=0; j<sizeX; j++) {
                this.image[i][j] = array[i][j];
            }
        }
    }
}
