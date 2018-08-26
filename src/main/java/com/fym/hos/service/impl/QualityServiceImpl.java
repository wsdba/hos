package com.fym.hos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fym.hos.dao.QualityRepository;
import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;

@Service
public class QualityServiceImpl implements QualityService {

	@Autowired
	private QualityRepository qualityRepository;

	@Override
	@Transactional
	public void save(TQuality tQuality) {
		qualityRepository.saveAndFlush(tQuality);
	}

	@Override
	public void saveAndUpdate(TQuality tQuality) {
	}

	@Override
	public void delete(String id) {
		qualityRepository.delete(id);
	}

	@Override
	@Transactional
	public void removeMulti(String ids) {
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			qualityRepository.delete(id[i]);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PageDto<TQuality> page(PageQueryDto<TQuality> page) {
		PageRequest pageable = new PageRequest(0, 10);
		Page<TQuality> findAll = qualityRepository.findAll(pageable);
		return new PageDto<TQuality>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
				findAll.getContent());
	}

}
