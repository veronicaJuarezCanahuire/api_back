
package ws.synopsis.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "userSec")
public class UserSecurity {

	@Id
	@Column(name="username", unique = true, nullable = false, length = 45)
	private String username;
	
	@Column(name="password", nullable = false, length = 60)
	private String password;
	
	@Column(name="enable", nullable = false)
	private boolean enable;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public UserSecurity(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}

	public UserSecurity(String username, String password, boolean enable, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.userRole = userRole;
	}

	public UserSecurity() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
