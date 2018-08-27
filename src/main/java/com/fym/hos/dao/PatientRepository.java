package com.fym.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fym.hos.entity.TDoctor;
import com.fym.hos.entity.TPatient;

public interface PatientRepository  extends JpaRepository<TPatient,String>,PagingAndSortingRepository<TPatient,String>,JpaSpecificationExecutor<TPatient>{

}
