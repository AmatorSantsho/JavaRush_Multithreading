package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.UndoManager;
import java.io.*;

/**
 * Created by 123 on 17.09.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }
public  void init(){
    createNewDocument();

    

}
    public  void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }
   public void resetDocument(){
       if (document!=null){
          UndoListener listener= view.getUndoListener();
           document.removeUndoableEditListener(listener);
           HTMLEditorKit htmlEditorKit=new HTMLEditorKit();
           Document    doc   =       htmlEditorKit.createDefaultDocument();
           document= (HTMLDocument) doc;
doc.addUndoableEditListener(listener);

view.update();

           }
       }
 public  void    setPlainText(String text){
     resetDocument();
     StringReader reader=new StringReader(text);
     HTMLEditorKit htmlEditorKit=new HTMLEditorKit();
     try {
         htmlEditorKit.read(reader,document,0);
     } catch (IOException e) {
         ExceptionHandler.log(e);
     } catch (BadLocationException e) {
         ExceptionHandler.log(e);

     }
 }
  public   String getPlainText(){
      StringWriter writer=new StringWriter();
      HTMLEditorKit htmlEditorKit=new HTMLEditorKit();
      try {
          htmlEditorKit.write(writer,document,0,document.getLength());

      } catch (IOException e) {
          ExceptionHandler.log(e);
      } catch (BadLocationException e) {
          ExceptionHandler.log(e);
      }
      return writer.toString();
  }

    public static void main(String[] args) {
        View v=new View();
        Controller c=new Controller(v);
        v.setController(c);
        v.init();
        c.init();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile=null;
        }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        int ch = chooser.showOpenDialog(view);
        if (ch == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();

            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null) saveDocumentAs();
        else {
            view.selectHtmlTab();
            view.setTitle(currentFile.getName());

            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }

        }

    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        int ch = chooser.showSaveDialog(view);

        if (ch == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
        
        try {
            FileWriter writer = new FileWriter(currentFile);
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);

        }
    }
    }
}
