package com.fym.hos.service;

import java.util.List;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.entity.TPatient;

public interface PatientService {
	/**
	 * 保存方法
	 */
	TPatientDto save(TPatient tpatient);
	/**
	 * 单条删除
	 */
	void delete(String id);
	/**
	 * 多条删除
	 */
	void removeMulti(String ids);
	/**
	 *  分页查询，并模糊查询theName(姓名）,也可以不需要条件
	 */
	PageDto<TPatientDto> page(PageQueryDto<TPatient> page, String theName);
	/**
	 * 根据Id 获取病例实体，返回病例DTO
	 */
	TPatientDto get(String id);
	/**
	 * 根据姓名，描述 来查询，返回一个病例dto LIST，（用于手机app上面）
	 */
	List<TPatientDto> findAll(String theName);
	/**
	 * 分页查询，并模糊查询theName(姓名）
	 */
	PageDto<TPatientDto> pageByApp(PageQueryDto<TPatient> page, String theName);
}
