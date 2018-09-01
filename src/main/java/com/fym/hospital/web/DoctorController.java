package com.fym.hospital.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.Show;
import com.fym.hos.dto.TDoctorDto;
import com.fym.hos.entity.TDoctor;
import com.fym.hos.service.DoctorService;

@RestController
@RequestMapping("/hos/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	 


    /**
     * 保存
     *
     * @param tDoctor   医生实体
     * @return
     */
    @PostMapping("/")
    public GlobalResponse<TDoctor> add(@RequestBody TDoctor tDoctor) {
    	doctorService.save(tDoctor);
        return new GlobalResponse<TDoctor>(0, "保存成功");
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public GlobalResponse<TDoctor> delete(@PathVariable String id) {
    	doctorService.delete(id);
        return new GlobalResponse<TDoctor>(0, "删除成功");
    }

    /**
     * 分页
     *
     * @param page        分页条件
     * @param theName     模糊查询条件（姓名）
     * @return
     */
    @GetMapping("/")
    public Show<TDoctorDto> page(PageQueryDto<TDoctor> page, String theName,@RequestParam(name="page") int cPage,@RequestParam(name="limit") int limit) {
    	page.setCurrentPage(cPage-1);
    	page.setPageSize(limit);
//    	System.out.println(new GlobalResponse<TQualityDto>(qualityService.page(page, theName)).getPage().getData().get(1).getTheName());
    	Show<TDoctorDto> show = new Show<TDoctorDto>();
    	List<TDoctorDto> tq = new ArrayList<TDoctorDto>();
    	GlobalResponse<TDoctorDto> g = findAll(theName);
    	tq = new GlobalResponse<TDoctorDto>(doctorService.page(page, theName)).getPage().getData();
    	show.setCount(g.getData().size());
    	show.setData(tq);
        return show;
        }


    /**
     * 查询所有
     *
     * @param theName   模糊查询（姓名或描述）来查询
     * @return
     */
    @GetMapping("/findAll")
    public GlobalResponse<TDoctorDto> findAll(String theName) {
        return new GlobalResponse<TDoctorDto>(doctorService.findAll(theName));
    }


    /**
     * 提供给app的分页查询
     *
     * @param page        分页条件
     * @param theName	 模糊查询条件
     * @return
     */
    @GetMapping("/pageByApp")
    public GlobalResponse<TDoctorDto> pageByApp(PageQueryDto<TDoctor> page, String theName) {
        return new GlobalResponse<TDoctorDto>(doctorService.pageByApp(page, theName));
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public GlobalResponse<TDoctorDto> get(@PathVariable String id) {
        return new GlobalResponse<TDoctorDto>(doctorService.get(id));
    }

    /**
     * 根据id更新数据
     *
     * @param id
     * @param tDoctor      医生实体
     * @return
     */
    @PutMapping("/{id}")
    public GlobalResponse<TDoctor> update(@PathVariable String id, @RequestBody TDoctor tDoctor) {
    	doctorService.save(tDoctor);
        return new GlobalResponse<TDoctor>(0, "更新成功");
    }


    /**
     * 删除多个
     *
     * @param ids，以逗号分隔。 比如1,2,3
     * @return
     */
    @DeleteMapping("/removeMulti")
    public GlobalResponse<TDoctor> removeMulti(String ids) {
    	doctorService.removeMulti(ids);
        return new GlobalResponse<TDoctor>(0, "删除成功");
    }


}
