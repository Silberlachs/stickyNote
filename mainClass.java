class mainClass{

    String filePath;
    MasterWindow masterWindow;
    FileHandler filehandler;

    public mainClass(){

        filePath = System.getProperty("user.dir");
        filehandler = new FileHandler(filePath);
        filehandler.loadNotes();
    }


    private void buildWindow(){

        masterWindow = new MasterWindow();
        masterWindow.createFont();
        masterWindow.buildWindow();
        masterWindow.initializeListeners();
        masterWindow.initFileHandle(filehandler);

        masterWindow.show();
        masterWindow.loadNotes();
    }


    public static void main(String[]args){

        mainClass main = new mainClass();
        main.buildWindow();
    }
}

//TODO: save and load text area, switch through 5 text areas