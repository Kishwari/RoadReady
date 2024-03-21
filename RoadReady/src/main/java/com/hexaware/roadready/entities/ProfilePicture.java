package com.hexaware.roadready.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ProfilePicture {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    @SequenceGenerator(name = "profile_seq", sequenceName = "profile_seq", initialValue = 6001)
    private int id;
	
    private int userId;
    
    private String role;
    
    @Lob
    @Column(length = 10485760)  //10mb
    private byte[] content;

	public ProfilePicture() {
		super();

	}

	public ProfilePicture(int id, int userId, String role, byte[] content) {
		super();
		this.id = id;
		this.userId = userId;
		this.role = role;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}