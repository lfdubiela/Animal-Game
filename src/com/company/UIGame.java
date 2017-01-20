package com.company;

import javax.swing.*;
import java.awt.*;

public class UIGame implements UIGameI {

    private Component frame;

    public UIGame() {
        this.frame = new JInternalFrame();
    }

    @Override
    public void saySomething(String something) {

        JOptionPane.showConfirmDialog(frame,
                something,
                "Jogo dos animais",
                JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public boolean askSomething(String something, Object[] options) {

        if (options == null) {
            options = new String[] {"Sim", "Não"};
        }

        int n = JOptionPane.showOptionDialog(frame,
                something, "Jogo dos animais",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return n == 0;
    }

    @Override
    public String askSomethingInput(String something) {

        String s = (String) JOptionPane.showInputDialog(
                frame,
                something,
                "Jogo dos animais",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        return s;
    }
}
