package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

// Morali smo da mu promenimo ime iz usera u user-details jer u H2 User je vec zauzeto za nesto
@Entity(name = "user_details")
public class User {
	
	protected User() {
		
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message = "Name should have atleast 2 characters")
	private String name;
	
	//Ovo @Past znaci da kad unose datum mora uvek da je u proslosti, znaci ne moze da stavi datum koji je u buducnosti
	@Past(message = "Birth Date should be in the past")
	private LocalDate birthDate;
	
	//for a specific user we want to store their posts
	//ovo mappedBy pravimo vezu sa fieldom iz Posts classe koja se zove user
	//Stavljamo @JsonIgnore jer ne zelimo da lista posts bude deo naseg http odgovora useru
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
