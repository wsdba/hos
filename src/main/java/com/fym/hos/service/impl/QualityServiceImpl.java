package com.fym.hos.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fym.hos.dao.QualityRepository;
import com.fym.hos.entity.PageQueryDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;

@Service
public class QualityServiceImpl  implements QualityService{

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
		for(int i = 0 ; i<id.length;i++){
			qualityRepository.delete(id[i]);
		}
	}
		
	@Override
	public Page<TQuality> page(PageQueryDto<TQuality> page) {
		PageRequest pageable = new PageRequest(0, 10);
		return qualityRepository.findAll(pageable);
	}
	
	 
	
	
}
