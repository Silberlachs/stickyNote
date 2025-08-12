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

    public ConfigClass loadConfig(){
        return filehandler.loadConfig();
    }

    private void buildWindow(){

        masterWindow = new MasterWindow();
        masterWindow.createFont();
        masterWindow.buildWindow();
        masterWindow.initializeListeners();
        masterWindow.initFileHandle(filehandler);
        masterWindow.initConfig(this.loadConfig());

        masterWindow.show();
        masterWindow.loadNotes();
    }


    public static void main(String[]args){

        mainClass main = new mainClass();
        main.buildWindow();
    }
}