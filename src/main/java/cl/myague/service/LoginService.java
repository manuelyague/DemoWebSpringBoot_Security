package cl.myague.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.myague.model.Person;
import cl.myague.repo.PersonRepo;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private PersonRepo personRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Person person = personRepo.findByUsername(username);

		/* Lista de Roles de prueba, debe ser tomado de una base de datos */
		List<GrantedAuthority> listGrantedAuthorities = new ArrayList<GrantedAuthority>();
		listGrantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

		UserDetails userDetails = new User(person.getUsername(), person.getPassword(), listGrantedAuthorities);
		return userDetails;
	}

}