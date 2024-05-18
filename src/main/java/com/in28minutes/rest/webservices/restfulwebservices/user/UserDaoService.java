package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Haris", LocalDate.now().minusYears(26)));
		users.add(new User(++usersCount, "Amela", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Almina", LocalDate.now().minusYears(32)));

	}
	
	

	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		
		return user;
	}

	public User findOne(int id) {

		Predicate<? super User> predicate = user -> user.getId() == id;
		//stavili smo orElse umesto get, jer nam orElse dozvoljava da stavimo neku vrednost ukoliko ne pronadjemo usera sa odgovarajucim id
		return users.stream().filter(predicate).findFirst().orElse(null);

	}
	
	public void deleteById(int id) {

		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);

	}
	
}
