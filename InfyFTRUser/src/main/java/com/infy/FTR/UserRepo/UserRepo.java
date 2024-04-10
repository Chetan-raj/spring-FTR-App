package com.infy.FTR.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.FTR.UserEntity.UserEntity;
@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {

}
