package ws.synopsis.controller;

import java.util.List;

import org.apache.coyote.http11.Http11Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
		return new ResponseEntity(userService.addUser(userModel), HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<UserModel>> list() {
		return new ResponseEntity(userService.listarallUser(),HttpStatus.OK) ;
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		return new ResponseEntity("Usuario Eliminado", HttpStatus.OK);
	}


	@PutMapping("/update")
	public ResponseEntity<UserModel> update(@RequestBody UserModel userModel) {
		return new ResponseEntity(userService.update(userModel),HttpStatus.OK) ;

	}


	@GetMapping("/find/{id}")
	public ResponseEntity<UserModel> findId(@PathVariable("id") int id) {

		return new ResponseEntity(userService.findUserModelById(id),HttpStatus.OK);
	}
	

}
