package one.digitalinnovation.personapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Data;
//import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;

@Data
@Builder
@RestController // controlador que vai ser acessado através de uma API REST
@RequestMapping("/people") // caminho de acesso principal da API
public class PersonapiController {

	private PersonRepository personRepository;
	
	@Autowired	
	public PersonapiController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@GetMapping
	public List<Person> listar(){
		return personRepository.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person createPerson(@RequestBody Person person) {
		Person savedPerson = personRepository.save(person);
		return personRepository.save(person);
		//return "API sendo testada";
	}



	public PersonRepository getPersonRepository() {
		return personRepository;
	}



	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
}
