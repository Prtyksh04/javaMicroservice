package com.ncu.college.users.irepository;

import java.util.List;
import com.ncu.college.users.model.User;

public interface IUserRepository {

    public List<User> GetAllUsers();

    public User GetUserById(String userId);

    public int AddUser(User user);

}
