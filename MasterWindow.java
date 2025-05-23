import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

public class MasterWindow implements ChangeListener{

    JFrame mainWindow;
    JPanel windowPanel, rasterPanel;
    JLabel rasterLabel;
    JTextArea noteArea;
    JSpinner fontSizeSpinner;
    Font theFont;
    int fontSize;

    public void createFont(){
        fontSize = 20;
        theFont = new Font("Serif", 0, fontSize);
    }


    public void buildWindow() {

        mainWindow = new JFrame("Sticky Notes");
        mainWindow.setSize(400,800);
        
        //TODO: save loaction from last run
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane();
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.add(noteArea = new JTextArea());
        noteArea.setFont(theFont);
        noteArea.setLineWrap(true);
        noteArea.setBackground(Color.DARK_GRAY);
        noteArea.setForeground(new Color(255,128,0));
        noteArea.setCaretColor(new Color(255,128,0));

        mainWindow.add(rasterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)), BorderLayout.SOUTH);

        rasterPanel.setBackground(Color.DARK_GRAY);

        rasterLabel = new JLabel();
        rasterLabel.setText("Set Font Size");
        rasterLabel.setForeground(new Color(255,128,0));
        rasterPanel.add(rasterLabel);

        rasterPanel.add(fontSizeSpinner = new JSpinner());
        int rasterCounter = fontSizeSpinner.getComponentCount();
        for (int i=0; i<rasterCounter; i++)
        {
            Component subComponent = fontSizeSpinner.getComponent(i);
            if (subComponent instanceof JButton)
            {
                subComponent.setBackground(Color.DARK_GRAY);
                subComponent.setForeground(new Color(255,128,0));
            }
        }

        fontSizeSpinner.getEditor().getComponent(0).setBackground(Color.DARK_GRAY);
        fontSizeSpinner.getEditor().getComponent(0).setForeground(new Color(255,128,0));
        fontSizeSpinner.setBorder(null);
        fontSizeSpinner.setName("fontSizeSpinner");

    }

    public void initializeListeners(){
        fontSizeSpinner.addChangeListener(this);
    }

    public void show() {
        mainWindow.repaint();
        mainWindow.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent rasterChange) {

        int tmpval = (int)fontSizeSpinner.getValue();

        if(tmpval < 10) 
        {
            tmpval = 10;
            fontSizeSpinner.setValue(10);
        }
        else if(tmpval > 40) 
        {
            tmpval = 40;
            fontSizeSpinner.setValue(40);
        }

        fontSize = tmpval;
        theFont = new Font("Serif", 0, fontSize);
        noteArea.setFont(theFont);
    }
    
}
