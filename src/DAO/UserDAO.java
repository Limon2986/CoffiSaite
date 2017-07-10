package DAO;

import entity.User;

/**
 * Created by Администратор on 10.07.2017.
 */
public interface UserDAO {
     boolean saveUser(User saveUser);
    User getUser(int id);
    boolean removeUser(int id);
    boolean updateUser(User date);


}
