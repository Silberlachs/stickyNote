import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

public class MasterWindow implements ChangeListener, DocumentListener, ComponentListener, ActionListener{

    JFrame mainWindow;
    JPanel windowPanel, rasterPanel;
    JLabel rasterLabel;
    JButton tab1,tab2,tab3,tab4,tab5;
    JTextArea noteArea;
    ArrayList<String>noodlez;
    ArrayList<JButton>buttons;
    JSpinner fontSizeSpinner;
    FileHandler fileHandler;
    ConfigClass config;
    Document doc;
    Font theFont;
    int fontSize;

/******************* Class private functions ******************************************/

    private JPanel getTabPanel(){

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttons = new ArrayList<JButton>();

        buttonPanel.add(tab1 = new JButton("1"), BorderLayout.NORTH);
            tab1.setBackground(Color.DARK_GRAY);
            tab1.setForeground(Color.orange);
            tab1.setName("button1");
            tab1.addActionListener(this);
            buttons.add(tab1);

        buttonPanel.add(tab2 = new JButton("2"), BorderLayout.NORTH);        
            tab2.setBackground(Color.DARK_GRAY);
            tab2.setForeground(Color.orange);
            tab2.setName("button2");
            tab2.addActionListener(this);
            buttons.add(tab2);

        buttonPanel.add(tab3 = new JButton("3"), BorderLayout.NORTH);        
            tab3.setBackground(Color.DARK_GRAY);
            tab3.setForeground(Color.orange);
            tab3.setName("button3");
            tab3.addActionListener(this);
            buttons.add(tab3);

        buttonPanel.add(tab4 = new JButton("4"), BorderLayout.NORTH);        
            tab4.setBackground(Color.DARK_GRAY);
            tab4.setForeground(Color.orange);
            tab4.setName("button4");
            tab4.addActionListener(this);
            buttons.add(tab4);

        buttonPanel.add(tab5 = new JButton("5"), BorderLayout.NORTH);        
            tab5.setBackground(Color.DARK_GRAY);
            tab5.setForeground(Color.orange);
            tab5.setName("button5");
            tab5.addActionListener(this);
            buttons.add(tab5);

        return buttonPanel;
    }

    private JTextArea getMainContentArea(){

        noteArea = new JTextArea();
        noteArea.setFont(theFont);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        noteArea.setBackground(Color.DARK_GRAY);
        noteArea.setForeground(new Color(255,128,0));
        noteArea.setCaretColor(new Color(255,128,0));

        noteArea.setBorder(BorderFactory.createCompoundBorder(
                noteArea.getBorder(), 
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));

        return noteArea;
    }

    private JSpinner getRasterSpinner(){

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.getEditor().getComponent(0).setBackground(Color.DARK_GRAY);
        fontSizeSpinner.getEditor().getComponent(0).setForeground(new Color(255,128,0));
        fontSizeSpinner.setBorder(null);
        fontSizeSpinner.setValue(config.getFontSize());
        fontSizeSpinner.setName("fontSizeSpinner");

        return fontSizeSpinner;
    }

    private JPanel getBottomRasterPanel(){

        rasterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rasterPanel.setBackground(Color.DARK_GRAY);

        rasterLabel = new JLabel();
        rasterLabel.setText("Set Font Size");
        rasterLabel.setForeground(new Color(255,128,0));
        rasterPanel.add(rasterLabel);

        rasterPanel.add(getRasterSpinner());
        int rasterCounter = fontSizeSpinner.getComponentCount();

        for (int i=0; i<rasterCounter; i++){
            Component subComponent = fontSizeSpinner.getComponent(i);
            if (subComponent instanceof JButton){
                subComponent.setBackground(Color.DARK_GRAY);
                subComponent.setForeground(new Color(255,128,0));
            }
        }

        return rasterPanel;
    }

/******************** Class public functions **********************************/

    public void createFont(){
        fontSize = 20;
        theFont = new Font("Serif", 0, fontSize);
    }

    public void initFileHandle(FileHandler fileHandler){
        this.fileHandler = fileHandler;
    }

    public void initConfig(ConfigClass config){
        this.config = config;
        if (this.config == null) {
            this.config = new ConfigClass();
        }
    }

    public void buildWindow() {

        mainWindow = new JFrame("Sticky Noodles");
        mainWindow.setSize(config.getWindowSize());
        //no folding in on itself and saving this, big yikes
        mainWindow.setMinimumSize(new Dimension(400,800));

        mainWindow.addComponentListener(this);

        mainWindow.setLocation(config.getWindowPosition());
        mainWindow.getContentPane();
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow.add(getMainContentArea());
        mainWindow.add(getTabPanel(),BorderLayout.NORTH);
        mainWindow.add(getBottomRasterPanel(), BorderLayout.SOUTH);

        doc = noteArea.getDocument();
        doc.addDocumentListener(this);
    }

    public void initializeListeners(){
        fontSizeSpinner.addChangeListener(this);
        noteArea.setDocument(doc);
    }

    public void loadNotes(){
        noodlez= fileHandler.loadNotes();

        //sanity checks
        if(noodlez == null){
            noodlez = new ArrayList<String>();
            noodlez.add("Welcome to noodleZoup");
        }

        if(noodlez.size() < 5){
            for(int c = noodlez.size(); c < 5; c++){
                noodlez.add("");
            }
        }

        noteArea.setText(noodlez.get(config.getActiveTab()));

        buttons.get(config.getActiveTab()).setBackground(Color.orange);
        buttons.get(config.getActiveTab()).setForeground(Color.DARK_GRAY);
    }


    public void show() {
        mainWindow.repaint();
        mainWindow.setVisible(true);
    }

/************************* Class event handlers *****************************************/

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
        config.setFontSize(fontSize);
        fileHandler.serializeConfig(config);
    }

    public void changedUpdate(DocumentEvent e) {
        System.err.println("document change update not supported");
    }

    public void insertUpdate(DocumentEvent e) {
        noodlez.set(config.getActiveTab(), noteArea.getText());
        fileHandler.serializeNotes(noodlez);
    }

    public void removeUpdate(DocumentEvent e) {
        noodlez.set(config.getActiveTab(), noteArea.getText());
        fileHandler.serializeNotes(noodlez);
    }

    public void componentMoved(ComponentEvent arg0) {
        config.setWindowPosition(mainWindow.getLocation());
        fileHandler.serializeConfig(config);
    }

    public void componentResized(ComponentEvent arg0) {
        config.setWindowSize(mainWindow.getSize());
        fileHandler.serializeConfig(config);
    }

    @Override
    public void actionPerformed(ActionEvent buttonEv) {
        int buttonNumber = Integer.parseInt(buttonEv.getActionCommand())-1;

        buttons.get(config.getActiveTab()).setBackground(Color.DARK_GRAY);
        buttons.get(config.getActiveTab()).setForeground(Color.orange);

        buttons.get(buttonNumber).setBackground(Color.orange);
        buttons.get(buttonNumber).setForeground(Color.DARK_GRAY);

        config.setActiveTab(buttonNumber);
        noteArea.setText(noodlez.get(config.getActiveTab()));

        fileHandler.serializeConfig(config);
    }

    //Unused, override from interface
    public void componentShown(ComponentEvent arg0) {System.err.print("");}
    public void componentHidden(ComponentEvent arg0) {System.err.print("");}
    
}

