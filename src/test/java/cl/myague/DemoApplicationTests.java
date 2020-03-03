package cl.myague;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cl.myague.model.Person;
import cl.myague.repo.PersonRepo;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	void addPerson() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Person p = new Person();
		p.setIdPerson(1);
		p.setName("Manuel");
		p.setUsername("manuel");
		p.setPassword(bCryptPasswordEncoder.encode("1234"));
		personRepo.save(p);
	}

}
