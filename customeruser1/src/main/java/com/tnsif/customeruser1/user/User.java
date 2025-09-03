package com.tnsif.customeruser1.user;

import com.tnsif.customeruser1.role.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Added auto-generation for ID
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false) // ✅ Renamed from 'pass' to 'password'
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "address", nullable = false)
    private String address;

    public User() {}

    public User(int id, String username, String password, String email, Role role, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.address = address;
    }

    // Getters and setters...
    
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + ", address=" + address + "]";
        // ✅ Removed password from toString for security
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}