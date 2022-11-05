package classes;

import com.formdev.flatlaf.FlatDarkLaf;
import ui.StickyNoteUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    private int _indexColor;
    private final String[] _COLORS ={
            "ffb3ba",
            "ffdfba",
            "ffffba",
            "baffc9",
            "bae1ff",
    };

    public static void main(String[] args) throws IOException, AWTException {
        FlatDarkLaf.setup();
        Main m = new Main();
        new IconTray(m).init();
    }

    public void createNewNote() throws IOException, FontFormatException {
        String dialogTitle = "Create new note:";
        String dialogDefaultText = "Learn something...";
        String dialogMsg = "I need remember...";

        Object note = JOptionPane.showInputDialog(null, dialogMsg, dialogTitle, JOptionPane.QUESTION_MESSAGE, null, null, dialogDefaultText);
        if(note!=null && !note.toString().equals("")) new StickyNoteUI(note.toString(), _COLORS[_indexColor % _COLORS.length]);
        _indexColor++;
    }

    public void showRuntimeError(String msg){
        JOptionPane.showMessageDialog(null, msg+"\nRestart the application", "Error:", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
}
