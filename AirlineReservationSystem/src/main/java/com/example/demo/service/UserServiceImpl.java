package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Users user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid usename or password");
		}
		return new User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public Users save(UserDto userdto) {
		System.out.println(userdto.getEmail());
		System.out.println(userdto.getPassword());
		Users user = new Users(userdto.getUsername(), userdto.getEmail(),
				new BCryptPasswordEncoder().encode(userdto.getPassword()), Arrays.asList(new Role("Role_User")));
		return userRepository.save(user);
	}

	@Override
	public Users getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}