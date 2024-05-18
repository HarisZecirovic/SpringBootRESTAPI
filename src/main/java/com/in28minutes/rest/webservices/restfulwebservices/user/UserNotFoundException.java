package com.in28minutes.rest.webservices.restfulwebservices.user;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//zelimo da napravimo da ova nasa exception vraca 404 error, to radimo sa @ResponseStatus
//kako nam ne bi ispisivalo mnogo tamo teksta kad uradimo zahtev ovaj, on je u pom.xml komentarisao devtools dependency
// kad pravimo za production ovu applikaciju JAR file, onda se ovaj devtools automatski disabluje
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
