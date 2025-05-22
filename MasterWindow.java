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

    public void buildWindow() {

        mainWindow = new JFrame("Sticky Nots");
        mainWindow.setSize(400,800);
        
        //TODO: save loaction from last run
        mainWindow.setLocationRelativeTo(null);
        mainWindow.getContentPane();
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.add(noteArea = new JTextArea());
        noteArea.setFont(new Font("Serif", Font.ITALIC, 20));
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
        System.out.println("debug stateChanged");
    }
    
}
