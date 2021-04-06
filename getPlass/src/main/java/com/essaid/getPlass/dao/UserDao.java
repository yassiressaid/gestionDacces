package com.essaid.getPlass.dao;

import java.sql.SQLException;
import java.util.List;
import com.essaid.getPlass.model.User;

public interface UserDao {
	public void addUser(User user) throws ClassNotFoundException, SQLException;

	public void updateUser(User user) throws ClassNotFoundException, SQLException;

	public List<User> listUsers() throws ClassNotFoundException, SQLException;

	public User getUserById(Long id) throws ClassNotFoundException, SQLException;

	public void removeUser(Long id) throws ClassNotFoundException, SQLException;
}
