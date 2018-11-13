package com.javarush.task.task32.task3209.listeners;



import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by 123 on 18.09.2017.
 */
public class UndoMenuListener implements MenuListener {
   private View view;
     private JMenuItem undoMenuItem;
     private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
 boolean isTrueUndo=view.canUndo();

            undoMenuItem.setEnabled(isTrueUndo);
        boolean isTrueRedo=view.canRedo();

        redoMenuItem.setEnabled(isTrueRedo);

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
