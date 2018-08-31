package com.fym.hospital.web;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.entity.TPatient;
import com.fym.hos.service.PatientService;

@RestController
@RequestMapping("/hos/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

    /**
     * 保存
     *
     * @param tPatient     病例实体
     * @return
     */
    @PostMapping("/")
    @CrossOrigin
    public GlobalResponse<TPatient> add(@RequestBody TPatient tPatient) {
        /*TPatientDto tPatientDto = patientService.save(tPatient);
        return new GlobalResponse<TPatientDto>(tPatientDto);*/
    	patientService.save(tPatient); 
          return new GlobalResponse<TPatient>(0, "保存成功");
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public GlobalResponse<TPatient> delete(@PathVariable String id) {
    	patientService.delete(id);
        return new GlobalResponse<TPatient>(0, "删除成功");
    }

    /**
     * 分页
     *
     * @param page         分页条件
     * @param theName      模糊查询条件
     * @return
     */
    @GetMapping("/")
    public Show page(PageQueryDto<TPatient> page, String theName,@RequestParam(name="page") int cPage,@RequestParam(name="limit") int limit) {
     	page.setCurrentPage(cPage-1);
    	page.setPageSize(limit);
//    	System.out.println(new GlobalResponse<TQualityDto>(qualityService.page(page, theName)).getPage().getData().get(1).getTheName());
    	Show show = new Show();
    	List<TPatientDto> tq = new ArrayList<TPatientDto>();
    	GlobalResponse<TPatientDto> g = findAll(theName);
    	tq = new GlobalResponse<TPatientDto>(patientService.page(page, theName)).getPage().getData();
    	show.setCount(g.getData().size());
    	show.setData(tq);
    	return show;
    	}


    /**
     * 查询所有
     *
     * @param theName      模糊查询条件 （可根据名称或描述）
     * @return
     */
    @GetMapping("/findAll")
    public GlobalResponse<TPatientDto> findAll(String theName) {
        return new GlobalResponse<TPatientDto>(patientService.findAll(theName));
    }


    /**
     * 提供给app的分页查询
     *
     * @param page  分页条件
     * @param theName 模糊查询条件
     * @return
     */
    @GetMapping("/pageByApp")
    public GlobalResponse<TPatientDto> pageByApp(PageQueryDto<TPatient> page, String theName) {
        return new GlobalResponse<TPatientDto>(patientService.pageByApp(page, theName));
    }

    /**
     * 提供给app的住院号校验
     *
     * @param hNumber 住院号
     * @return
     */
    @GetMapping("/validTheHNumber")
    public GlobalResponse<TPatientDto> validTheHNumber(BigInteger hNumber) {
        boolean flag  = patientService.validTheHNumber(hNumber);
        if(flag){
            return new GlobalResponse<TPatientDto>(-1,"唯一，不重复");
        }else{
            return new GlobalResponse<TPatientDto>(0,"重复");
        }
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public GlobalResponse<TPatientDto> get(@PathVariable String id) {
        return new GlobalResponse<TPatientDto>(patientService.get(id));
    }

    /**
     * 根据id更新数据
     *
     * @param id
     * @param tPatient     病例实体
     * @return
     */
    @PutMapping("/{id}")
    @CrossOrigin
    public GlobalResponse<TPatient> update(@PathVariable String id, @RequestBody TPatient tPatient) {
    	patientService.save(tPatient);
        return new GlobalResponse<TPatient>(0, "更新成功");
    }


    /**
     * 删除多个
     *
     * @param ids，以逗号分隔。 比如1,2,3
     * @return
     */
    @DeleteMapping("/removeMulti")
    public GlobalResponse<TPatient> removeMulti(String ids) {
    	patientService.removeMulti(ids);
        return new GlobalResponse<TPatient>(0, "删除成功");
    }

 
}
