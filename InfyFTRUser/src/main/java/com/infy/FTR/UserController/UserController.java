package com.infy.FTR.UserController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.FTR.UserDTO.LoginDTO;
import com.infy.FTR.UserDTO.UpdateUserDTO;
import com.infy.FTR.UserDTO.UserDTO;
import com.infy.FTR.UserException.NoSuchUserException;
import com.infy.FTR.UserService.UserService;
@PropertySource("classpath:ValidationMessages.properties")
@RestController
@CrossOrigin
@Validated
@RequestMapping("/userProfile")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO ) throws NoSuchUserException{
	
		return ResponseEntity.ok(userService.createUser(userDTO));
				
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId) {
		return ResponseEntity.ok(userService.getUser(userId));
		
		
		
	}
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser( @PathVariable("userId") int userId,@Valid @RequestBody UpdateUserDTO updateUserDTO) throws NoSuchUserException{
		return ResponseEntity.ok(userService.updateUser(userId, updateUserDTO));
	
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser( @PathVariable("userId") Integer userId) throws NoSuchUserException{
		return ResponseEntity.ok(userService.deleteUser(userId));
		
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO ) throws NoSuchUserException{
		System.out.println("reaching controller");
		return ResponseEntity.ok(userService.loginUser(loginDTO));
	}
	


}
