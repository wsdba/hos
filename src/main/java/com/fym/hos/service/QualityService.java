package com.fym.hos.service;

import org.springframework.data.domain.Page;

import com.fym.hos.entity.PageQueryDto;
import com.fym.hos.entity.TQuality;

public interface QualityService {

	void save(TQuality tQuality);
	
	@Deprecated
	void saveAndUpdate(TQuality tQuality);
	
	void delete(String id);
	
	void removeMulti(String ids);
	
	Page<TQuality> page(PageQueryDto<TQuality> page);
}
