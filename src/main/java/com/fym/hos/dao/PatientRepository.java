package com.fym.hos.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fym.hos.entity.TPatient;
@Repository
public interface PatientRepository  extends JpaRepository<TPatient,String>,PagingAndSortingRepository<TPatient,String>,JpaSpecificationExecutor<TPatient>{
    TPatient findByHNumber(BigInteger hNumber);
}
