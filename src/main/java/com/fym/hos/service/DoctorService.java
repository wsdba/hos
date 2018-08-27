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
	 * @param tDoctor 医生实体
	 * @return
	 */
	TDoctorDto save(TDoctor tDoctor);
	/**
	 * 单挑删除
	 * @param id 单挑删除的医生ID
	 */
	void delete(String id);
	/**
	 * 多条删除
	 * @param ids 删除的多条医生IDS
	 */
	void removeMulti(String ids);
	/**
	 * 分页查询，并模糊查询theName(姓名）,也可以不需要条件
	 * @param page 分页条件
	 * @param theName  查询条件
	 * @return
	 */
	PageDto<TDoctorDto> page(PageQueryDto<TDoctor> page, String theName);
	/**
	 * 根据Id 获取医生实体，返回医生DTO
	 * @param id
	 * @return
	 */
	TDoctorDto get(String id);
	/**
	 * 根据姓名，描述 来查询，返回一个医生dto LIST，（用于手机app上面）
	 * @param theName 查询的条件，可以是名称也可以是描述
	 * @return
	 */
	List<TDoctorDto> findAll(String theName);
	/**
	 * 分页查询，并模糊查询theName(姓名）
	 * @param page 分页条件
	 * @param theName  模糊查询的条件
	 * @return
	 */
	PageDto<TDoctorDto> pageByApp(PageQueryDto<TDoctor> page, String theName);
}
