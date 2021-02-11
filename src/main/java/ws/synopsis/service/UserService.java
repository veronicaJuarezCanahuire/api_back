package ws.synopsis.service;

import java.util.List;

import ws.synopsis.entity.User;
import ws.synopsis.model.UserModel;

public interface UserService {

	public abstract UserModel addUser(UserModel userModel);

	public abstract List<UserModel> listarallUser();

	public abstract UserModel findUserModelById(int id);

	public abstract void removeUser(int id);

	public abstract UserModel update(UserModel userModel);

	// uno mas que devuelva un model de usuario

	public abstract User findUserById(int id);

}
