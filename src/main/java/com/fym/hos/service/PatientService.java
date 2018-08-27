package com.fym.hos.service;

import java.util.List;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.entity.TPatient;

public interface PatientService {
	TPatientDto save(TPatient tpatient);

	void delete(String id);

	void removeMulti(String ids);

	PageDto<TPatientDto> page(PageQueryDto<TPatient> page, String theName);

	TPatientDto get(String id);

	List<TPatientDto> findAll(String theName);

	PageDto<TPatientDto> pageByApp(PageQueryDto<TPatient> page, String theName);
}
