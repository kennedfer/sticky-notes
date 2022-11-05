package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class StickyNoteUI extends JDialog {
    public StickyNoteUI(String note, String hexColor) throws IOException, FontFormatException {
        Color primaryColor = new Color(Integer.parseInt(hexColor, 16));

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //noinspection ConstantConditions
        Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Sticky Notes.ttf"));
        ge.registerFont(font);

        JLabel lblNote = new JLabel(("<html><body style=\"text-align: center;  text-justify: inter-word;\">"+note+"</body></html>"));

        lblNote.setFont(font.deriveFont(25f));
        lblNote.setForeground(new Color(0x494949));
        lblNote.setBorder(new EmptyBorder(10,20,40,0));

        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", primaryColor);
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);
        this.getContentPane().setBackground(primaryColor);

        this.add(lblNote);
        this.setAlwaysOnTop(true);
        this.setSize(200,150);
        this.setVisible(true);
    }
}
