/*
 * package ws.synopsis.entity;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import javax.persistence.Entity; import javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name = "userSec") public class UserSecurity {
 * 
 * 
 * private String username; private String password; private boolean enable;
 * private Set<UserRole> userRole = new HashSet<UserRole>();
 * 
 * public UserSecurity(String username, String password, boolean enable) {
 * super(); this.username = username; this.password = password; this.enable =
 * enable; }
 * 
 * public UserSecurity(String username, String password, boolean enable,
 * Set<UserRole> userRole) { super(); this.username = username; this.password =
 * password; this.enable = enable; this.userRole = userRole; }
 * 
 * public UserSecurity() { }
 * 
 * public String getUsername() { return username; }
 * 
 * public void setUsername(String username) { this.username = username; }
 * 
 * public String getPassword() { return password; }
 * 
 * public void setPassword(String password) { this.password = password; }
 * 
 * public boolean isEnable() { return enable; }
 * 
 * public void setEnable(boolean enable) { this.enable = enable; }
 * 
 * public Set<UserRole> getUserRole() { return userRole; }
 * 
 * public void setUserRole(Set<UserRole> userRole) { this.userRole = userRole; }
 * 
 * 
 * 
 * }
 */