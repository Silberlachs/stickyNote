import java.awt.Dimension;
import java.awt.Point;

public class ConfigClass {
 
    Dimension windowSize;
    Point windowPosition;
    int fontSize, activeTab;

    public ConfigClass()
    {
        this.windowSize =       new Dimension(400,800);
        this.windowPosition =   new Point(0,0);
        this.fontSize = 20;
        this.activeTab = 0;
    }

    public int getActiveTab(){              return this.activeTab;      }
    public int getFontSize(){               return this.fontSize;       }
    public Point getWindowPosition(){       return this.windowPosition; }
    public Dimension getWindowSize(){       return this.windowSize;     }

    public void setActiveTab(int at){
        this.activeTab = at;
    }

    public void setFontSize(int fs){
        this.fontSize = fs;
    }

    public void setWindowPosition(Point wp){
        this.windowPosition = wp;
    }

    public void setWindowSize(Dimension ws){
        this.windowSize = ws;
    }

}
