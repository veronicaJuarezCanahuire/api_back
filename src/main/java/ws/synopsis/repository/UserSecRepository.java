package ws.synopsis.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.synopsis.entity.UserSecurity;

@Repository("UserSecRespository")
public interface UserSecRepository extends JpaRepository<UserSecurity,Serializable>{

	public abstract UserSecurity findByUsername(String username);
}
