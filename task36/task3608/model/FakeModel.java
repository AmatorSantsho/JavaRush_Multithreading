package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 123 on 23.03.2017.
 */
public class FakeModel implements Model {

     private ModelData modelData=new ModelData();
    //private UserService userService  =new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {

        List<User> usr = new ArrayList<>();
        usr.add(new User("Ivan", 1, 1));
        usr.add(new User("Petr", 2, 3));
        usr.add(new User("Isidor", 3, 2));
        modelData.setUsers(usr);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
