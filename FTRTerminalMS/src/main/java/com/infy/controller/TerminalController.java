package com.infy.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.ErrorMessage;
import com.infy.dto.TerminalDTO;
import com.infy.exception.NoSuchTerminalException;
import com.infy.service.TerminalService;

@RestController
@RequestMapping("/terminals")
@CrossOrigin
public class TerminalController {
	@Autowired
	private TerminalService terminalService;
	
	
	
	@PostMapping(consumes ="Application/json")
	public ResponseEntity insertNewTerminal(@Valid @RequestBody TerminalDTO terminalDTO,Errors errors)
	{
		
		String response = "";
		
		if (errors.hasErrors())
		{
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
			error.setMessage(response);
			return ResponseEntity.ok(error);
		}
		else {
		 
		return ResponseEntity.ok(terminalService.insertNewTerminal(terminalDTO));
		}
	}
	
	@GetMapping
	public ResponseEntity<List<TerminalDTO>> fetchFTRTerminals() throws NoSuchTerminalException
	{
		
		return ResponseEntity.ok(terminalService.fetchFTRTerminals());
	
	}
	
	@PutMapping(value="/{terminalId}/{newCapacity}")
	public ResponseEntity<String> updateTerminal(@PathVariable("terminalId") int terminalId,@PathVariable("newCapacity") int newCapacity)
	{
		return ResponseEntity.ok(terminalService.updateTerminal(terminalId, newCapacity));
				
	}
	
	@GetMapping(value="/fetchTerminalsByItemType/{itemType}")
	public ResponseEntity<List<TerminalDTO>> fetchTerminalsByItemType(@PathVariable("itemType") String itemType)
	{
		return ResponseEntity.ok(terminalService.fetchTerminalsByItemType(itemType));
	}
	
	@GetMapping(value="/fetchTerminalByTerminalId/{terminalId}")
	public ResponseEntity<TerminalDTO> fetchTerminalByTerminalId(@PathVariable("terminalId") int terminalId)
	{
		return ResponseEntity.ok(terminalService.fetchFTRTerminalByTerminalId(terminalId));
	}
	
	@DeleteMapping(value="/{terminalId}")
	public ResponseEntity<String> removeTerminal(@PathVariable("terminalId")int terminalId)
	{
		return ResponseEntity.ok(terminalService.removeTerminal(terminalId));
	}
}
	
	
	
	
	
	

  
