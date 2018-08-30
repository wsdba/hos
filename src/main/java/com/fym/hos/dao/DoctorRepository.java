 package com.fym.hos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fym.hos.entity.TDoctor;
@Repository
public interface DoctorRepository  extends JpaRepository<TDoctor,String>,PagingAndSortingRepository<TDoctor,String>,JpaSpecificationExecutor<TDoctor>{
 
	
}
