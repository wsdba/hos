package com.fym.hospital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fym.hos.entity.GlobalResponse;
import com.fym.hos.entity.PageQueryDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;

@RestController
@RequestMapping("/hos/quality")
public class QualityController {

	@Autowired
	private QualityService qualityService;
	 
	
	@PostMapping("/")
	public GlobalResponse<TQuality> add(@RequestBody TQuality tQuality){
		qualityService.save(tQuality);
		return new GlobalResponse<TQuality>();
	}
	

	@DeleteMapping("/{id}")
	public GlobalResponse<TQuality> delete(@PathVariable String id ){
		qualityService.delete(id);
		return new GlobalResponse<TQuality>();
	}
	
	@GetMapping("/")
	public GlobalResponse<TQuality> page(PageQueryDto<TQuality> page){
		qualityService.page(page);
		return new GlobalResponse<TQuality>();
	}
	 
	@PutMapping("/{id}")
	public GlobalResponse<TQuality> update(@PathVariable String id ,@RequestBody TQuality tQuality){
		qualityService.save(tQuality);
		return new GlobalResponse<TQuality>();
	}
	
	 
	
}
