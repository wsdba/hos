package com.fym.hos.service;

import java.util.List;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TDoctorDto;
import com.fym.hos.entity.TDoctor;

/**
 * 医生服务类
 * 
 * @author fym
 * @since 2018-08-26
 */
public interface DoctorService {

	/**
	 * 保存方法
	 */
	TDoctorDto save(TDoctor tDoctor);
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
	PageDto<TDoctorDto> page(PageQueryDto<TDoctor> page, String theName);

	/**
	 * 根据Id 获取医生实体，返回医生DTO
	 */
	TDoctorDto get(String id);

	/**
	 * 根据姓名，描述 来查询，返回一个医生dto LIST，（用于手机app上面）
	 */
	List<TDoctorDto> findAll(String theName);

	/**
	 * 分页查询，并模糊查询theName(姓名）
	 */
	PageDto<TDoctorDto> pageByApp(PageQueryDto<TDoctor> page, String theName);
}
