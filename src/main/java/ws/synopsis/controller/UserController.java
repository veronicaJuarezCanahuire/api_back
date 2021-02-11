package ws.synopsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.entity.User;
import ws.synopsis.model.UserModel;
import ws.synopsis.service.UserService;

@RestController
@Controller()
@RequestMapping("/users")
public class UserController {

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userService;

	@PostMapping("/add")
	public void addUser(@RequestBody UserModel userModel) {
		userService.addUser(userModel);
	}

	@GetMapping("/list")
	public List<UserModel> list() {
		return userService.listarallUser();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		userService.removeUser(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody UserModel userModel) {
		userService.update(userModel);

	}

	@GetMapping("/find/{id}")
	public UserModel findId(@PathVariable("id") int id) {

		return userService.findUserModelById(id);
	}

}
