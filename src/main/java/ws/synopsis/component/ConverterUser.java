package ws.synopsis.component;

import org.springframework.stereotype.Component;



import ws.synopsis.entity.User;
import ws.synopsis.model.UserModel;

@Component("ConverterUser")
public class ConverterUser {
	public User converterUserModel2User(UserModel userModel) {
		User user=new User();
		user.setId(userModel.getId());
		user.setName(userModel.getName());
		user.setLastname(userModel.getLastname());
		user.setTelephone(userModel.getTelephone());
		user.setPassword(userModel.getPassword());

		return user;
	}
	
	public UserModel converterUser2UserModel(User user) {
		UserModel userModel=new UserModel();
		userModel.setId(user.getId());
		userModel.setName(user.getName());
		userModel.setLastname(user.getLastname());
		userModel.setTelephone(user.getTelephone());
		userModel.setPassword(user.getPassword());

		return userModel;
	}
}
