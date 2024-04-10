package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.dto.TerminalDTO;
import com.infy.entity.Terminal;
import com.infy.exception.NoSuchTerminalException;
import com.infy.repository.TerminalRepository;
import com.infy.util.InfyFTRConstants;
@Service
@PropertySource("classpath:ValidationMessages.properties")
public class TerminalServiceImpl implements TerminalService {
	
	@Autowired
	private TerminalRepository terminalRepository;
	
	@Autowired
	private Environment environment;
	
	
	public List<TerminalDTO> fetchFTRTerminals() throws NoSuchTerminalException
	{
		List<Terminal> allTerminalDetails= terminalRepository.findAll();
		List<TerminalDTO> allTerminalDTODetails=new ArrayList<TerminalDTO>();
		if(allTerminalDetails.isEmpty())
		{
			throw new NoSuchTerminalException(environment.getProperty(InfyFTRConstants.TERMINAL_NOT_FOUND.toString()));
		}
		else {
		
	   for(Terminal l : allTerminalDetails)
	   {
		 allTerminalDTODetails.add(Terminal.prepareTerminalDTO(l));  
	   }
	   return allTerminalDTODetails;
		}
	}
	
	public TerminalDTO  insertNewTerminal(TerminalDTO terminalDTO) 
	{
	  Terminal terminal = TerminalDTO.prepareTerminalEntity(terminalDTO);
	  return Terminal.prepareTerminalDTO(terminalRepository.saveAndFlush(terminal));
	  
	}
	
	public String updateTerminal(int terminalId, int newCapacity) 
	{
		TerminalDTO terminalDTO = Terminal.prepareTerminalDTO(terminalRepository.getById(terminalId));
		if(terminalDTO.getAvailableCapacity() < newCapacity)
		{
			return environment.getProperty(InfyFTRConstants.TERMINAL_CAPACITY_FAILED.toString());
		}
		else if( terminalDTO.getAvailableCapacity() == newCapacity)
		{
			terminalDTO.setStatus("UNAVAILABLE");
			
			terminalRepository.saveAndFlush(TerminalDTO.prepareTerminalEntity(terminalDTO));
			
			return environment.getProperty(InfyFTRConstants.TERMINAL_CAPACITY_FAILED.toString());
		}
		else {
			terminalDTO.setAvailableCapacity(newCapacity);
			terminalRepository.saveAndFlush(TerminalDTO.prepareTerminalEntity(terminalDTO));
			return (environment.getProperty(InfyFTRConstants.TERMINAL_UPDATE_SUCCESS.toString())+terminalDTO.getTerminalId());
		}
		
		
	}
	
	public List<TerminalDTO>  fetchTerminalsByItemType(String itemType)
	{
		List<Terminal> terminalList = terminalRepository.findByItemType(itemType);
		List<TerminalDTO> terminalDTOList = new ArrayList<TerminalDTO>();
		for(Terminal li : terminalList)
		{
			terminalDTOList.add(Terminal.prepareTerminalDTO(li));
		}
		return terminalDTOList;
	}
	
	
	public TerminalDTO fetchFTRTerminalByTerminalId(int terminalId)
	{
		return (Terminal.prepareTerminalDTO(terminalRepository.getById(terminalId)));
	}
	
	
	public String removeTerminal(int terminalId)
	{
		Optional<Terminal> terminal =terminalRepository.findById(terminalId);
		if(terminal.isPresent())
		{
			terminalRepository.deleteById(terminalId);
			return environment.getProperty(InfyFTRConstants.TERMINAL_DELETE_SUCCESS.toString());     
		}
		else
		{
			return (environment.getProperty(InfyFTRConstants.TERMINAL_NOT_FOUND_FOR_ID.toString())+terminalId);
		}
		
	}

}
