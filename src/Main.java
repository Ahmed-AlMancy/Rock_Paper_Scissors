import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // allows GUI to be created and updated in a thread-safe manner
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Instantiate the GUI object
                GUI RPS=new GUI();
                //display the GUI
                RPS.setVisible(true);
            }
        });

    }
}