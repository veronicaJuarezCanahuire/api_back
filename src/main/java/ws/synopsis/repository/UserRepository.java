package ws.synopsis.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.synopsis.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Serializable>{
	public abstract User findById(int id);
}
