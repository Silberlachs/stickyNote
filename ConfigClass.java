import java.awt.Dimension;

public class ConfigClass {
 
    Dimension windowSize;
    int fontSize;

    public ConfigClass(){
        this.windowSize = new Dimension(0,0);
        this.fontSize = 20;
    }

    public Dimension getWindowSize(){
        return this.windowSize;
    }

    public int getFontSize(){
        return this.fontSize;
    }

    public void setWindowSize(Dimension ws){
        this.windowSize = ws;
    }

    public void setFontSize(int fs){
        this.fontSize = fs;
    }
    
}
