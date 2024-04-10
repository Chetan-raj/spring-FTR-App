package com.infy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.entity.Terminal;
@Repository
public interface TerminalRepository extends JpaRepository<Terminal,Integer>{
	
	List<Terminal> findByItemType(String itemType);

}
