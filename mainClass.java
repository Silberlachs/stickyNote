class mainClass{

    String filePath;
    MasterWindow masterWindow;
    FileHandler filehandler;
    ConfigClass configClass;

    public mainClass(){

        filePath = System.getProperty("user.dir");
        filehandler = new FileHandler(filePath);
        filehandler.loadNotes();
    }
    
    private void buildWindow(){

        masterWindow = new MasterWindow();
        masterWindow.initFileHandle(filehandler);
        masterWindow.createFont();
        masterWindow.initConfig(filehandler.loadConfig());
        masterWindow.buildWindow();
        masterWindow.initializeListeners();

        masterWindow.show();
        masterWindow.loadNotes();
    }

    //TODO: swap colors for active tab
    //TODO: extract logic from masterwindow in sub-functions for clean code practise
    public static void main(String[]args){

        mainClass main = new mainClass();
        main.buildWindow();
    }
}