package ws.synopsis.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ws.synopsis.entity.UserRole;
import ws.synopsis.entity.UserSecurity;
import ws.synopsis.repository.UserSecRepository;



@Service("UseSecService")
public class UserSecService implements UserDetailsService{

	@Autowired
	@Qualifier("UserSecRespository")
	private UserSecRepository userSecRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSecurity userSec= userSecRepository.findByUsername(username);
		List<GrantedAuthority> authorities =buildAuthorities(userSec.getUserRole());
		return BuildUser(userSec, authorities);
	}

	private User BuildUser(UserSecurity userSec, List<GrantedAuthority> authorities) {
		return new User(userSec.getUsername(), userSec.getPassword(), userSec.isEnable(),
				true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities (Set<UserRole> userRoles){
		Set<GrantedAuthority> auths=new HashSet<GrantedAuthority>();
		for(UserRole userR: userRoles ) {
			auths.add(new SimpleGrantedAuthority(userR.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
		
		
	}
	
}
