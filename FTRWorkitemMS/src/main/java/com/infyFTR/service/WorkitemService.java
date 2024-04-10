package com.infyFTR.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.infyFTR.dto.TerminalDTO;
import com.infyFTR.dto.VehicleDTO;
import com.infyFTR.dto.WorkitemDTO;
import com.infyFTR.dto.WorkitemVehicleDTO;
import com.infyFTR.entity.Workitem;
import com.infyFTR.entity.WorkitemTerminal;
import com.infyFTR.entity.WorkitemVehicle;
import com.infyFTR.exceptions.NoSuchWorkitemException;
import com.infyFTR.repository.WorkitemRepository;
import com.infyFTR.repository.WorkitemTerminalRepository;
import com.infyFTR.repository.WorkitemVehicleRepository;
import com.infyFTR.util.InfyFTRConstants;


@Service
@PropertySource("classpath:ValidationMessages.properties")
public class WorkitemService {
	@Autowired
	private WorkitemRepository workitemRepository;
	@Autowired
	private WorkitemTerminalRepository workitemTerminalRepository;
	@Autowired
	private WorkitemVehicleRepository workitemVehicleRepository;
	@Autowired
	private Environment environment;
	@Autowired
	private RestTemplate restTemplate;
	
	public WorkitemDTO createWorkitem(WorkitemDTO workitemDto)
	{
	   Workitem workitem = workitemDto.createEntity();
	   return WorkitemDTO.valueOf(workitemRepository.saveAndFlush(workitem));
	}
	
	public 	WorkitemVehicleDTO fetchWorkItemStatus(String workitemId)
	{
		return (WorkitemVehicle.prepareWorkitemVehicleDTO(workitemVehicleRepository.getById(workitemId)));
	}
	
	
	public List<String> fetchAvailableHarborLocations(String country)
	{
		
		Workitem workitem = workitemRepository.getBySourceCountry(country);
		List<String> harbourlist = new ArrayList<String>();
		harbourlist.add(workitem.getSelectedHarborLocations());
		return harbourlist;
		
		
	}
	
	public List<WorkitemDTO> fetchWorkItemDetails() throws NoSuchWorkitemException
	{
		List<Workitem> allWorkitem= workitemRepository.findAll();
		List<WorkitemDTO> allWorkitemDTO=new ArrayList<WorkitemDTO>();
		if(allWorkitem.isEmpty())
		{
			throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_NOT_FOUND.toString()));
		}
		else {
		
	   for(Workitem l : allWorkitem)
	   {
		 allWorkitemDTO.add(WorkitemDTO.valueOf(l));  
	   }
	   return allWorkitemDTO;
		}
	}
	
	public 	List<WorkitemDTO>  trackWorkitemByUser(long userId) throws NoSuchWorkitemException
	{
		List<Workitem> allWorkitem= workitemRepository.findByUserId(userId);
		List<WorkitemDTO> allWorkitemDTO=new ArrayList<WorkitemDTO>();
		if(allWorkitem.isEmpty())
		{
			throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_NOT_FOUND.toString()));
		}
		else {
		
	   for(Workitem l : allWorkitem)
	   {
		 allWorkitemDTO.add(WorkitemDTO.valueOf(l));  
	   }
	   return allWorkitemDTO;
		}
	}
	
	public String allocateVehicle(String workitemId,String vehicleNumber)
	{
		
			WorkitemVehicle workitemVehicle =workitemVehicleRepository.getById(workitemId);
			if(workitemVehicle.equals(null))
			{
				return environment.getProperty(InfyFTRConstants.VEHICLE_NOTFOUND.toString());
			
		}
		else
		{
			workitemVehicle.setVehicleNumber(vehicleNumber);
			return environment.getProperty(InfyFTRConstants.VEHICLE_ALLOCATED_SUCCESS.toString());
		}
	}
	
	public String updateWorkItem(String workitemId,WorkitemDTO workitemDTO) throws NoSuchWorkitemException{
		Optional<Workitem> ent=workitemRepository.findById(workitemId);
		if(ent.isPresent()) {
			Workitem ent1=ent.get();
			ent1.setShippingDate(workitemDTO.getShippingDate());
			ent1.setSelectedHarborLocations(workitemDTO.getSelectedHarborLocations());
			workitemRepository.saveAndFlush(ent1);
			String str = environment.getProperty(InfyFTRConstants.WORKITEM_UPDATE_SUCCESS.toString());
			return str;
		}
		else
		throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_NOT_FOUND.toString()));
	}
	
	public WorkitemVehicleDTO fetchWorkitemDetailsByVehicleNumber(String vehicleNumber) throws NoSuchWorkitemException {

		List<WorkitemVehicle> wiVEList = workitemVehicleRepository.findByVehicleNumber(vehicleNumber);
		if (CollectionUtils.isEmpty(wiVEList)) {
			throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.TERMINAL_NOTAVAILABLE.toString()));
		
		}
		WorkitemVehicleDTO wiVDTO = new WorkitemVehicleDTO();
		BeanUtils.copyProperties(wiVEList.get(0), wiVDTO);

		return wiVDTO;
	}
	public String assignTerminalForWorkitem(String workitemId) throws NoSuchWorkitemException{
		Optional<Workitem> temp = workitemRepository.findById(workitemId);
		String terminalId="";
		if (temp.isPresent()) {
			Workitem entity = temp.get();
			WorkitemTerminal t = new WorkitemTerminal();
			t.setTerminalId(terminalId);
			t.setWorkItemId(entity.getWorkitemId());
			workitemTerminalRepository.save(t);
			int temp1;
			if (entity.getQuantity().contains("kg") || entity.getQuantity().contains("lit")) {
				temp1 = Integer.parseInt(entity.getQuantity().split("(?<=\\D)(?=\\d)")[1].trim());
			} else {
				temp1 = Integer.parseInt(entity.getQuantity().trim());
			}
			
			int newCapacity = temp1;
			restTemplate.put("http://TERMINALMS/ftr/terminals/" + terminalId + "/" + newCapacity,
					new TerminalDTO());
		} else {
			throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_NOT_FOUND.toString()));
		}
			
				return environment.getProperty(InfyFTRConstants.WORKITEM_TERMINAL_ALLOCATED.toString())+terminalId;
	}
		
		
		
		
		
		
		
	
	public String allocateVehicle(String workitemId, List<VehicleDTO> vehicleDtoList) throws NoSuchWorkitemException {
		
		Optional<WorkitemVehicle> temp = workitemVehicleRepository.findById(workitemId);
		if (temp.isPresent()) {
			throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_ASSIGNED_WITHVEHICLE.toString()));
		} else {
			Optional<Workitem> t = workitemRepository.findById(workitemId);
			if (t.isPresent()) {
				Workitem toBe = t.get();
				for (VehicleDTO veh : vehicleDtoList) {
					if (veh.getVehicleStatus().equalsIgnoreCase("Active")
							&& veh.getRetireDate().after(toBe.getShippingDate())
							&& veh.getHarborLocation().equals(toBe.getOriginHarborLocation())) {
						int temp1;
						if (toBe.getQuantity().contains("kg") || toBe.getQuantity().contains("lit")) {
							temp1 = Integer.parseInt(toBe.getQuantity().split("(?<=\\D)(?=\\d)")[1].trim());
						} else {
							temp1 = Integer.parseInt(toBe.getQuantity().trim());
						}

						if (veh.getMaxLiftingCapacity() >= temp1) {
							WorkitemVehicle ent = new WorkitemVehicle();
							ent.setWorkItemId(workitemId);
							ent.setVehicleNumber(veh.getVehicleNumber());
							ent.setAssignedWorkItemStatus("InProgress");
							
							workitemVehicleRepository.saveAndFlush(ent);
						}
					}
				}
			} else {
				throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_NOT_FOUND.toString()));

			}
		}
		return environment.getProperty(InfyFTRConstants.WORKITEM_VEHICLE_ALLOCATED.toString());
	}
	public String updateWorkItemStatus(String workitemId, TerminalDTO terminalDto) throws NoSuchWorkitemException {
		Optional<Workitem> workItemEntityOptional = workitemRepository.findById(workitemId);
		if (workItemEntityOptional.isPresent()) {
			Workitem workitemEntity = workItemEntityOptional.get();
			Date today = new Date();
			if (!workitemEntity.getShippingDate().after(today)) {
				Optional<WorkitemVehicle> workitemVehicleEntityOptional = workitemVehicleRepository
						.findById(workitemId);
				if (workitemVehicleEntityOptional.isPresent()) {
					WorkitemVehicle vehicleEntity = workitemVehicleEntityOptional.get();
					vehicleEntity.setAssignedWorkItemStatus("COMPLETED");
					workitemVehicleRepository.save(vehicleEntity);
					
					VehicleDTO vehicleDTO= new VehicleDTO();
					vehicleDTO.setVehicleStatus("Active");
					restTemplate.put("http://VEHICLEMS"+"/ftr/vehicles/"+vehicleEntity.getVehicleNumber(), vehicleDTO);
					
					int temp = 0;
					if (workitemEntity.getQuantity().contains("kg") || workitemEntity.getQuantity().contains("lit")) {
						temp = Integer.parseInt(workitemEntity.getQuantity().split("(?<=\\D)(?=\\d)")[1].trim());
					}else {
						temp = Integer.parseInt(workitemEntity.getQuantity().trim());
					}
					
					Optional<WorkitemTerminal> wiTEOptional = workitemTerminalRepository.findById(workitemId);{
						restTemplate.put("http://TERMINALMS" + "/ftr/terminals/" + wiTEOptional.get().getTerminalId() + "/" + temp,new TerminalDTO());
					}
				} else {
					throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.VEHICLE_NOTFOUND.toString())); 
				}
			}else {
				throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_SHIPPINGDATE_FUTURE.toString())); 
				}
		} else {
			throw new NoSuchWorkitemException(environment.getProperty(InfyFTRConstants.WORKITEM_NOT_FOUND.toString()));
		}
		return environment.getProperty(InfyFTRConstants.WORKITEM_UPDATE_SUCCESS.toString());
	}

}

	
	
	

