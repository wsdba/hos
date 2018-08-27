package com.fym.hospital.web;

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TDoctorDto;
import com.fym.hos.entity.TDoctor;
import com.fym.hos.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public GlobalResponse<TDoctorDto> page(PageQueryDto<TDoctor> page, String theName) {
        return new GlobalResponse<TDoctorDto>(doctorService.page(page, theName));
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
