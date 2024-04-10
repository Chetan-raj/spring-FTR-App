package com.infyFTR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyFTR.entity.WorkitemTerminal;
@Repository
public interface WorkitemTerminalRepository extends JpaRepository<WorkitemTerminal,String> {

}
