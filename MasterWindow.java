import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class MasterWindow implements ChangeListener{

    JFrame mainWindow;
    JPanel windowPanel, rasterPanel;
    JLabel rasterLabel;
    JTextArea noteArea;
    JSpinner rasterSpinner;
    Font theFont;
    int fontSize;

    public void createFont(){
        fontSize = 20;
        theFont = new Font("Serif", 0, fontSize);
    }


    public void buildWindow() {

        mainWindow = new JFrame("Sticky Nots");
        mainWindow.setSize(400,800);
        
        //TODO: save loaction from last run
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane();
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.add(noteArea = new JTextArea());
        noteArea.setFont(theFont);
        noteArea.setLineWrap(true);

        mainWindow.add(rasterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)), BorderLayout.SOUTH);

        rasterLabel = new JLabel();
        rasterLabel.setText("Set Raster");
        rasterPanel.add(rasterLabel);

        rasterPanel.add(rasterSpinner = new JSpinner());
        rasterSpinner.setValue(20);
        rasterSpinner.setName("rasterSpinner");

    }

    public void initializeListeners(){
        rasterSpinner.addChangeListener(this);
    }

    public void show() {
        mainWindow.repaint();
        mainWindow.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent rasterChange) {

        int tmpval = (int)rasterSpinner.getValue();
        
        if(tmpval < 10) 
        {
            tmpval = 10;
            rasterSpinner.setValue(10);
        }
        else if(tmpval > 40) 
        {
            tmpval = 40;
            rasterSpinner.setValue(40);
        }

        fontSize = tmpval;
        theFont = new Font("Serif", 0, fontSize);
        noteArea.setFont(theFont);
    }
    
}
