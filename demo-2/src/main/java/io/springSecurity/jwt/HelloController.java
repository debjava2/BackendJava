package io.springSecurity.jwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.springSecurity.jwt.models.AuthenticationResponse;
import io.springSecurity.jwt.models.AuthenticationdRequest;
import io.springSecurity.jwt.models.DAOUser;
import io.springSecurity.jwt.Repository.CustomerServiceRepo;
import io.springSecurity.jwt.Util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HelloController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtUti jwt;
	@Autowired
	CustomerServiceRepo cutomerservice;

	@GetMapping("/hello")
	public String getMessage() {
		return "Hello World";
	}

	
	@PostMapping("/api/authenticate")
	public ResponseEntity<?> createAuthenticationReponse(@RequestBody AuthenticationdRequest authenticationdRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationdRequest.getUsername(), authenticationdRequest.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Bad Credential");
		}

		final UserDetails userDetials = myUserDetailsService.loadUserByUsername(authenticationdRequest.getUsername());

		final String jwtk = jwt.generateToken(userDetials);

		return ResponseEntity.ok(new AuthenticationResponse(jwtk));

	}

	@PostMapping("/saveCustomerDetails")
	public int  insertUserDetails(@RequestBody DAOUser user) {
		return cutomerservice.insertUserDetaila(user);
	}
	
	@GetMapping("/api/getAllUserRegisterd")
	public List<DAOUser> getAllUserRegisterd(){
		return cutomerservice.getAllUserRegisterd();
	}
}
