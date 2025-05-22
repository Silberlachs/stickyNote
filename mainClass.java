class mainClass{

    MasterWindow masterWindow;

    private void buildWindow(){

        masterWindow = new MasterWindow();
        masterWindow.createFont();
        masterWindow.buildWindow();
        masterWindow.initializeListeners();
        masterWindow.show();
    }

    public static void main(String[]args){

        mainClass main = new mainClass();
        main.buildWindow();
    }
}