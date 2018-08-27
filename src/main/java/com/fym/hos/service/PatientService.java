package com.fym.hos.service;

import java.util.List;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.entity.TPatient;

public interface PatientService {
	/**
	 * 保存方法
	 * @param tpatient 病例实体
	 * @return
	 */
	TPatientDto save(TPatient tpatient);
	/**
	 * 单条删除
	 * @param id  病例ID
	 */
	void delete(String id);
	/**
	 * 多条删除
	 * @param ids 多条病例IDs
	 */
	void removeMulti(String ids);
	/**
	 * 分页查询，并模糊查询theName(姓名）,也可以不需要条件
	 * @param page     分页条件
	 * @param theName  模糊查询条件
	 * @return
	 */
	PageDto<TPatientDto> page(PageQueryDto<TPatient> page, String theName);
	/**
	 * 根据Id 获取病例实体，返回病例DTO
	 * @param id
	 * @return
	 */
	TPatientDto get(String id);
	/**
	 * 根据姓名，描述 来查询，返回一个病例dto LIST，（用于手机app上面）
	 * @param theName
	 * @return
	 */
	List<TPatientDto> findAll(String theName);
	/**
	 * 分页查询，并模糊查询theName(姓名）
	 * @param page       分页条件
	 * @param theName	 模糊查询条件
	 * @return
	 */
	PageDto<TPatientDto> pageByApp(PageQueryDto<TPatient> page, String theName);
}
