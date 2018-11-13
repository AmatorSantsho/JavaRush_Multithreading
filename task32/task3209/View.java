package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 123 on 17.09.2017.
 */
public class View extends JFrame implements ActionListener {
    private  Controller controller;
   private JTabbedPane tabbedPane = new JTabbedPane();
   private JTextPane htmlTextPane = new JTextPane();
private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager=new UndoManager();
   private UndoListener undoListener = new UndoListener(undoManager);
    

    public Controller getController() {
        return controller;
    }
    public  void init(){
        initGui();
        FrameListener listener=new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);

    }
    public  void exit(){
        controller.exit();
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public  void initMenuBar(){
        JMenuBar jMenuBar=new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        this.getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

    public View()  {
        try {
            String des=UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(des);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);

        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);

        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);

        }

    }
    public void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);

        }
    }

public boolean canUndo(){

    return  undoManager.canUndo();
}
  public   boolean isHtmlTabSelected(){
       if (tabbedPane.getSelectedIndex()==0)
           return true;
      else
           return false;
    }
    public UndoListener getUndoListener() {
        return undoListener;
    }
    public void resetUndo(){

        undoManager.discardAllEdits();
    }
    public boolean canRedo(){

        return  undoManager.canRedo();
    }

    public  void  selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public  void update(){
       htmlTextPane.setDocument(controller.getDocument());

    }
    public  void  showAbout(){
JOptionPane.showMessageDialog(this,"Version 1.0","Information about programm",JOptionPane.INFORMATION_MESSAGE);
    }
    public  void initEditor(){
        htmlTextPane.setContentType("text/html");

        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));

        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));

        tabbedPane.setPreferredSize(new Dimension(100, 100));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }
    public  void initGui(){
       initMenuBar();
        initEditor();
        pack();
    }
     public void selectedTabChanged(){
       int index=  tabbedPane.getSelectedIndex();
         if (index==0){
          controller.setPlainText(plainTextPane.getText());

         }
         if (index==1){
            plainTextPane.setText(controller.getPlainText());

         }
         resetUndo();
     }
    @Override
    public void actionPerformed(ActionEvent e) {
 String s=e.getActionCommand();
        switch (s){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;

            case "Сохранить":
                controller.saveDocument();
                break;

            case "Сохранить как...":
                controller.saveDocumentAs();
                break;

            case "Выход":
                controller.exit();
                break;

            case "О программе":
                showAbout();
                break;

        }
    }
}
