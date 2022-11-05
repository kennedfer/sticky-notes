package classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class IconTray {
    private final Main _main;
    public IconTray(Main main){
       this._main = main;
    }
    public void init() throws AWTException {
        if(SystemTray.isSupported()) {
            SystemTray sysTray = SystemTray.getSystemTray();

            MenuItem menuItemClose = new MenuItem("Close");
            menuItemClose.addActionListener(e -> System.exit(0));

            PopupMenu popup = new PopupMenu();
            popup.add(menuItemClose);
            Image icon;

            try {
                icon = ImageIO.read(this.getClass().getResource("/images/icon.png"));
            } catch (IllegalArgumentException | IOException e) {
                _main.showRuntimeError("Cant find internal file");
                throw new RuntimeException(e);
            }

            TrayIcon tray = new TrayIcon(icon, "Sticky Notes", popup);
            tray.setImageAutoSize(true);

            tray.addMouseListener(new MouseTrayClick(){
                @Override
                public void mouseClicked(MouseEvent e){
                    try {
                        _main.createNewNote();
                    } catch (IOException | FontFormatException ex) {
                        _main.showRuntimeError("Cant find internal file");
                    }
                }
            });
            sysTray.add(tray);
        }else{
            JOptionPane.showMessageDialog(null, "Cant find system tray", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
