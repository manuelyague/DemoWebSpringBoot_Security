package cl.myague.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.myague.repo.PersonRepo;
import cl.myague.model.Person;

@RestController
@RequestMapping("/person")
public class DemoRestController {
	
	@Autowired
	private PersonRepo personRepo;
	
	//@Autowired
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/* Obtenemos registros del repositorio de datos*/
	@GetMapping
	public List<Person> listPerson(){
		return personRepo.findAll();
	}
	
	/*Creamos un registro en el repositorio de datos*/
	@PostMapping
	public void addPerson(@RequestBody Person person){
		/*bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Person p = new Person();
		p.setIdPerson(person.getIdPerson());
		p.setName(person.getName());
		p.setUsername(person.getUsername());
		System.out.println(person.getPassword());
		p.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));*/
		personRepo.save(person);
	}
	
	/*Actualiza un registro*/
	@PutMapping
	public void updatePerson(@RequestBody Person person){
		personRepo.save(person);
	}
	
	/*Eliminar un registro*/
	@DeleteMapping(value = "/{idPerson}")
	public void deletePerson(@PathVariable("idPerson") Integer idPerson){
		personRepo.deleteById(idPerson);
	}
}
