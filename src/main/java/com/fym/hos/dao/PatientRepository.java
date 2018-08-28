package com.fym.hos.dao;

import com.fym.hos.entity.TPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

public interface PatientRepository  extends JpaRepository<TPatient,String>,PagingAndSortingRepository<TPatient,String>,JpaSpecificationExecutor<TPatient>{
    TPatient findByHNumber(BigInteger hNumber);
}
