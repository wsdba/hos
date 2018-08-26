package com.fym.hos.service;

import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;

public interface QualityService {

	void save(TQuality tQuality);

	@Deprecated
	void saveAndUpdate(TQuality tQuality);

	void delete(String id);

	void removeMulti(String ids);

	PageDto<TQuality> page(PageQueryDto<TQuality> page);

	TQualityDto get(String id);
}
