package com.fym.hos.service;

import java.util.List;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TDoctorDto;
import com.fym.hos.entity.TDoctor;

/**
 * 医生服务类
 * 
 * @author walss
 * @since 2018-08-26
 */
public interface DoctorService {

	
	TDoctorDto save(TDoctor tDoctor);

	void delete(String id);

	void removeMulti(String ids);

	PageDto<TDoctorDto> page(PageQueryDto<TDoctor> page, String theName);

	TDoctorDto get(String id);

	List<TDoctorDto> findAll(String theName);

	PageDto<TDoctorDto> pageByApp(PageQueryDto<TDoctor> page, String theName);
}
