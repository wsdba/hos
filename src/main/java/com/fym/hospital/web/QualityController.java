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

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;

@RestController
@RequestMapping("/hos/quality")
public class QualityController {

	@Autowired
	private QualityService qualityService;
	 
	
	@PostMapping("/")
	public GlobalResponse<TQuality> add(@RequestBody TQuality tQuality){
		System.out.println("====");
		System.out.println(tQuality.getTheAge());
		System.out.println(tQuality.getTheName());
		qualityService.save(tQuality);
		return new GlobalResponse<TQuality>(0,"保存成功");
	}
	

	@DeleteMapping("/{id}")
	public GlobalResponse<TQuality> delete(@PathVariable String id ){
		qualityService.delete(id);
		return new GlobalResponse<TQuality>(0,"删除成功");
	}
	
	@GetMapping("/")
	public GlobalResponse<TQuality> page(PageQueryDto<TQuality> page){
		return new GlobalResponse<TQuality>(qualityService.page(page));
	}
	
	
	@GetMapping("/{id}")
	public GlobalResponse<TQualityDto> get(@PathVariable String id){
		return new GlobalResponse<TQualityDto>(qualityService.get(id));
	}
	 
	@PutMapping("/{id}")
	public GlobalResponse<TQuality> update(@PathVariable String id ,@RequestBody TQuality tQuality){
		qualityService.save(tQuality);
		return new GlobalResponse<TQuality>(0,"更新成功");
	}
	
	 
	
}
