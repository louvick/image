public class PixelPPM {

    private int red;
    private int green;
    private int blue;

    public PixelPPM(int red,int green,int blue) {
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setColor(int red, int green, int blue){
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
}
