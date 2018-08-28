package com.fym.hos.service;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;

import java.util.List;

public interface QualityService {
	/**
	 * 保存方法
	 * @param tQuality 质控人员
	 * @return
	 */
	TQualityDto save(TQuality tQuality);

	@Deprecated
	void saveAndUpdate(TQuality tQuality);
	/**
	 * 单条删除
	 * @param id    
	 */
	void delete(String id);
	/**
	 * 多条删除
	 * @param ids  
	 */
	void removeMulti(String ids);
	/**
	 * 分页查询，并模糊查询theName(姓名）,也可以不需要条件
	 * @param page	  分页条件
	 * @param theName 质控人员名称
	 * @return
	 */
	PageDto<TQualityDto> page(PageQueryDto<TQuality> page,String theName);
	/**
	 * 根据Id 获取质控实体，返回医生DTO
	 * @param id
	 * @return
	 */
	TQualityDto get(String id);
	/**
	 * 根据姓名，描述 来查询，返回一个质控dto LIST，（用于手机app上面）
	 * @param theName 查询的名称
	 * @return
	 */
	List<TQualityDto> findAll(String theName);
	/**
	 * 分页查询，并模糊查询theName(姓名）
	 * @param page
	 * @param theName
	 * @return
	 */
	PageDto<TQualityDto> pageByApp(PageQueryDto<TQuality> page,String theName);


}
