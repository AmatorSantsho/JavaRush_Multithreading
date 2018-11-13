package com.javarush.task.task30.task3008.client;

import java.io.IOException;

/**
 * Created by 123 on 24.04.2017.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);
    public  class GuiSocketThread extends SocketThread{

        @Override
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            super.clientHandshake();
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    public void run() {
        getSocketThread().run();
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {

     return    view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }
   public ClientGuiModel getModel(){
       return model;
   }

    public static void main(String[] args) {
        ClientGuiController clientGuiController =new ClientGuiController();
        clientGuiController.run();
    }
}
