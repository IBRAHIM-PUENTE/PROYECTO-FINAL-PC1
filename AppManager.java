package proyectoabyssrúbrica;

import javax.swing.JFrame;

public class AppManager {

    private static AppManager instance;
    private JFrame mainFrame;

    private AppManager() {
    }

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public void setMainFrame(JFrame frame) {
        this.mainFrame = frame;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }
}
