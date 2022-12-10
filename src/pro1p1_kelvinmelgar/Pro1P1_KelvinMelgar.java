
package pro1p1_kelvinmelgar;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
public class Pro1P1_KelvinMelgar {

    private static final long serialVersionUID = 34534511L;
    public static void main(String[] args) {
        
        //cambia todo el aspecto del proyecto ^^
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        Menu menu = new Menu();
        menu.setVisible(true);
        
    }
    
}
