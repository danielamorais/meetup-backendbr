package com.daniela.meetup.interfaces;

import com.daniela.meetup.domains.Client;
import com.daniela.meetup.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@PostMapping("/user")
	public ResponseEntity createNewUser(@RequestBody User user) {
		if (user != null && user.getEmail() != null && user.getPassword() != null && user.getName() != null) {
			Client client = new Client();
			client.setName(user.getName());
			client.setEmail(user.getEmail());
			client.setPassword(user.getPassword());
			clientRepository.save(client);

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
