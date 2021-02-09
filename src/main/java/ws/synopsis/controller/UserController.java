package ws.synopsis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.entity.User;
import ws.synopsis.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("save")
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@GetMapping("/list")
	public List<User> list() {
		return userRepository.findAll();
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id ) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/find/{id}")
	public Optional<User> findId(@PathVariable("id") int id ) {
		return userRepository.findById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody User user) {
		userRepository.save(user);
		
		
	}
}
