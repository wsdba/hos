 package com.fym.hos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fym.hos.entity.TQuality;
@Repository
public interface QualityRepository  extends JpaRepository<TQuality,String>,PagingAndSortingRepository<TQuality,String>,JpaSpecificationExecutor<TQuality>{

}
