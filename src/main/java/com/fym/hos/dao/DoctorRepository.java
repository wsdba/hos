 package com.fym.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fym.hos.entity.TDoctor;
import com.fym.hos.entity.TQuality;
@Repository
// 注意这里 ，我多继承了一个，用来模糊条件查
public interface DoctorRepository  extends JpaRepository<TDoctor,String>,PagingAndSortingRepository<TDoctor,String>,JpaSpecificationExecutor<TDoctor>{

	
}
