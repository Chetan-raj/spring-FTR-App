package com.infyFTR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyFTR.entity.Workitem;

@Repository
public interface WorkitemRepository extends JpaRepository<Workitem, String> {
	
	Workitem getBySourceCountry(String sourceCountry);
	
	List<Workitem> findByUserId(long userId);
	
}
