package com.infy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infy.dto.TerminalDTO;
import com.infy.exception.NoSuchTerminalException;
@Service
public interface TerminalService {
	
	List<TerminalDTO> fetchFTRTerminals() throws NoSuchTerminalException;
	
	
    List<TerminalDTO>  fetchTerminalsByItemType(String itemType);
    
	
    TerminalDTO  insertNewTerminal(TerminalDTO terminalDTO);
    
    
    String updateTerminal(int terminalId, int newCapacity);
    
    
    TerminalDTO fetchFTRTerminalByTerminalId(int terminalId);
    
     String removeTerminal(int terminalId);
}
