package ws.synopsis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ws.synopsis.component.ConverterUser;
import ws.synopsis.entity.User;
import ws.synopsis.model.UserModel;
import ws.synopsis.repository.UserRepository;
import ws.synopsis.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Autowired
	@Qualifier("ConverterUser")
	private ConverterUser converterUser;

	@Override
	public UserModel addUser(UserModel userModel) {
		User user=userRepository.save(converterUser.converterUserModel2User(userModel));
		return converterUser.converterUser2UserModel(user);
	}

	@Override
	public List<UserModel> listarallUser() {
		List<User> listUser=userRepository.findAll();
		List<UserModel> listUserModel=new ArrayList<UserModel>();
		
		for(User user: listUser) {
			listUserModel.add(converterUser.converterUser2UserModel(user));
		}
		return listUserModel;
	}

	@Override
	public UserModel findUserModelById(int id) {
		User user=userRepository.findById(id);
		return converterUser.converterUser2UserModel(user);
	}

	@Override
	public void removeUser(int id) {
		User user=userRepository.findById(id);
		if(user!= null) {
			userRepository.delete(user);
		}

	}

	@Override
	public User findUserById(int id) {
		
		return userRepository.findById(id);
	}

	@Override
	public UserModel update(UserModel userModel) {
		User user=userRepository.save(converterUser.converterUserModel2User(userModel));
		return converterUser.converterUser2UserModel(user);
	
	}

}
