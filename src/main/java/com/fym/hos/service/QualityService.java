package com.fym.hos.service;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;

import java.util.List;

public interface QualityService {

	TQualityDto save(TQuality tQuality);

	@Deprecated
	void saveAndUpdate(TQuality tQuality);

	void delete(String id);

	void removeMulti(String ids);

	PageDto<TQualityDto> page(PageQueryDto<TQuality> page,String theName);

	TQualityDto get(String id);

	List<TQualityDto> findAll(String theName);

	PageDto<TQualityDto> pageByApp(PageQueryDto<TQuality> page,String theName);
}
